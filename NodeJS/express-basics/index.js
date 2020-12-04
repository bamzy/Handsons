const express = require('express');
const path = require('path');
const logger = require('./middleware/logger')

const app = express();

// Allow JSON
app.use(express.json());

//Use Logger as Middleware
app.use(logger);

//Set Static Folder
app.use(express.static(path.join(__dirname,'public')));

app.use('/api/members', require('./routes/api/members'));
const PORT = process.env.PORT || 5000;


app.listen(PORT, () => console.log(`Server Started on ${PORT}`))
