const fs = require('fs')
const fileName = 'notes.json'
class NoteController {
    getNotes(){
        try{
            var dataBuffer = fs.readFileSync(fileName);
            return JSON.parse(dataBuffer.toString());
        } catch (e){
            return [];
        }
    }

    addNote(note){
        let res  = this.getNotes()
        res.push({title:note.title,body:note.body})
        fs.writeFileSync(fileName,JSON.stringify(res));
    }
}

module.exports = NoteController;