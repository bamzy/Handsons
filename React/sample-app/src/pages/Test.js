import {useState} from "react";

export default function Test(){
    const initState = {'one':1,'two':2};
    const [state,setState] = useState(initState);
    initState.one = 3;
    console.log(state);
    return (<h1>Test sanity check</h1>)
}