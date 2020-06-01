import React, { Component } from 'react';
import './App.css';

import data from './data';
import EmployeeCardSet from './EmployeeCardSet';
import WeatherCardSet from './WeatherCardSet';

class App extends Component {
  constructor(){
    super();
  }
  
  
  render(){
  return (
    <WeatherCardSet />
    );
  }
}

export default App;
