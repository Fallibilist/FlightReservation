/* @ngInject */
class HistoryService {
    
    constructor($http, apiUrl) {
        this.$http = $http
        this.apiUrl = apiUrl
    }

}

export default HistoryService