import React,{ Component } from "react";
import Card from './EmployeeCard';
import axios from 'axios';
import WeatherCard from "./WeatherCard";
class WeatherCardSet extends Component{      
      constructor(){
            super();
            this.state = {
                  info: "",
                  name: ""
            }
      }
      componentDidMount(){
            const url = 'https://api.openweathermap.org/data/2.5/weather?q='+document.querySelector('#inputCityName').value+'&units=metric&appid=e312dbeb8840e51f92334498a261ca1d';
            axios.get(url).then((resp)=>{
              this.setState({
                  info: resp.data,
                  name: resp.data.name
              });
            });
          }
      searchCity = (event)=>{
            event.preventDefault();
            const cityName = document.querySelector('#inputCityName').value;
            const url = 'https://api.openweathermap.org/data/2.5/weather?q='+cityName +'&units=metric&appid=e312dbeb8840e51f92334498a261ca1d';
            axios.get(url).then((resp)=>{
              this.setState({
                  info: resp.data,
                  name: resp.data.name,
                  temp: resp.data.main.temp
              });
            });
      }
     
      render(){
            
            return (<div className="container" >
                  <h1>{this.state.name} {(typeof this.state.temp === 'undefined')? "": this.state.temp}</h1>
                  <div className="row">
                  <div class="col s8">
                  <form onSubmit={this.searchCity}>
                        <input type="text" id='inputCityName' placeholder="Enter city name"></input>
                  </form>      
                                    
                  </div>
                  <div class="col s2">
                        <WeatherCard info={this.state.info}  />
                  </div>
                  </div>
                  </div>
                  );
      }
      
}
export default WeatherCardSet;