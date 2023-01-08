const express = require('express');
const app = new express();

const firstMW = function(req,res,next){
    // res.send('<h2>first</h2>');
    console.log('first middleware');
    next();
}
const secondMW = function(req,res,next){
    // res.send('<h2>first</h2>');
    console.log('second middleware');
    next();
}
app.use(secondMW); //global middleware
app.get('/',firstMW,(req,res)=>{
    console.log('main middleware');
    res.send('<h1>sanity check</h1>');
})
app.listen(3000,()=>{
    console.log('app is running');
})