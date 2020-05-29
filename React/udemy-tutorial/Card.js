import React from 'react' ;
class Card extends Component{
    render(){
    return (
            <div className="col s2">
                <div className="card hoverable small">
                    <div className="card-image">
                        <img src="http://lorempixel.com/600/600" />
                    </div>
                    <div className="card-content">
                        <p>Title</p>
                        <p>This is the second</p>
                    </div>
                    <div className="card-action">
                        <a href="#">CAD 10.00</a>
                    </div>
                </div>
            </div>);
    }
    
}