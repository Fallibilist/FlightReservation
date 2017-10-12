/* @ngInject */
class TripsService {

    constructor($http, apiUrl, userDataService) {
        this.$http = $http
        this.apiUrl = apiUrl
        this.userDataService = userDataService
    }

    retrieveTrips(origin, destination) {
        return this.$http.get(`${this.apiUrl}/flights/trips/`, {
            params: {
                origin,
                destination
            }
        })
    }

    bookTrip(trip) {
        return this.$http.post(`${this.apiUrl}/flights/trips/${this.userDataService.credentials.username}`, trip)
    }

}

export default TripsService