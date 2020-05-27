const http = require('http');
const websocket = require('ws')
const server = http.createServer((req,res) => {
    res.end('You are Connected');
});
const wss = new websocket.Server({server})
// triggers when the header is getting ready to be sent to client
wss.on('headers',(headers,req)=>{
    console.log(headers);
});

wss.on('connection',(ws,req)=>{
    ws.send('Welcome to the WS server');
    // console.log(req); 
    ws.on('message', (msg)=>{
        console.log(msg);
    });
})

server.listen(8000)