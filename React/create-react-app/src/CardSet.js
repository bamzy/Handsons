import React,{ Component } from "react";
import Card from './Card';
class CardSet extends Component{
      
      constructor(){
            super();
            this.state = {
                  chosenCards: []
            }
      }
     
      render(){
            const cardList = this.props.cards.map((card,i)=>{
                  return <div className="col s2" key={i}>
                        <Card card={card}  />
                        <button onClick={()=>{this.handleBuy()}} id="resBtn" className='btn waves-light waves-effect'>Save</button>
                        </div>;
            });
            return <div className='row'>{cardList}</div>
      }
}
export default CardSet;