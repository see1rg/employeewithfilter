import Vue from 'vue'
import App from './App.vue'
import DataTable from "primevue/datatable";
import Column from "primevue/column";
import Panel from "primevue/panel";
import Menubar from "primevue/menubar";
import Dialog from "primevue/dialog";
import InputText from "primevue/inputtext";
import Button from "primevue/button";
import Toast from "primevue/toast";
import ToastService from "primevue/toastservice";
import Dropdown from "primevue/dropdown";


import 'primevue/resources/primevue.min.css';
import 'primeicons/primeicons.css';
import 'primevue/resources/themes/nova-light/theme.css';

Vue.config.productionTip = false
Vue.component('DataTable', DataTable);
Vue.component('Column', Column);
Vue.component('Panel', Panel);
Vue.component('Menubar', Menubar);
Vue.component('Dialog', Dialog);
Vue.component('InputText', InputText);
Vue.component('Button', Button);
Vue.component('Toast', Toast);
Vue.component('Dropdown', Dropdown);
Vue.use(ToastService);

new Vue({
  render: h => h(App),
}).$mount('#app')
