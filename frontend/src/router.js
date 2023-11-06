import Vue from 'vue';
import VueRouter from 'vue-router';
import EmployeeForm from "@/components/EmployeeForm.vue";

Vue.use(VueRouter);

const routes = [
    // Другие маршруты
    {
        path: '/employee-form',
        name: 'employee-form',
        component: EmployeeForm
    },
    {
        path: '/login-form',
        name: 'login-form',
        component: () => import('@/components/LoginForm.vue')
    }
];

const router = new VueRouter({
    routes
});

export default router;
