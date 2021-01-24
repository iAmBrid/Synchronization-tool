import axios from "axios";
axios.defaults.timeout = 30000;
import base from "@/axios/base.js";
const aync = {
  //获取同步数据
  getData(data) {
    return axios.get(base.api + "/content/get_latest_text", {
      params: data,
    });
  },
  //提交同步数据
  postData(data) {
    return axios.post("/apis/content/save", data);
  },
};
export default aync;
