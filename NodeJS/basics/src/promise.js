debugger
async function firstAsync() {
    let promise = new Promise((res, rej) => {
        setTimeout(() => res("Now it's done!"), 1000)
    });

    // wait until the promise returns us a value
    let result = await promise; 
    debugger
    // "Now it's done!"
    console.log('done'); 
    
};
firstAsync();

const crypto = require("crypto");
const start = Date.now();

function logHashTime() {
  crypto.pbkdf2("a", "b", 100000, 512, "sha512", () => {
    console.log("Hash: ", Date.now() - start);
  });
}
logHashTime();
logHashTime();
logHashTime();
logHashTime();
logHashTime();
logHashTime();

var res = ['1','0','1','0','1','1'].map(parseInt);
console.log(res);

var res1 = ['1','2','11','4','5','6'].map((item)=>{
  return parseInt(item,10);
})
console.log(res1);