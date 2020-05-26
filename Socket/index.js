const app = require("express")();
const http = require("http").createServer(app);
const io = require("socket.io")(http);
app.get("/", (req, res) =>
    res.sendFile(__dirname + "/index.html"));

io.on('connection', (socket) => {
    io.emit('broadcast','welcom to Our Group');
    socket.on('chat message', (msg) => {
        io.emit('chat message', msg);
      });
    socket.on('typing status', (msg) => {
        if (msg)
            io.emit('typing status', "Someone is typing");
            else
            io.emit('typing status', "...");
    });
});
    
http.listen(3000, () => console.log("listening on http://localhost:3000"));