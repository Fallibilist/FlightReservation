/* @ngInject */
class NewuserService {
    
    constructor($http, apiUrl) {
        this.$http = $http
        this.apiUrl = apiUrl
    }

    createNewUser(credentials) {
        return this.$http.post(`${this.apiUrl}/users/new/`, credentials)
    }
}

export default NewuserService