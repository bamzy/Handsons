const Logger = require('./logs/logger')
const logger = new Logger();


logger.on('messageLogged',(args)=>{
    console.log(args);
})
logger.log('hello world')



const http = require('http');
const server = http.createServer((req,resp)=>{
    if (req.url === '/'){
        logger.log('Root address accessed')
        resp.write('hello client');
    }
    if (req.url === '/client/api/v1'){
        logger.log('API called')
        resp.write(JSON.stringify([1,2,3,4,5]));
    }
    resp.end();
});
server.on('connection',(socket)=>{
    logger.log(('Client Detected'));
})




server.listen(3000);