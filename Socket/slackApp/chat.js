const express = require("express");
const app = express();
const socketio = require("socket.io");

app.use(express.static(__dirname+'/public'))

const expressServer = app.listen(8000);
const io = socketio(expressServer);
io.on('connection', (socket) => {
    io.emit('broadcastFromServer','Welcom to Our Group');
    socket.on('chat message', (msg) => {
        io.emit('chat message', msg);
      });
    socket.on('typing status', (msg) => {
        if (msg)
            socket.broadcast.emit('typing status', "Someone is typing");
            else
            socket.broadcast.emit('typing status', "...");
    });
});  