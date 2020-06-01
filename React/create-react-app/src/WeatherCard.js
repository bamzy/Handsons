import React, { Component } from 'react';
class WeatherCard extends Component{
    constructor(){
        super();
    }

    componentDidMount(){
        var elems = document.querySelectorAll('.modal');
        var instances = window.M.Modal.init(elems);
    }
    render(){
        const icon = (typeof this.props.info.weather === 'undefined')? "":this.props.info.weather[0].icon;
        console.log(icon);
        const img = "http://openweathermap.org/img/wn/"+icon+"@2x.png"
        return (
            <div className="row">
                <a className="waves-effect waves-light btn modal-trigger" href="#modal1">Modal</a>          
                <div id="modal1" className="modal">
                <div className="modal-content">
        <h4>{this.props.info.name}</h4>
                    <p><img src={img} /><b>Feels Like: </b>{(typeof this.props.info.main === 'undefined')? "":this.props.info.main.feels_like}</p>
                    <p><b>Temp: </b>{(typeof this.props.info.main === 'undefined')? "":this.props.info.main.temp}</p>
                    
                </div>
                <div className="modal-footer">
                    <a href="#!" className="modal-close waves-effect waves-green btn-flat">Got It</a>
                </div>
                </div>
            </div>);
    }

}
export default WeatherCard