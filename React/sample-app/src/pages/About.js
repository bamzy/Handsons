import {Route, Routes, Link, Outlet} from "react-router-dom";
const Customer = ()=>{
    console.log('customer');
    return <h2>this is about for Customer</h2>
}
const Client = ()=>{
    console.log('client');
    return <h2>this is about for client</h2>
}
export default function About(){
    return (
        <div className="App">
            <Link to={"/about/customer"}>customer</Link>|
            <Link to={"/about/client"}>client</Link>|
            <p>this is our about page with some garbage</p>
            <Outlet />
        </div>
    );
}