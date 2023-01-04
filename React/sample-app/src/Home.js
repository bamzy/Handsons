import {Component} from 'react';
import axios from "axios";
import NavBar from "./NavBar";

export default class Home extends Component{
    constructor(props) {
        super(props);
        this.state = {text: "Cat Fact of the Day!",ingredients:""};

    }
    handleType = (event)=>{
        this.setState({text:event.target.value});
    }
    componentWillUnmount() {
        console.log('dying')
    }
    componentDidMount() {
        console.log('finished mouting');

        const options = {
            method: 'GET',
            url: 'https://catfact.ninja/fact',
            params: {s: 'vodka'},
            headers: {
                'X-RapidAPI-Key': 'SIGN-UP-FOR-KEY',
                'X-RapidAPI-Host': 'the-cocktail-db.p.rapidapi.com'
            }
        };

        axios.request(options).then( (response) =>{
            console.dir(response.data.fact);
            this.setState({ingredients:response.data.fact})
        }).catch(function (error) {
            console.error(error);
        });
    }
    componentDidUpdate(prevProps, prevState, snapshot) {
        console.log('sth updated');
    }

    render() {
        return (
            <div className="App">
                <h1>{this.props.var}</h1>

                <h1>{this.state.text}</h1>
                <h2 className="gradient-text">Did you know: {this.state.ingredients}</h2>

            </div>);
    }
}