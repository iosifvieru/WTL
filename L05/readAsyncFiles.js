// read async files using Promise, async and EventEmitter
const fs = require('fs');
const EventEmitter = require('events');

// read using Promise
function readFileAsArray(filename) {
    return new Promise(function(resolve, reject) {
        fs.readFile(filename, function(err, data){
            if(err){
                return reject(err);
            }

            const lines = data.toString().trim().split('\n');
            resolve(lines);
        });
    });
}

// read using async call
async function asyncFileRead(filename) {
    const lines = await readFileAsArray(filename);
    return lines;
}

function readFileWithEmitter(filename) {
    const emitter = new EventEmitter();
    
    fs.readFile(filename, (err, data) => {
        if(err){
            emitter.emit('error', err);
            return;
        }

        const lines = data.toString().trim().split('\n');

        for(const line in lines){
            emitter.emit('line', line);
        }

        emitter.emit('end', lines.length);
    });

    return emitter;
}

module.exports = {
    readFileAsArray,
    asyncFileRead,
    readFileWithEmitter
};