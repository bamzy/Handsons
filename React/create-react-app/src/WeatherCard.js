import React, { Component } from 'react';
class WeatherCard extends Component{
    

    componentDidMount(){
        var elems = document.querySelectorAll('.modal');
        var instances = window.M.Modal.init(elems);
    }
    render(){
        const icon = (typeof this.props.info.weather === 'undefined')? "":this.props.info.weather[0].icon;
        const img = "http://openweathermap.org/img/wn/"+icon+"@2x.png"
        return (
            <div className="container">
                <a className="waves-effect waves-light btn modal-trigger" href="#modal1">Details</a>          
                <div id="modal1" className="modal">
                    <div className='container'>
                    <h4>{this.props.info.name}</h4>
                    </div>
                        <div className="modal-content">
                            <div className='row'>
                                <div className="col s3">
                                <img src={img} />
                            </div>
                            <div class="col s3">
                                <p><b>Feels Like: </b>{(typeof this.props.info.main === 'undefined')? "":this.props.info.main.feels_like} C</p>
                                <p><b>Temp: </b>{(typeof this.props.info.main === 'undefined')? "":this.props.info.main.temp}</p>
                                <p><b>Min Temp: </b>{(typeof this.props.info.main === 'undefined')? "":this.props.info.main.temp_min}</p>
                                <p><b>Max Temp: </b>{(typeof this.props.info.main === 'undefined')? "":this.props.info.main.temp_max}</p>
                                <p><b>Humidity: </b>{(typeof this.props.info.main === 'undefined')? "":this.props.info.main.humidity}</p>
                            </div>
                    </div>
                </div>
                <div className="modal-footer">
                    <a href="#!" className="modal-close waves-effect waves-green btn-flat">Got It</a>
                </div>
                </div>
            </div>);
    }

}
export default WeatherCard