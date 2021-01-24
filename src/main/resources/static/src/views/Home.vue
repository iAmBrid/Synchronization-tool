<template>
  <div class="home">
    <Layout class="layout">
      <div class="header">
        <div class="title">前端辅助工具</div>
      </div>
      <Layout>
        <Sider>
          <Menu theme="dark" mode="vertical" width="auto" active-name="1-1">
            <MenuItem name="1-1">同步工具</MenuItem>
          </Menu>
        </Sider>
        <Content>
          <div class="layout-content">
            <router-view></router-view>
          </div>
        </Content>
      </Layout>
    </Layout>
  </div>
</template>

<script>
export default {};
</script>

<style></style>
