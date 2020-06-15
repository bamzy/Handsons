var Logger = require('./logs/logger');
var logger = new Logger();
logger.on('messageLogged', function (args) {
    console.log(args);
});
logger.log('hello world');
var http = require('http');
var server = http.createServer(function (req, resp) {
    if (req.url === '/') {
        logger.log('Root address accessed');
        resp.write('hello client');
    }
    if (req.url === '/client/api/v1') {
        logger.log('API called');
        resp.write(JSON.stringify([1, 2, 3, 4, 5]));
    }
    resp.end();
});
server.on('connection', function (socket) {
    logger.log(('Client Detected'));
});
server.listen(3000);
