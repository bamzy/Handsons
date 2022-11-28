package-lock.json is the snapshot build based on package.json at the time with the actually used versions which is needed to be commited to source control


## setup react manually
1. install npm
2. run `npm init`
3. install webpack stuff<br>
` npm install --save-dev webpack webpack-cli webpack-dev-server`
4. install babel stuff <br>
`npm i --save-dev babel-loader @babel/preset-env @babel/core @babel/plugin-transform-runtime @babel/preset-react @babel/eslint-parser @babel/runtime @babel/cli`
5. install eslint<br>
`npm i --save-dev eslint eslint-config-airbnb-base eslint-plugin-jest eslint-config-prettier path`
6. install react itself <br>
`npm i react react-dom`
7. create a public folder