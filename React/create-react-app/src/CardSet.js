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
                  return <Card card={card} key={i} />;
            });
            return <div className='row'>{cardList}</div>
      }
}
export default CardSet;