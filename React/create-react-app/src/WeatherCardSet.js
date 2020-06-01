import React,{ Component } from "react";
import Card from './EmployeeCard';
import axios from 'axios';
import WeatherCard from "./WeatherCard";
class WeatherCardSet extends Component{      
      constructor(){
            super();
            this.state = {
                  info: ""
            }
      }
      componentDidMount(){
            const url = 'https://api.openweathermap.org/data/2.5/weather?q=Tehran&appid=e312dbeb8840e51f92334498a261ca1d';
            axios.get(url).then((resp)=>{
              this.setState({
                  info: resp.data
              });
            });
          }
     
      render(){
            
            return (<div className="col s2" >                        
                        <WeatherCard info={this.state.info}  />
                  </div>
                  );
      }
      
}
export default WeatherCardSet;