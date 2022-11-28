import React from "react";
import ReactDom from "react-dom";
import App from "./App"
console.log('hi');
ReactDOM.render(<App />, document.getElementById("root"));
// hot reloading. It works by replacing a module of the application
// during runtime with an updated one so that it’s available for instant use.
module.hot.accept();