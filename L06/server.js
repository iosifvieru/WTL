import express from 'express';
import fs from 'fs';

const app = express();
const PORT = 8080;

app.use(express.static('public'));
app.use(express.json());

// useful functions

function loadCustomers(cb){
    fs.readFile('customers.json', (err, data) => {
        if(err){
            return cb(err);
        }

        try {
            const customers = JSON.parse(data);
            cb(null, customers);
        } catch(parseErr){
            cb(parseErr);
        }
    });
}

function findCustomer(customers, custId){
    return new Promise((resolve, reject) => {
        const client = customers.find(c => c.custId === custId);

        if(!client){
            return reject(client);
        }

        return resolve(client);
    });
}

const customers = await new Promise((resolve, reject) => {
    loadCustomers((err, list) => (err ? reject(err) : resolve(list)));
});

console.log(customers);

const allowedOps = ['retrage', 'depunere'];

async function processTransaction(id, op, value) {
    if (!id || !op || isNaN(value) || Number(value) <= 0) {
        return {
            ok: false,
            message: "Datele sunt invalide."
        };
    }

    if (!allowedOps.includes(op.toLowerCase())) {
        return {
            ok: false,
            message: "Operatie invalida."
        };
    }

    try {
        const client = await findCustomer(customers, id);

        if (op === 'retrage') {
            if (client.sold - value < 0) {
                return {
                    ok: false,
                    message: 'Fonduri insuficiente.'
                };
            }

            client.sold -= Number(value);
            return {
                ok: true,
                message: `Client ${client.name} (${client.custId}) a retras ${value} lei. Sold actualizat: ${client.sold}.`
            };
        }

        if (op === 'depunere') {
            client.sold += Number(value);
            return {
                ok: true,
                message: `Client ${client.name} (${client.custId}) a depus ${value} lei. Sold actualizat: ${client.sold}.`
            };
        }

    } catch (err) {
        return {
            ok: false,
            message: "Client necunoscut."
        };
    }
}


// routes
app.get('/transaction', async (req, res) => {
    const customerId = req.query.customerId;
    const opType = req.query.opType;
    const value = Number(req.query.value);

    const result = await processTransaction(customerId, opType, value);
    res.json(result);
});


app.get('/health', (req, res) => {
    res.contentType('application/json');
    res.send({
        "health": "healthy"
    });
});

app.listen(PORT, () => {
    console.log(`Server is running on PORT ${PORT}.`);
});