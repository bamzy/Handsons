
import React, {useState} from 'react';
import {BrowserRouter as Router, Routes, Route, useNavigate} from "react-router-dom";
import './App.css';


import NavBar from './pages/NavBar';
import Home from "./pages/Home";
import About from "./pages/About";
import Customer from "./pages/Customer";


function App() {


    const [state,setState] = useState({'one':1,'two':2})
    return;
    return (
        <Router>
            <NavBar ></NavBar>
          <Routes>


              <Route  path={"/"} element={<Home var={this.props}/>} >
              </Route>
                <Route  path={"/about"} element={<About />} >

                </Route>
          </Routes>

        </Router>
    );

}

export default App;
