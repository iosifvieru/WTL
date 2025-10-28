const lodash = require("lodash");

const ver = lodash.VERSION;
console.log(ver);

let words = ['sky', 'wood', 'forest', 'water', 'tea', 'laptop'];

// first and last element
let fel = lodash.first(words);
let lel = lodash.last(words);

console.log(`First element: ${fel}`);
console.log(`Last element: ${lel} `);

// nth array elements
// indexing starts from 0
console.log(`3rd element: ${lodash.nth(words, 3)}`);

// 3rd element from the end of the array
console.log(`3rd element from the end: ${lodash.nth(words, -3)}`);

// chunking array

// slits the array in chunks of two elements
let chunk1 = lodash.chunk(words, 2);
console.log(chunk1);

// splits the array in chunks of 3 elements
let chunk2 = lodash.chunk(words, 3);
console.log(chunk2);

// array slice
let c1 = lodash.slice(words, 1, 3);
console.log(c1);

// lodash random number
let r = lodash.random(100);
console.log(r);

// random array element
let random_elem = lodash.sample(words);
console.log(random_elem);

// shuffling array elements
console.log(lodash.shuffle(words));
// console.log(lodash.shuffle(words));
// console.log(lodash.shuffle(words));
// console.log(lodash.shuffle(words));

// times function -> executes a function n times
lodash.times(4, () => {
    console.log(lodash.shuffle(words));
});

// delay function -> delays a function for a amount of time
function foo() {
    console.log("Hello.");
}

lodash.delay(foo, 150);

console.log("World."); // should print before hello;

// range function -> creates an array of numbers
let vals = lodash.range(10);
console.log(vals);

let vals2 = lodash.range(3.14, 6.28, 0.1);
console.log(vals2);

let vals3 = lodash.range(0, 15, 5);
console.log(vals3);

// filter
console.log(lodash.filter(words, (e) => e.length > 5));

// find
let users = [
    {name: 'John', age: 25},
    {name: 'Christopher', age: 30},
    {name: 'Tony', age: 55},
    {name: 'Sil', age: 53}
];

let u1 = lodash.find(users, {name: 'Tony'});
console.log(u1);

