const express = require("express");
const app = express();
const socketio = require("socket.io");

app.use(express.static(__dirname+'/public'))

const expressServer = app.listen(8000);
const io = socketio(expressServer);
io.on('connection', (socket) => {
    io.of('/').emit('broadcastFromServer','Welcom to Our Group');
    socket.on('chat message', (msg) => {
        io.of('/').emit('chat message', {message: msg, sender:socket.id});
      });
    socket.on('typing status', (msg) => {
        if (msg.status)
            socket.broadcast.emit('typing status', msg.id + " is typing");
        else
            socket.broadcast.emit('typing status', "...");
    });
});  