import React , {Component} from 'react'
class EmployeeCard extends Component {
      activeFlag = false;
      imageUrl =""
      constructor(){
            super();
            this.imageUrl= "http://lorempixel.com/"+(Math.floor(Math.random() * 10)+200)+"/"+(Math.floor(Math.random() * 10)+200);
            this.state = {
                  btnName: 'Hire',
                  bgColor: ''
            }
      }
      handleBuy = (i)=>{
            console.log('clicked '+ this.props.card.id);
            if (this.activeFlag){
                  this.setState({
                        btnName: 'Hire',
                        bgColor: ''
                  });
            }
            else {
                  this.setState({
                        btnName: 'Hired',
                        bgColor: 'pink'
                  });
            }
            
            this.activeFlag = !this.activeFlag;
      }
      render(){

            
            return <div className="card hoverable small">
                      <div className="card-image">
                         <img src={this.imageUrl} />
                     </div>
                     <div className="card-content" style={{backgroundColor: this.state.bgColor}}>
                         <p><b>Name: </b>{this.props.card.employee_name}</p>
                         <p><b>Age: </b>{this.props.card.employee_age}</p>
                     </div>
                     <div className="card-action">
                         <a href="#"> {(this.props.card.employee_salary).valueOf()} CAD</a>
                         <button onClick={()=>{this.handleBuy()}} id="resBtn" className='btn waves-light waves-effect'>{this.state.btnName}</button>
                     </div>
                 
             </div>;
      }
}
export default EmployeeCard;