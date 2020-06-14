const Logger = require('./logs/logger')
const logger = new Logger();


logger.on('messageLogged',(args)=>{
    console.log(args);
})
logger.log('hello world')