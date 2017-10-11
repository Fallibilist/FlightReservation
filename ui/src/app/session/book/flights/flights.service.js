/* @ngInject */
class FlightsService {

    constructor($http, apiUrl) {
        this.$http = $http
        this.apiUrl = apiUrl
    }

    retrieveFlights(origin, destination) {
        return this.$http.get(`${this.apiUrl}/flights/`)
        return this.$http.get(`${this.apiUrl}/flights/trips/`, {
            params: {
                origin,
                destination
            }
        })
    }

}

export default FlightsService