/* @ngInject */
class FlightsController {

    flightList = []

    constructor(flightsService, $interval, $state, userDataService) {
        this.flightsService = flightsService

        if (!userDataService.loggedIn()) {
            $state.go('title.login')
        }

        this.retrieveFlights()
        $interval(() => this.retrieveFlights(), 5000)
    }

    retrieveFlights() {
        this.flightsService.retrieveFlights().then((succeedResponse) => {
            if(succeedResponse.data.length === 5) {
                succeedResponse.data.forEach((flight) => {
                    flight.output = `From ${flight.origin} to ${flight.destination} at ${flight.offset}:00 AM taking ${flight.flightTime} hour(s)`
                })
                this.flightList = succeedResponse.data
            }
        })
    }

}

export default FlightsController