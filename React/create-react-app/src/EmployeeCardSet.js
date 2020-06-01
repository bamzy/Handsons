import React,{ Component } from "react";
import Card from './Card';
import axios from 'axios';
class EmployeeCardSet extends Component{      
      constructor(){
            super();
            this.state = {
                  cards: [],
                  chosenCards: null
            }
      }
      componentDidMount(){
            // const url = 'https://api.openweathermap.org/data/2.5/weather?q=Tehran&appid=e312dbeb8840e51f92334498a261ca1d';
            const url = 'http://dummy.restapiexample.com/api/v1/employees';
            axios.get(url).then((resp)=>{
            // console.log(resp.data.data)
              this.setState({
                  cards: [resp.data.data]
              });
            });
          }
     
      render(){
            let cardList;
            if (Array.isArray(this.state.cards[0])){
                  cardList = this.state.cards[0].map((card,i)=>{
                        return <div className="col s2" key={i}>                        
                              <Card card={card}  />
                              <button onClick={()=>{this.handleBuy()}} id="resBtn" className='btn waves-light waves-effect'>Save</button>
                              </div>;
                  });
            }
            return <div className='row'> <h1>Our Collection:</h1>{cardList}</div>
      }
}
export default EmployeeCardSet;