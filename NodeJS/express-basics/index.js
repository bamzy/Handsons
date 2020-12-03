const express = require('express');
const path = require('path');
const members = require('./Memebers');
const logger = require('./logger')
const moment = require('moment');

const app = express();
app.use(express.json());


app.use(logger);

//Set Static Folder
app.use(express.static(path.join(__dirname,'public')));
const PORT = process.env.PORT || 5000;

app.get('/api/members', (req,res) => {
    console.log(req.body)
    // res.sendStatus(200);
    // res.send('hey1');
    // res.sendFile(path.join(__dirname,'public','index.html'));
    res.json(members)
})

app.listen(PORT, () => console.log(`Server Started on ${PORT}`))
