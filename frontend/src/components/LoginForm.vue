<template>
  <div class="login-container">
    <h1>Login</h1>
    <form @submit.prevent="login">
      <div class="form-group">
        <label for="username">Username:</label>
        <input type="text" id="username" v-model="username" />
      </div>
      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="password" />
      </div>
      <button type="submit">Log In</button>
    </form>
  </div>
</template>

<script>

import LoginService from "@/service/LoginService";
import {getAuthHeader} from "@/service/authHeader";
export default {
  data() {
    return {
      username: null,
      password: null
    };
  },
  created() {
    this.loginService = new LoginService();
  },
  methods: {
    async login() {
      try {
        const response = await this.loginService.login(this.username, this.password, getAuthHeader());

        if (response.status === 200) {
          this.$emit('authenticated', true);
          await this.$router.push('/employee-form');
        } else {
          console.error('Authentication failed');
        }
      } catch (error) {
        console.error('Request error', error);
      }
    },
    logout() {
      try {
        this.loginService.logout().then(response => {
          if (response.status === 200) {
            this.$emit('authenticated', false);
          }
        })
      this.$router.push('/login-form');
      } catch (error) {
        console.error('Request error', error);
      }
    }
  },
}
</script>

<style scoped>
.login-container {
  max-width: 300px;
  margin: 0 auto;
}
.form-group {
  margin-bottom: 10px;
}
</style>
