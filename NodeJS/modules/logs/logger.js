const EventEmitter = require('events');


url = 'http://www.google.com/log';

class Logger extends EventEmitter {
    log(message){
        console.log(`message logged: ${message}`);
        this.emit('messageLogged',{id:3});
    }    
}
module.exports = Logger;

