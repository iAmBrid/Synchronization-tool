<template>
  <Card class="page-card">
    <p slot="title">
      同步工具
    </p>
    <Row>
      <Col span="16" offset="4">
        <Form :model="formItem" :label-width="80" label-colon>
          <FormItem label="同步内容">
            <Input
              v-model="formItem.textarea"
              type="textarea"
              :autosize="{ minRows: 18, maxRows: 20 }"
              placeholder="请输入需要同步的内容"
            ></Input>
          </FormItem>
          <FormItem>
            <div class="button-content">
              <Button @click="getData">刷新</Button>
              <Button type="primary" style="margin-left: 8px" @click="postData"
                >提交</Button
              >
            </div>
          </FormItem>
        </Form></Col
      >
    </Row>
  </Card>
</template>

<script>
export default {
  data() {
    return {
      formItem: {
        textarea: "",
      },
    };
  },
  methods: {
    //获取同步的数据
    getData() {
      let data = {};
      this.$api.aync
        .getData(data)
        .then((res) => {
          if (res.data.success) {
            this.formItem.textarea = res.data.message;
            this.$Message.success("刷新成功");
          } else {
            this.$Message.error(res.data.message);
          }
        })
        .catch((err) => {
          this.$Message.error("数据刷新失败，失败原因请查看控制台");
          throw err;
        });
    },
    //提交同步的数据
    postData() {
      let data = {
        text: this.formItem.textarea,
      };
      this.$api.aync
        .postData(data)
        .then((res) => {
          if (res.data.success) {
            this.$Message.success("提交成功");
          } else {
            this.$Message.error(res.data.message);
          }
        })
        .catch((err) => {
          this.$Message.error("数据提交失败，失败原因请查看控制台");
          throw err;
        });
    },
  },
  mounted() {
    this.getData();
  },
};
</script>

<style lang="less" scoped>
.button-content {
  margin-left: 124px;
}
</style>
