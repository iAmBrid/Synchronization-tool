import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import api from "@/axios/index.js";
//前端UI框架样式
import ViewUI from "view-design";
import "view-design/dist/styles/iview.css";
//自定义样式
import "@/assets/style/home.less";
import "@/assets/style/common.less";

Vue.config.productionTip = false;
Vue.use(ViewUI);
Vue.prototype.$api = api;

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
