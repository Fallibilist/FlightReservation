/* @ngInject */
class HistoryService {
    

    constructor($http, apiUrl) {
        this.$http = $http
        this.apiUrl = apiUrl
        this.trip = {}
    }

}

export default HistoryService