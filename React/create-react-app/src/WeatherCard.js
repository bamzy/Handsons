import React, { Component } from 'react';
import Modal from './Modal'
class WeatherCard extends Component{
    constructor(){
        super();
        this.state = {
            showBtn :false
        }
    }

    componentDidMount(){
        var elems = document.querySelectorAll('.modal');
        var instances = window.M.Modal.init(elems);
        this.setState({
            showBtn: true   
        }); 
    }
    componentDidUpdate(){
    }
    render(){
        const icon = (typeof this.props.info.weather === 'undefined')? "":this.props.info.weather[0].icon;
        const img = "http://openweathermap.org/img/wn/"+icon+"@2x.png"
       return <Modal 
            cityName={this.props.info.name} 
            img={img} 
            feelsLike={this.props.info.main.feels_like}
            temp={this.props.info.main.temp}
            tempMin = {this.props.info.main.temp_min}
            tempMax = {this.props.info.main.temp_max}
            humidity = {this.props.info.main.humidity}
        />
    }

}
export default WeatherCard