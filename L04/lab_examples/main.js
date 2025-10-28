
var a = require('./myModule');

var b = require('./myModule');

console.log(a.var1);
console.log(b.var1);

b.var2 = 5;
console.log(b.var2);