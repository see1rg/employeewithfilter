import axios from 'axios';

export default class DepartmentService {

    url="http://localhost:8081/api";
    getAllDepartments() {
        return axios.get(this.url + '/departments');
    }
}
