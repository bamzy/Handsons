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
        let notes  = this.getNotes()
        let duplicates = notes.filter((nt)=>{
            if (nt.title === note.title)
                return true;
        })
        if (duplicates.length === 0){
            notes.push({title:note.title,body:note.body})
            fs.writeFileSync(fileName,JSON.stringify(notes));
        }
    }
}

module.exports = NoteController;