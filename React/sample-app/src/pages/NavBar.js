import {
    Link, Outlet,
    RouterProvider, useNavigate,
} from "react-router-dom";
export default function NavBar(props){
    const history = useNavigate();
    console.log(history);
    return (
        <div>
            <nav>
                <h3>Bamdad</h3>
                <ul>
                    <li><Link to={'/'} >home</Link></li>
                    <li><Link to={'/about'} >about</Link></li>
                </ul>
            </nav>


<Outlet />

        </div>
    );
}