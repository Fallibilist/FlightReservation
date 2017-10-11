/* @ngInject */
class TripsService {
    
    constructor($http, apiUrl) {
        this.$http = $http
        this.apiUrl = apiUrl
    }

}

export default TripsService