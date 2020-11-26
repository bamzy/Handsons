const yargs = require('yargs');
const Note = require('../model/Note');
class Cli {
    constructor(){
        yargs.version('0.1.0');
        this.command = yargs.argv;
    }
    getCommand(){
        return this.command
    }
    setHandler(){
       
    }
}
module.exports = Cli