
<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <HelloWorld  v-bind:isPublished=true />
    -{{items.length}}-
    <ul v-if="items.length>3">
      <li v-for="item in items" v-bind:key="item.id">{{item.name}}</li>
    </ul>
    <p v-else>Nothing</p>
    
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  data:  function(){return {
     items: [
       {id: 1, name: "A"},
       {id: 2, name:"B"},
       {id: 3, name:"C"}
      ]
    }
  },
  props: {test: String},
  components: {
    
  }
  
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
