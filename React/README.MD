
# React:
* A javascript **library** for building user interfaces
* It's component-based and declarative
* Highly reactive javascript apps
* Probably the most used UI library
<hr>

## The general idea of React
**1- First, you need an HTML element**
```html
 <div id="root">
```
**2- Then you define a JS(JSX) function that contains the render logic**
```js
 function Person(props){
            return(
                <div className="person">
                    <h1>{props.name}</h1>
                    <h2>Age: {props.age}</h2>
                    <h2>Job: Developer</h2>
                </div>
            );
        
        }
```
3- Then you tell React to render this function on your element element
```js
ReactDOM.render(<Person name="aaa" age=""/>,document.querySelector("#root"));
```

### What Is JSX?
JSX is an XML/HTML-like syntax used by React that extends ECMAScript so that XML/HTML-like text can co-exist with JavaScript/React code.
The syntax is intended to be used by preprocessors (i.e., transpilers like Babel) to transform
HTML-like text found in JavaScript files into standard JavaScript objects that a JavaScript 
engine will parse.

Basically, by using JSX you can write concise HTML/XML-like structures
(e.g., DOM like tree structures) in the same file as you write JavaScript code, then Babel will transform these expressions into actual JavaScript code. Unlike the past, instead of putting JavaScript into HTML, JSX allows us to put HTML into JavaScript.

<hr/>
## Next-Gen JavaScript features used in React

**1- let & const**
```js
var // old one and should be deprecated
let  // new var
const // constant value that cannot be re-assigned but can have mutable fields
```

**2- Arrow Fnctions (much like lambda in java)**
```js
//This was the old way
function funcName(input1,input2){
    ...
    return outpu;
}

//This is the new way
const funcName = (input1,input2) => {
    ...
    return output;
} 

// And if there is only one input you can shorten it
const funcName = input1 => {
    ...
    return output;
}
//One liner functions can be even shorter
const functName = input1 => 2*input;
```

**some reminder re js **<em>```consts```</em>** which was introduced at ES6 (2015)**
<br>1. they are NOT re-declarable
<br>2. they are a reference to an array or an object and the ref itself cannot be changed,
however the content behind that ref can be changed
<br>3. constants are not hoistable meaning you have to initialize them right AFTER you have declared them. 
This is important because with ```var``` you can initialize first and define later like this:
```js
a = "hello";
var a; //this works for variables!!!
```


**3- Writing modular code using Export & Import**
```js
person.js>
const person = {name:'max'};
export default person;
```
```js
utility.js>
export const myfunc = () => {...};
export const age = 10;
```
```js
app.js>
import person from './persson.js'; //Default export
//or
import prs from './person.js'; // Doesn't matter because of the default

import {myfunc} from './utility';    //Named export
import {age} from './utility';       //Named export

// You can also rename while importing
import {myfunc as newfunc} from './utility.js';
```


**4-Classes & Inheritance**

```js
class Person{

    //constructor
    constructor(){
        this.name = 'no blah';

    }
    //propery
    name = 'blah';

    //method
    func = () => {} 
}

//Initiation
const person1 = new Person();

//Inheritance
class Student extends Person {
    constructor(){
        //If you are defining a constructor and there is a parent class, you must call it's constructor
        super();
        this.name = 'geek';
    }
}
```

**5- You can skip constructors**
```js
class Car {
    myProperty = 'hi';
}
```

**6- The Spread & Rest Operator**

The *spread* is used to split up array elements OR object properties
```js
const oldArray = [];

// extracts all the elements of oldArray
const newArray = {...oldArray,newElement1,newElement2};

//pulls out all the properties of oldObject
const newObj = {...oldObject, newProp:5};
```
The *rest* part is used to merge a list of function arguments into an array

```js
function mySort(...args){
    return args.sort();
}
```

**7-Destructuring**
Easily extract array elements or object properties and store them in variables
```js
//Array Destructuring
[a,,b] = ['hello','to','Max'];
console.log(a); // Hello
console.log(b); // Max

//Object Destructuring
{name} = {name:'bamzy',age:29};
console.log(name);   // bamzy
console.log(age);    //undefined
```

