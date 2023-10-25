<template>
  <div id="app">
    <div v-if="authenticated">
      <EmployeeForm/>
    </div>
    <div v-else>
      <LoginForm @authenticated="setAuthenticated" />
    </div>
  </div>
</template>

<script>
import EmployeeForm from "@/components/EmployeeForm.vue";
import LoginForm from "@/components/LoginForm.vue";
export default {
  name: 'App',
  components: {
    EmployeeForm,
    LoginForm
  },
  data() {
    return {
      authenticated: false,
    };
  },
  methods: {
    setAuthenticated(value) {
      this.authenticated = value;    },
  },
}
</script>
