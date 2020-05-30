import React,{ Component } from "react";

class CardSet extends Component{

      constructor(){
            super();
            this.state = {
                  chosenCards: []
            }
      }
      handleBuy = (i)=>{
            const newChosenCards = [...this.state.chosenCards];
            newChosenCards.push(i);
            this.setState({
                  chosenCards : newChosenCards
            })
      }
      render(){
            const cardList = this.props.cards.map((card,i)=>{
                  return <div className="col s2" key={i}>
                 <div className="card hoverable small">
                     <div className="card-image">
                         <img src={card.pixel} />
                     </div>
                     <div className="card-content">
                         <p>{card.name}</p>
                         <p>{card.name}</p>
                     </div>
                     <div className="card-action">
                         <a href="#">CAD {card.price}</a>
                         <button onClick={()=>{this.handleBuy(i)}} id="resBtn" className='btn waves-light waves-effect'>Buy</button>
                     </div>
                 </div>
             </div>;
            });
            return <div className='row'>{cardList}</div>
      }
}
export default CardSet;