/* @ngInject */
class TripsController {

    originSelection = 'Memphis'
    destinationSelection = 'Nashville'

    tripList = []

    constructor(tripsService, $interval, $state, userDataService) {
        this.tripsService = tripsService

        if (!userDataService.loggedIn()) {
            $state.go('title.login')
        } 
        else {
            this.retrieveTrips()
            $interval(() => this.retrieveTrips(), 5000)
        }
    }

    retrieveTrips() {
        this.tripsService.retrieveTrips(this.originSelection, this.destinationSelection).then((succeedResponse) => {
            succeedResponse.data.forEach((trip) => {
                trip.flightOutput = []
                for (let i = 0; i < trip.length; i++) {
                    trip.flightOutput.push(trip[i])
                    trip.flightOutput[i].to = 'to'
                    trip.flightOutput[i].hours = 'hour(s)'
                    if ((i + 1) < trip.length) {
                        trip.flightOutput[i].layovers = []
                        trip.flightOutput[i].layovers.push(trip[i + 1].offset - trip[i].offset)
                    }
                }
            })

            if (succeedResponse.data.length !== 0 &&
                this.originSelection !== this.destinationSelection) {
                this.tripList = succeedResponse.data
            } else {
                let defaultTrip = []
                let flight = []
                flight.origin = 'No Trips'
                flight.destination = 'Avaliable'
                defaultTrip.flightOutput = [flight]
                this.tripList = [defaultTrip]
            }
        })
    }

    bookTrip(trip) {
        if (trip.length > 0) {
            const outputTrip = {
                origins: [],
                destinations: [],
                flightTimes: [],
                layoverTimes: []
            }

            for (let i = 0; i < trip.length; i++) {
                outputTrip.origins.push(trip[i].origin)
                outputTrip.destinations.push(trip[i].destination)
                outputTrip.flightTimes.push(trip[i].flightTime)

                if ((i + 1) < trip.length) {
                    outputTrip.layoverTimes.push(trip[i + 1].offset - trip[i].offset)
                }
            }

            this.tripsService.bookTrip(outputTrip).then((succeedResponse) => {})
        }
    }
}

export default TripsController