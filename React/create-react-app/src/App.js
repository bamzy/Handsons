import React, { Component } from 'react';
import './App.css';

import data from './data';
import EmployeeCardSet from './EmployeeCardSet';

class App extends Component {
  constructor(){
    super();
  }
  
  
  render(){
  return (
    <EmployeeCardSet />
    );
  }
}

export default App;