**Array Functions (not really next-gen js)**
```js
const arr = [1,2,3];
//map() also creates a new copy
const timesTwo = arr.map((num) => {return num*2});
```

**This is a general JS reminder: primitive types are passed by value while objects and arrays are passed by reference**

<hr/>
##Chapter One: The Basics

**1- Tools:**
* Dependency manager: npm
* Bundler: Webpack
* Nexg-gen JS Compiler: Babel + Presets
* use the official create-react-app by:
```shell
> npm install create-react-app -g
> create-react-app react-basics --script-version 1.1.5
> cd react-basics
> npm start     //Starts the dev server
> npm test      //runs tests
```
**2- JSX Restrictions**
* Use *className* instead of *class*
```js
render(){
    return(
        <div className="form">
            <h1></h1>
        </div>
    );
}
```
* what you return needs to have only one root element
```js
    return(
        <div><p>blah blah</p>
        </div>
        // everything needs to be nested under one root element
        <h1>This will cause error</h1>
    );
```



* Changing the *state* and *props* will signal React to reload DOM
* In order to change the state, you need to use setState() to override it
```js
this.setState({persons: [{name: "Max1", age: 22},
      {name: "Emily1", age: 23}]})
``` 
* state only exists when you are inheriting from Component classs
* every class component can be replaced by a function component and vice versa
```js
const App = props => {
  const [personsState,setPersonsState] = useState({
    persons: [
      {name: "Bamzy", age: 22},
    ],
    someOtherField: 'blah blah'
  })
  const switchNameHandler = () => {
    setPersonsState({
      persons: [
        {name: "Bamdad", age: 22},
      ],
      someOtherField: personsState.someOtherField
    });
  }
  return (
      <div className="form">
        <button onClick={switchNameHandler}>Switch Name</button>
        <Person name={personsState.persons[1].name} age={personsState.persons[1].age}>ffff</Person>
      </div>
  );
}
```
* you can pass methods as props too.
##Useful npm commands:
```shell
npm cache verify    // Heals the npm cache
npm audit fix       // Auto-Fixes security volnerabilities
```



# Functional Component vs. Class Component

1.1 this is an example of functional component for react with props 

```js
<SomeComponent name="Bamdad"/>

//you can define it using an old school function
function SomeComponent({name}){ //pay attention to the deconstruction here because an array is going to be passed in reality
                                // function name must be capital
    return (<div>hellow {name}!</div>); 
}
// OR 
// you can use a fancy arrow function
const SompeComponent = ({name}) => {
    return (<div>hellow {name}</div>);
}

```
1.2 this is a class component for react which also has props

```js
<SomeCompoenet name="Bamdad"/>
class SomeComponent extends React.Component{ //you have to extend the Component class which gives you this.props
    render(){
        <div>hellow {this.props.name}!</div>
    }
}

```
2.1 here is a comparison between old school  function component w state vs. component class w state
```js
function SomeComponent(){
    const [count, setCount] = React.useState(0);
    return (<div>
        <button onClick={function(){setCount(count++)}}>click me</button>
    </div>);
}
```
2.2 or using a fancy arrow func
```js
const SomeComponent = ()=>{
    return (<div>
        <button onClick={() => setCount(count++)}>click me</button>
    </div>)    
}
```
2.3 or you can go class mode
```js
class SomeComponent extends React.Component {
    constructor(props){
        super(props);
        this.state = {count:0};
    }
    render(){
        (<div>
            <button onClick={() => this.state.count++}>click me</button>
        </div>)
    }
}
```
The idea is still the same but a class component handles state a bit differently. Firstly, we need to understand the importance of the React.Component constructor. Here is the definition from the official documentation:

“The constructor for a React component is called before it is mounted. When implementing the constructor for a React.Component subclass, you should call super(props) before any other statement. Otherwise, this.props will be undefined in the constructor, which can lead to bugs.”