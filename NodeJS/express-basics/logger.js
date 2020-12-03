//Middleware
const moment = require('moment');
const logger = (req, res, next) =>{
    console.log(`Logger at ${moment().format()}:: ${req.protocol}://${req.get('host')}${req.originalUrl} -> ${JSON.stringify(res.body)}`);
};

module.exports = logger;