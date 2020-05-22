import React, { Component } from 'react';
import './App.css';
import Person from './Person/Person'

class App extends Component {
  state = {
    persons: [
      {name: "Max", age: 22},
      {name: "Emily", age: 23}
    ],
  }
  switchNameHandler = () =>{
      console.log('clicked');
      this.setState({persons: [{name: "Max1", age: 22},
      {name: "Emily1", age: 23}]})
  }
  render() {
    return (
      <div className="hiiie">
        <button onClick={this.switchNameHandler}>Switch Name</button>

        <Person name={this.state.persons[0].name} age={this.state.persons[0].age}>ffff</Person>
        <Person name={this.state.persons[1].name} age={this.state.persons[1].age}>ffff</Person>
      </div>
    );
  }
}

export default App;
