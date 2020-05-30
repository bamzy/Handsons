import React from 'react';
import logo from './logo.svg';
import './App.css';
import data from './data'
import CardSet from './CardSet';

function App() {
  return (
    <CardSet cards={data} />);
}

export default App;
