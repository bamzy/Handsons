import {
    Link, Outlet,
    RouterProvider, useNavigate,
} from "react-router-dom";
export default function NavBar(props){
    const history = useNavigate();
    console.log(history);
    return (
        <>

            <nav>
                <div className="nav-wrapper">
                    <a href="#" className="brand-logo">Logo</a>
                    <ul id="nav-mobile" className="right hide-on-med-and-down">
                        <li><Link to={'/'} >home</Link></li>
                        <li><Link to={'/about'} >about</Link></li>
                        <li><Link to={'/movies'} >movies</Link></li>
                    </ul>
                </div>
            </nav>

            <Outlet />

        </>
    );
}