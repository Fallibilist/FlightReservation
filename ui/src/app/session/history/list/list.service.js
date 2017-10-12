/* @ngInject */
class ListService {
    
    backupItinerary = []

    constructor($http, apiUrl, userDataService) {
        this.$http = $http
        this.apiUrl = apiUrl
        this.userDataService = userDataService
    }

    retrieveIntinerary() {
        return this.$http.get(`${this.apiUrl}/flights/trips/${this.userDataService.credentials.username}`)
    }

}

export default ListService