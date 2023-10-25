<template>
  <div style="margin: 0 auto; width: 80%">
    <Toast/>
    <Panel header="Employee List">
      <Menubar :model="items"/>
      <br>
      <DataTable :value="employees" :paginator="true" :rows="10" selection-mode="single"
                 :selection.sync="selectedEmployee" dataKey="id">
        <Column field="id" header="ID"></Column>
        <Column field="fullName" header="fullName"></Column>
        <Column field="description" header="description"></Column>
        <Column field="department" header="department"></Column>
        <Column field="salary" header="salary"></Column>
      </DataTable>
    </Panel>
    <Dialog header="Create Employee"
            :visible.sync="displayModal"
            :modal="true">
            <span class="p-float-label">
              <InputText id="fullName" type="text" v-model="employee.fullName" style="width: 100%"/>
              <label for="fullName">firstname</label>
            </span>
      <br>
      <span class="p-float-label">
              <InputText id="description" type="text" v-model="employee.description" style="width: 100%"/>
              <label for="description">description</label>
            </span>
      <br>
      <span class="p-float-label">
        <label for="department">Department</label>
              <Dropdown id="department" v-model="employee.departmentId" :options="departments" option-label="name" style="width: 100%"/>
      </span>
      <br>
      <span class="p-float-label">
              <InputText id="salary" type="text" v-model="employee.salary" style="width: 100%"/>
              <label for="salary">salary</label>
            </span>
      <template #footer>
        <Button label="save" icon="pi pi-check" @click="save"/>
        <Button label="close" icon="pi pi-times" @click="closeModal" class="p-button-secondary"/>
      </template>
    </Dialog>
  </div>
</template>

<script>
import EmployeeService from "../service/EmployeeService";
import DepartmentService from "../service/DepartmentService";

export default {
  name: 'Employee',
  data() {
    return {
      employees: [],
      departments: [],
      employee: {
        id: null,
        fullName: null,
        description: null,
        departmentId: null,
        salary: null
      },
      department: {
        id: null,
        name: null,
      },
      selectedEmployee: {
        id: null,
        fullName: null,
        description: null,
        departmentId: null,
        salary: null
      },
      selectedDepartment: {
        id: null,
        name: null
      },
      items: [
        {
          label: "New",
          icon: "pi pi-fw pi-plus",
          command: () => {
            this.showSaveModal();
          }
        },
        {
          label: "Edit",
          icon: "pi pi-fw pi-pencil",
          command: () => {
            this.showEditModal();
          }
        },
        {
          label: "Delete",
          icon: "pi pi-fw pi-trash",
          command: () => {
            this.delete();
          }
        },
        {
          label: "Refresh",
          icon: "pi pi-fw pi-refresh",
          command: () => {
            this.getAll();
          }
        }
      ],
      displayModal: false,
    }
  },
  employeeService: null,
  departmentService: null,
  created() {
    this.employeeService = new EmployeeService();
    this.departmentService = new DepartmentService();
  },
  mounted() {
    this.employeeService.getAll().then(response => {
      this.employees = response.data.content;
      console.log(this.employees);
    });
    this.departmentService.getAllDepartments().then(response => {
      this.departments = response.data.content;
      console.log(this.departments);
    })
  },
  methods: {
    showSaveModal() {
      this.displayModal = true;
    },
    showEditModal() {
      this.employee = this.selectedEmployee;
      this.department = this.selectedDepartment;
      this.displayModal = true;
    },
    getAll() {
      this.employeeService.getAll().then(response => {
        if (response.status === 200) {
          this.$toast.add({
            severity: "success", summary: "Success", detail: "Data submitted", life: 3000
          })
        }
        this.employees = response.data.content;
      })
    },
    delete() {
      if (confirm("Are you sure?")) {
        this.employeeService.delete(this.selectedEmployee.id).then(response => {
          if (response.status === 200) {
            this.$toast.add({
              severity: "success", summary: "Success", detail: "Employee deleted", life: 3000
            });
            this.getAll();
          }
        });
      }
    },
    save() {
      this.employeeService.save(this.employee).then(response => {
        if (response.status === 201) {
          this.displayModal = false;
          this.employee = {
            fullName: null,
            description: null,
            departmentId: this.employee.departmentId,
            salary: null
          };
          this.getAll();
        }
      });
    },
    getAllDepartments() {
      this.departmentService.getAllDepartments().then(response => {
        this.departments = response.data.content;
      });
    },
    closeModal() {
      this.displayModal = false;
    }
  }
};
</script>

<style>

</style>
