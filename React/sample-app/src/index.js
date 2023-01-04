import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import About from './pages/About';

import {
    createBrowserRouter,
    RouterProvider,
} from "react-router-dom";
import NavBar from "./pages/NavBar";
import Home from "./pages/Home";
import ErrorPage from "./pages/ErrorPage";
import Customer from "./pages/Customer";

const router = createBrowserRouter([
    {

        path: "/",
        element: <NavBar />,
        errorElement : <ErrorPage />,
        children: [
            {
                path: "/",
                element: <Home />,
            }, {
                path: "about",
                element: <About />,
                children: [
                    {
                        path: "client",
                        element: <h1>hey client</h1>
                    },
                    {
                        path: "customer",
                        element: <Customer />
                    }
                ]
            },
        ],
    },

]);
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    // <App  />
    <RouterProvider router={router} />
);


