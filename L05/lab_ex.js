
var promise = new Promise(function(resolve, reject){
    setTimeout(function(){
        resolve('promise resolved');
    }, 300);
});

promise.then(function(value){
    console.log(value);
});


function resolveAfter2Seconds() {
    return new Promise(resolve => {
            setTimeout(() => {
                resolve('resolved');
            }, 2000);
    });
}

var result = resolveAfter2Seconds();
console.log(result);

var result2 = await resolveAfter2Seconds();
console.log(result);

async function asyncCall(){
    console.log('calling');
    var result = await resolveAfter2Seconds();
    console.log(result);
}

asyncCall();