var Cli = require('./modules/utils/cli');
var cli = new Cli();

const yargs = require('yargs');
const Note = require('./modules/model/Note');
let notes = [];


yargs.command({
    command: 'add',
    describe: 'Add a note',
    builder:{
        title: {
            describe: 'Note Title',
            demandOption: true,
            type: 'string'
        }, body: {
            describe: 'Note Body',
            demandOption: true,
            type: 'string',
            
        }
    },
    handler: function(argv){
        console.log(`title: ${argv.title}, body: ${argv.body}`)
        notes.push(new Note(argv.title,argv.body));

    }
});

yargs.parse();

