
class Card extends React.Component{
    constructor(){
        super();
        this.state = {
            name : 'Sold Out'
        };
        setInterval(()=>{
            this.setState({name: 'Available'})
        },5000);
    }
    handleReserve= ()=>{
        this.setState({name: "Reserved"});
    }
    render(){
    return <div className="col s2">
                 <div className="card hoverable small">
                     <div className="card-image">
                         <img src={this.props.data.pixel} />
                     </div>
                     <div className="card-content">
                         <p>{this.props.data.name}</p>
                         <p>{this.state.name}</p>
                     </div>
                     <div className="card-action">
                         <a href="#">CAD {this.props.data.price}</a>
                         <button id="resBtn" className='btn' onClick={this.handleReserve}>Rserve</button>
                     </div>
                 </div>
             </div>;
    }
    
}