/* @ngInject */
class InfoController {

    flights = []

    constructor(infoService, historyService, userDataService, $state) {
        this.infoService = infoService
        this.historyService = historyService

        if (userDataService.loggedIn()) {
            if(this.historyService.trip.totalFlightTime) {
                this.displayFlights()
            } 
        } 
        else {
            $state.go('title.login')
        }
    }

    displayFlights() {
        let trip = this.historyService.trip
        this.flights = []

        for(let i = 0; i < trip.origins.length; i++) {
            let flight = {
                locations: `${trip.origins[i]} to ${trip.destinations[i]}`,
                flightTime: `Flight took ${trip.flightTimes[i]} hour(s)`,
                layover: []
            }

            if((i + 1) !== trip.origins.length) {
                flight.layover = [`Layover in ${trip.destinations[i]} for ${trip.layoverTimes[i]} hour(s)`]
            }

            this.flights.push(flight)
        }
    }

    displayWrapper() {
        let background = 'rgba(0, 0, 0, 0)'
        let border = '0px solid black'

        if(this.flights.length !== 0) {
            background = 'linear-gradient(rgba(28, 11, 0, 0.89), rgba(61, 22, 1, 0.91), rgba(29, 12, 0, 0.89))'
            border = '1px solid #A6683B'
        }

        return { background: background, border: border}
    }
}

export default InfoController