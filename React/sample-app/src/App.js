import logo from './logo.svg';
import React from 'react';
import './App.css';
import axios from 'axios';
class App extends React.Component {
  constructor() {
    super();
    this.state = {text: "Start Typing",ingredients:""};

  }
  handleType = (event)=>{
    this.setState({text:event.target.value});
  }
  componentWillUnmount() {
    console.log('dying')
  }
  componentDidMount() {
    console.log('finished mouting');

    const options = {
      method: 'GET',
      url: 'https://the-cocktail-db.p.rapidapi.com/search.php',
      params: {s: 'vodka'},
      headers: {
        'X-RapidAPI-Key': 'SIGN-UP-FOR-KEY',
        'X-RapidAPI-Host': 'the-cocktail-db.p.rapidapi.com'
      }
    };

    axios.request(options).then(function (response) {
      console.log(response.data);
    }).catch(function (error) {
      console.error(error);
    });
  }
  componentDidUpdate(prevProps, prevState, snapshot) {
    console.log('sth updated');
  }

  render(){
    return (
      <div className="App">

        <h1>{this.state.text}</h1>
        <h2>Ingred: {this.state.ingredients}</h2>
        <input type="text" onChange={this.handleType}/>
      </div>
    );
  }
}

export default App;
