import axios from "axios";

export default class EmployeeService {

    url="http://localhost:8081/api";

    getAll() {
        return axios.get(this.url + "/data_list/employee");
    }

    save(employee) {
        return axios.post(this.url + "/edit_data/employee", employee);
    }

    delete(id) {
        return axios.delete(this.url + "/delete_data/employee/" + id);
    }

}