const express = require('express');
const app = express();
app.use(express.static(__dirname+'/'));
app.listen(9000);
console.log('done');