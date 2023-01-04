import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import About from './About';

import {
    createBrowserRouter,
    RouterProvider,
} from "react-router-dom";

const router = createBrowserRouter([
    {
        exact: true,
        path: "/",
        element: <App />,
    },
    {
        exact: false,
        path: "/about",
        element: <About />,
    },
]);
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <App  />
    // <RouterProvider router={router} />
);


