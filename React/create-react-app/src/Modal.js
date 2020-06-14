import React, {Component} from 'react';

class Modal extends Component {
    render(){
       
        return (
            <div className="container">
                {this.state.showBtn? <a className="waves-effect waves-light btn modal-trigger" href="#modal1">Details</a>:null}          
                <div id="modal1" className="modal">
                    <div className='container'>
                    <h4>{this.props.cityName}</h4>
                    </div>
                        <div className="modal-content">
                            <div className='row'>
                                <div className="col s3">
                                <img src={this.props.img} />
                            </div>
                            <div class="col s3">
                                <p><b>Feels Like: </b>{this.props.feelsLike} </p>
                                <p><b>Temp: </b>{this.props.temp}</p>
                                <p><b>Min Temp: </b>{this.props.tempMin}</p>
                                <p><b>Max Temp: </b>{this.props.tempMax}</p>
                                <p><b>Humidity: </b>{this.props.humidity}</p>
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
export default Modal