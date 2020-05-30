
class Card extends React.Component{
    constructor(){
        super();
        this.state = {
            btnName: 'Reserve',
            name : 'Sold Out',
            backgroundColor: '#ff99ca'
        };
        setTimeout(()=>{
            this.setState({
                name: 'Available', 
                backgroundColor: '#84e8a5'
            })
        },5000);
    }
    stat = true;
    handleReserve= ()=>{
        console.log(this.stat)
        this.stat = !this.stat;
        this.setState({
            btnName : 'Reserved',
            name: 'Reserved', 
            backgroundColor: '#849fe8'
        })
    }
    render(){
        const styles = {
            containerStyle: {
              backgroundColor: this.state.backgroundColor,
            }
          };
          const { containerStyle } = styles;
    return <div className="col s2">
                 <div className="card hoverable small" style={{backgroundColor: this.state.backgroundColor}}>
                     <div className="card-image">
                         <img src={this.props.data.pixel} />
                     </div>
                     <div className="card-content">
                         <p>{this.props.data.name}</p>
                         <p>{this.state.name}</p>
                     </div>
                     <div className="card-action">
                         <a href="#">CAD {this.props.data.price}</a>
                         <button id="resBtn" className='btn' onClick={this.handleReserve}>{this.state.btnName}</button>
                     </div>
                 </div>
             </div>;
    }
    
}