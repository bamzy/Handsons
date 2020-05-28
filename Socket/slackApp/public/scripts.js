$(function () {
    var socket = io('http://localhost:8000'); //the / is a namespace
    var socketAdmin = io('http://localhost:8000/admin'); //the /admin is a namespace
    var socketMarketing = io('http://localhost:8000/marketing'); //the /marketing is a namespace
    $('form').submit(function (e) {
        e.preventDefault(); // prevents page reloading
        socket.emit('chat message', $('#m').val());
        $('#m').val('');
        $('#infoMessage').text('...');
        return false;
    });
    socket.on('chat message', function (msg) {
        $('#messages').append($('<li>').text(msg.sender + ":" + msg.message));
    });
    socket.on('typing status', function (msg) {
        $('#infoMessage').text(msg);
    });

    $('#m').keydown(function (e) {
        socket.emit("typing status", { status: true, id: socket.id })
    });
    $('#m').keyup(function (e) {
        socket.emit("typing status", { status: false, id: socket.id })
    });
    socket.on('broadcastFromServer', function (msg) {
        $('#infoMessage').text(msg);

    });
});
