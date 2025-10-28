const fs = require('fs');

// ex 2
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

var readFilePromise = readFileAsArray('numbers.txt');

readFilePromise.then(function(result){
    console.log(result);
}).catch(function(err){
    console.log(err);
});

// readFilePromise.then(result => {
//     console.log(result);
// }).catch(err => {
//     console.log(err);
// });

// ex 3
async function readFileAsArrayAsync(filename){
    const lines = await readFileAsArray(filename);
    return lines;
};

var result2 = readFileAsArrayAsync('numbers.txt');
console.log("result2: " + result2);

result2.then((result) => {
    console.log(result);
});