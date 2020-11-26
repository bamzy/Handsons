
const express = require('express');
const app = express();
const Joi = require('joi');
app.use(express.json());

 


courses = [{id: 1, name: 'Physics'},{id:2, name: 'Math'},{id:3, name: 'AP'}];
app.get('/', (req,resp)=>{
    resp.send('hello world');
});


app.get('/api/courses', (req, res) => {
    res.send(courses);
})


app.get('/api/courses/:id', (req, res) => {    
    course = courses.find((c)=> c.id === parseInt(req.params.id))
    if (!course)
        res.status(404).send('The course was not found'); //404 error
    res.send(course);
})


app.post('/api/course',(req,res) => {
    const {error} = validateCourse(req.body);
    if ( error !== null ){
        res.status(400).send(error.details[0].message);
        return;
    }
    const course = {id: courses.length+1, name: req.body.name};
    courses.push(course);
    res.send(course);
});


app.put('/api/courses/:id', (req, res) => {
    
    const {error} = validateCourse(req.body);
    if ( error !== null ){
        res.status(400).send(error.details[0].message);
        
    }
    course = courses.find((c)=> c.id === parseInt(req.params.id))
    if (!course)
        return res.status(404).send('The course was not found'); //404 error
    course.name = req.body.name;
    res.send(course);
})

const port = process.env.PORT || 3000;
app.listen(port, ()=>{
    console.log(`listening on port ${port}...`);
});


function validateCourse(course){
    const schema = {
        name: Joi.string().alphanum().min(3).max(5).required()
    };
    return Joi.validate(course,schema)
}