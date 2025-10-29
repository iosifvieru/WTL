// check if three values can be a triangle using Callback, Promise, Async, EventEmitter.
const EventEmitter = require('events');

function calculateTriangleArea(a, b, c){
    const p = (a + b + c) / 2;
    return Math.sqrt(p * (p - a) * (p - b) * (p - c));
}

function calculateTriangleType(a, b, c){
    if(a == b || b == c || a == c) {
        return "Triunghi isoscel";
    }

    if(a == b && a == c) {
        return "Triunghi echilateral";
    }

    return "Triunghi oarecare";
}

function checkForTrianglePromise(a, b, c) {
    return new Promise((resolve, reject) => {
        if(a < 0 || b < 0 || c < 0){
            reject("A, B or C are not positive integers.");
        }

        if(a + b <= c || a + c <= b || b + c <= a){
            reject(`(${a}, ${b}, ${c}) is not a triangle.`);
        }

        const area = calculateTriangleArea(a, b, c);
        const perimeter = a + b + c;
        const type = calculateTriangleType(a, b, c);

        resolve("Area: " + area + " Perimeter: " + perimeter + " Triangle Type: " + type);
    });
};

async function checkForTriangleAsync(a, b, c){
    var result = await checkForTrianglePromise(a, b, c);
    return result;
};

function checkForTriangleEventEmitter(a, b, c){
    const emitter = new EventEmitter();
    
    if(a < 0 || b < 0 || c < 0){
        emitter.emit('err', "A, B, C are not positive numbers.");
     }

    if(a + b <= c || a + c <= b || b + c <= a){
        emitter.emit('err', `(${a}, ${b}, ${c}) is not a triangle.`);
    }

    const area = calculateTriangleArea(a, b, c);
    const perimeter = a + b + c;
    const type = calculateTriangleType(a, b, c);

    emitter.emit('result', "Area: " + area + " Perimeter: " + perimeter + " Triangle Type: " + type);
    return emitter;
}

module.exports = {
    checkForTrianglePromise,
    checkForTriangleAsync,
    checkForTriangleEventEmitter
}