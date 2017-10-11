/* @ngInject */
class TripsController {

    originSelection = 'Memphis'
    destinationSelection = 'Nashville'

    tripList = []

    constructor(tripsService, $interval) {
        this.tripsService = tripsService
        this.retrieveTrips()
        $interval(() => this.retrieveTrips(), 25000)
    }

    retrieveTrips() {
        this.tripsService.retrieveTrips(this.originSelection, this.destinationSelection).then((succeedResponse) => {
            succeedResponse.data.forEach((trip) => {
                trip.output = []
                for (let i = 0; i < trip.length; i++) {
                    trip.output.push(`${trip[i].origin} to ${trip[i].destination}\nDeparture: ${trip[i].offset}:00AM\nFlight Duration: ${trip[i].flightTime} hour(s)`)
                    if ((i + 1) < trip.length) {
                        trip.output.push(`------>\nLayover Duration: ${trip[i + 1].offset - trip[i].offset}`)
                    }
                }
            })

            if (succeedResponse.data.length !== 0) {
                this.tripList = succeedResponse.data
            } else {
                let defaultTrip = []
                defaultTrip.output = ['No Flights Avaliable']
                this.tripList = [defaultTrip]
            }
        })
    }

    bookTrip(trip) {
        const outputTrip = {
            origins: [],
            destinations: [],
            flightTimes: [],
            layoverTimes: []
        }

        for (let i = 0; i < trip.length; i++) {
            outputTrip.origins.push()
            outputTrip.destinations.push()
            outputTrip.flightTimes.push()
            if ((i + 1) < trip.length) {
                outputTrip.layoverTimes.push(trip[i + 1].offset - trip[i].offset)
            }
        }

        this.tripsService.bookTrip(outputTrip).then((succeedResponse) => {

        })
    }
}

export default TripsController