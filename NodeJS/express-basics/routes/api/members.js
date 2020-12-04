const express  = require('express')
const router = express.Router();
const members = require('../../Members');
router.get('/', (req,res) => {
    // console.log(req.body)
    // res.sendStatus(200);
    // res.send('hey1');
    // res.sendFile(path.join(__dirname,'public','index.html'));
    res.json(members)
});
router.get('/:id', (req,res) => {
    
    var member = members.filter(element => 
        element.id === parseInt(req.params.id)
    );
    if (member.length >= 1 )
        res.json(member);
    else 
        res.sendStatus(400)
});

module.exports = router;