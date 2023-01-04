import {
    Link,
    RouterProvider,
} from "react-router-dom";
export default function NavBar(){

    return (
        <div>
            <nav>
                <h3>Bamdad</h3>
                <ul>
                    <li><Link to={'/'} >home</Link></li>
                    <li><Link to={'/about'} >about</Link></li>
                </ul>
            </nav>




        </div>
    );
}