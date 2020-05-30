import React , {Component} from 'react'
class Card extends Component {
      activeFlag = false;
      constructor(){
            super();
            this.state = {
                  btnName: 'Buy'
            }
      }
      handleBuy = (i)=>{
            if (this.activeFlag)
                  return;
            console.log('clicked '+ this.props.card.id);
            this.setState({
                  btnName: 'Sold Out'
            });
            this.activeFlag = true;
      }
      render(){
            return <div className="col s2" >
                 <div className="card hoverable small">
                     <div className="card-image">
                         <img src={this.props.card.pixel} />
                     </div>
                     <div className="card-content">
                         <h3>{this.props.card.name}</h3>
                         <p>{this.props.card.name}</p>
                     </div>
                     <div className="card-action">
                         <a href="#">CAD {this.props.card.price}</a>
                         <button onClick={()=>{this.handleBuy()}} id="resBtn" className='btn waves-light waves-effect'>{this.state.btnName}</button>
                     </div>
                 </div>
             </div>;
      }
}
export default Card;