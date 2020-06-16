const EventEmitter = require('events');
const chalk = require('chalk');
const Moment = require('moment');
const fs = require('fs');
const mongoose = require('mongoose');






url = 'http://www.google.com/log';

class Logger extends EventEmitter {
    constructor(){
        super();
        mongoose.connect('mongodb://localhost:27017/flights', {useNewUrlParser: true, useUnifiedTopology: true});
        
        this.Log = mongoose.model('Log', { msg: String, date: String });
        this.moment = Moment();
    }
    log(message){
        console.log(chalk.blueBright(`message logged => ${message}`));
        const log = new this.Log({ msg: message , date: this.moment.format('YYYY-MM-DD hh:mm:ss')});
        log.save();
        this.logFile(message);

    }
    logFile(message){
        fs.appendFile('logs.txt', `file logged at ${this.moment.format('YYYY-MM-DD hh:mm:ss')} => ${message} \n`,(err)=>{
            if (err) throw err;
        })
    }
}
module.exports = Logger;

