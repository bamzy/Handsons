import React from 'react'
const person = (props) => {
    return (
        <div className='item'> 
            <h1>Name: {props.name}</h1>
            <h2>Age: {props.age}</h2>
            <h2>ID: {(Math.floor(Math.random()*300000))}</h2>
            <h2 onClick={props.handler}>Job: { Math.random().toString(36).substring(2, 15) + Math.random().toString(36).substring(2, 15)}</h2>
            <p>{props.children}</p>
        </div>
    );
}
export default person 