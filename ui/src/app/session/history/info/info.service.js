/* @ngInject */
class InfoService {
    
    constructor($http, apiUrl) {
        this.$http = $http
        this.apiUrl = apiUrl
    }

}

export default InfoService