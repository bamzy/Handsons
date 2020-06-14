const Logger = require('./logs/logger')
const logger = new Logger();


logger.on('messageLogged',(args)=>{
    console.log(args);
})
logger.log('hello world')


const http = require('http');
const server = http.createServer((req,resp)=>{
    if (req.url === '/'){
        resp.write('hello client');
    }
    if (req.url === '/client/api/v1'){
        resp.write(JSON.stringify([1,2,3,4,5]));
        
    }
    resp.end();
});
server.on('connection',(socket)=>{
    console.log('Client Detected');
})




server.listen(3000);