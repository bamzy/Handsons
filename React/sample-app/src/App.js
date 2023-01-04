import logo from './logo.svg';
import React from 'react';
import './App.css';
import axios from 'axios';

import {
  BrowserRouter as Router, Routes, Route
} from "react-router-dom";

import NavBar from './NavBar';
import Home from "./Home";
import About from "./About";


class App extends React.Component {

  render(){


    return (
        <Router>
          <NavBar/>
          <Routes>

            <Route exact="true" path={"/"} element={<Home var={"eeeeho"}/>} />
            <Route path={"/about"} element={<About />} />
          </Routes>

        </Router>
    );
  }
}

export default App;
