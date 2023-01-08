import {Component} from "react";
import axios  from "axios";

export default class Movies extends Component{
    constructor(props) {
        super(props);
        this.state = {
            movieList : []
        }



    }
    componentDidMount() {
        axios.get('https://api.themoviedb.org/3/movie/now_playing?api_key=fec8b5ab27b292a68294261bb21b04a5').then((response)=>{
            this.setState({movieList: response.data.results});
            console.log(response.data.results)
        });
    }

    render(){

        const movies = this.state.movieList.map((movie,index)=>{
            return <div className="col s3 p1" key={index}>
                <div className="card">
                    <div className="card-image">
                        <img style={{width:'300px',height:'400px'}} src={`http://image.tmdb.org/t/p/w300/${movie.poster_path}`} />
                        <span className="card-title">{movie.title}</span>
                    </div>
                </div>
            </div>
        });
        return (
        <div className="row">
            {movies}
        </div>);

    }
}