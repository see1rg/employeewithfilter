import axios from "axios";

export default class LoginService {
    url="http://localhost:8081/api/auth";

    login(username, password) {
        return axios.post(this.url + "/login", {username, password});
    }

    logout() {
        return axios.post(this.url + "/logout");
    }
}