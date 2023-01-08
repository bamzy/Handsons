const express = require('express');
const app = new express();

const firstMW = function(req,res,next){
    // res.send('<h2>first</h2>');
    console.dir('first middleware, req:');
    req.customField = 'bamdad';

    next();
}
const secondMW = (req,res,next) => {
    // res.send('<h2>first</h2>');
    console.log('second middleware, req:'+req);
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
app.get('/',(req,res)=>{ //route specific middleware
    console.log('main middleware');
    console.log(req.customField);
    res.send('<h1>sanity check</h1>');
})
app.listen(3001,()=>{
    console.log('app is running');
})
app.use(errHandlerMW); //global middleware for error handling comes last
