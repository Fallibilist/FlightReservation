/* @ngInject */
class LoginService {
    
    constructor($http, apiUrl) {
        this.$http = $http
        this.apiUrl = apiUrl
    }

    login(credentials) {
        return this.$http.post(`${this.apiUrl}/users/login/`, credentials)
    }

}

export default LoginService