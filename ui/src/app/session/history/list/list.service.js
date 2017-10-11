/* @ngInject */
class ListService {
    
    constructor($http, apiUrl) {
        this.$http = $http
        this.apiUrl = apiUrl
    }

}

export default ListService