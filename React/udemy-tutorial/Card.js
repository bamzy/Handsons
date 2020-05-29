
class Card extends React.Component{
    render(){
    return <div className="col s2">
                 <div className="card hoverable small">
                     <div className="card-image">
                         <img src={this.props.data.pixel} />
                     </div>
                     <div className="card-content">
                         <p>{this.props.data.name}</p>
                         <p>{this.props.data.description}</p>
                     </div>
                     <div className="card-action">
                         <a href="#">CAD {this.props.data.price}</a>
                     </div>
                 </div>
             </div>;
    }
    
}