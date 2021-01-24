module.exports = {
  publicPath: "./",
  devServer: {
    proxy: {
      "/apis": {
        target: "http://47.97.68.197:8080", //设置调用接口域名和端口号别忘了加http
        changeOrigin: true,
        pathRewrite: {
          "^/apis": "",
        },
      },
    },
  },
};
