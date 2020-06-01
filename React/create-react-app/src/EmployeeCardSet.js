import React,{ Component } from "react";
import Card from './EmployeeCard';
import axios from 'axios';
import EmployeeCard from "./EmployeeCard";
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
                  cards: resp.data.data
              });
            });
          }
     
      render(){
            const cardList = this.state.cards[0].map((card,i)=>{
                  return <div className="col s2" key={i}>                        
                        <EmployeeCard card={card}  />
                        
                        </div>;
            });
            return <div className='row'> <h1>Our Collection:</h1>{cardList}</div>
      }
}
export default EmployeeCardSet;