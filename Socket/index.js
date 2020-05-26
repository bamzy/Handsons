const app = require("express")();
const http = require("http").createServer(app);
const io = require("socket.io")(http);
app.get("/", (req, res) => res.sendFile(__dirname + "/index.html"));
io.on("connection", function(socket) {
    console.log("socket connected");
   });
http.listen(3000, () => console.log("listening on http://localhost:3000"));