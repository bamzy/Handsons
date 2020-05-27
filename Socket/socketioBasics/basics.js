// We nned http because we don't have express
const http = require('http');

//3rd party library install with npm earlier
const socketio = require('socket.io')

//We make an http server with node
const server = http.createServer((request,result) =>{
    result.end("Bye Felicia");
})

const io = socketio(server);
io.on('connection', (socket,req) => {
    socket.emit('welcome','Welcome to the websocket server!!');
    socket.on('my other event', (msg)=> {
        console.log(msg);
    })
});
server.listen(8000);