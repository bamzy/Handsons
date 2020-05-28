$(function () {
    var socket = io();
    $('form').submit(function(e){
      e.preventDefault(); // prevents page reloading
      socket.emit('chat message', $('#m').val());
      $('#m').val('');
      $('#infoMessage').text('...');
      return false;
    });
    socket.on('chat message', function(msg){
      $('#messages').append($('<li>').text(msg));
    });
    socket.on('typing status', function(msg){
      $('#infoMessage').text(msg);
  });
  
  $('#m').keydown(function (e){
      socket.emit("typing status",true)
  });
  $('#m').keyup(function (e){
      socket.emit("typing status",false)
  });
  socket.on('broadcastFromServer', function(msg){
      $('#infoMessage').text(msg);

    });
  });
