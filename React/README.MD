
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
**2- Then you define a JS(JFX) function that contains the render logic**
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
JSX is an XML/HTML-like syntax used by React that extends ECMAScript so that XML/HTML-like text can co-exist with JavaScript/React code. The syntax is intended to be used by preprocessors (i.e., transpilers like Babel) to transform HTML-like text found in JavaScript files into standard JavaScript objects that a JavaScript engine will parse.

Basically, by using JSX you can write concise HTML/XML-like structures (e.g., DOM like tree structures) in the same file as you write JavaScript code, then Babel will transform these expressions into actual JavaScript code. Unlike the past, instead of putting JavaScript into HTML, JSX allows us to put HTML into JavaScript.

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
**2- Folder Structure**










##Useful npm commands:
```shell
npm cache verify    // Heals the npm cache
npm audit fix       // Auto-Fixes security volnerabilities
```