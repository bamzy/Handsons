// const express = require('express');
// const app = express();
// app.use(express.static(__dirname+'/'));
// app.listen(9000);
// console.log('done');


const https = require('https');

https.get('https://coderbyte.com/api/challenges/json/rest-get-simple', (resp) => {
  
  let data = '';
  let hobbies = ''

  resp.on('data', (chunk) => {
    data += chunk;
  }); 

  resp.on('end', () => {
      let hobbies = JSON.parse(data).hobbies
    hobbies.map((hobby)=>{
        hobbies = hobbies + hobby 
    });
});

console.log(hobbies)
 
});