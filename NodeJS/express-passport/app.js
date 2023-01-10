const express = require('express');
const session = require('express-session');
const mongoose = require('mongoose');

const MongoStore = require('connect-mongo');
const {Schema} = require("mongoose");

require('dotenv').config()



const app = new express();


const mongoSessionStore =  MongoStore.create({
     mongoUrl: process.env.DB_URL
});

mongoose.connect(process.env.DB_URL);
const db = mongoose.connection;
db.on("error", console.error.bind(console, "connection error: "));
db.once("open", async function () {
    console.log("DB Connected successfully");
    const User = mongoose.model('bamdads', Schema({

        name: String
    }));



    const all = await User.find();
    console.log(all);
});
const firstMW = function(req,res,next){
    // res.send('<h2>first</h2>');
    console.dir('first middleware session:');
    console.log(req.session);
    req.customField = 'bamdad';

    next();
}
const secondMW = (req,res,next) => {
    // res.send('<h2>first</h2>');
    console.log('second middleware');

    console.log(req.session);
    req.customField += ' Kordi' ;
    next();
}
const errHandlerMW = (err, req,res,next) =>{
    if(err) {
        res.send('This error happened'+err);
        console.log("This error happened:" + err);
    }
}


app.use(firstMW); //global middleware
app.use(secondMW); //global middleware
app.use(express.urlencoded({extended:true})) //this is very convenient
app.use(express.json()) //this is very convenient

app.use(session({
    secret: 'keyboard cat',
    resave: false,
    saveUninitialized: true,
    cookie: {
        secure: false,
        maxAge: 5*1000 //in milisecond
    },
    store: mongoSessionStore
}))
app.get('/',(req,res)=>{ //route specific middleware
    console.log('main middleware session');
    if (!req.session.myfield) req.session.myfield = 0;
    req.session.myfield++;
    console.log(req.session);
    res.send(`<h1>sanity check ${req.session.myfield}</h1>`);
})
app.listen(3001,()=>{
    console.log('app is running');
})
app.use(errHandlerMW); //global middleware for error handling comes last