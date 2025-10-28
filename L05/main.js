const { readFileAsArray, asyncFileRead, readFileWithEmitter } = require('./readAsyncFiles');
const { checkForTrianglePromise } = require('./checkTriangle');

// read file data
var data1 = readFileAsArray('numbers.txt');

data1.then(value => {
    console.log("reading from readFileAsArray: ");
    console.log(value);
}).catch(err => {
    console.log(err);

    throw err;
})

var data2 = asyncFileRead('numbers.txt');

data2.then(value => {
    console.log("reading from asyncFileRead: ");
    console.log(value);
}).catch(err => {
    console.log(err);

    throw err;
})

var data3 = readFileWithEmitter('numbers.txt');

const arr = []

data3.on('line', (line) => {
    arr.push(line);
});

data3.on('error', err => {
    console.log(err);
});

data3.on('end', count => {
    console.log("readFileWithEmitter ended with arr length: ", count);
    console.log(arr);
});

// triangle check

const triangle1 = checkForTrianglePromise(1, 2, 3);
triangle1.then(value => {
    console.log(value);
}).catch(err => {
    console.log(err);
});

const triangle2 = checkForTrianglePromise(3, 2, 3);
triangle2.then(value => {
    console.log(value);
}).catch(err => {
    console.log(err);
});