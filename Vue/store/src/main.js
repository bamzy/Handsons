import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  data: {"myname": 'bamdad', "description": "this is it"}
}).$mount('#app')

var test = "";
