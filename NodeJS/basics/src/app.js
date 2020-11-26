var Cli = require('./utils/cli');
var cli = new Cli();

const yargs = require('yargs');
const Note = require('./model/Note');
const NoteControlelr = require('./controller/NoteController');
const noteControlelr = new NoteControlelr();

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
        noteControlelr.addNote(new Note(argv.title,argv.body));

    }
});

yargs.command({
    command: 'remove',
    describe: 'Delete a note',
    builder:{
        title: {
            describe: 'Note Title',
            demandOption: true,
            type: 'string'
        }
    },
    handler: function(argv){
        console.log(`Delete with title: ${argv.title} & body: ${notes.find(element => element.title === argv.title)}`)
        
    }
});

yargs.command({
    command: 'list',
    describe: 'List all notes',
    handler: function(argv){
        console.log(noteControlelr.getNotes());
        
    }
});

yargs.parse();

