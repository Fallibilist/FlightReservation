/* @ngInject */
class ListController {

    constructor(listService, historyService, $state, userDataService) {
        this.listService = listService
        this.historyService = historyService
        this.$state = $state
        this.itinerary = listService.backupItinerary

        if(!userDataService.loggedIn()) {
            $state.go('title.login')
        } else {
            this.retrieveIntinerary()
        }

    }

    retrieveIntinerary() {
        this.listService.retrieveIntinerary().then((succeedResponse) => {
            if(succeedResponse.data) {
                succeedResponse.data.forEach((trip) => {
                    trip.title = `From ${trip.origins[0]} to ${trip.destinations[trip.destinations.length - 1]}`
                });

                if(succeedResponse.data.length !== this.itinerary.length) {
                    this.itinerary = succeedResponse.data.reverse()
                }
            }
        })
    }

    displayTripDetails(trip) {
        trip.destinationInfo = trip.title

        trip.totalFlightTime = 0
        trip.flightTimes.forEach((time) => {
            trip.totalFlightTime += time
        })
        trip.totalFlightTime = `Flight Duration: ${trip.totalFlightTime} hour(s)`

        trip.totalLayoverTime = 0
        trip.layoverTimes.forEach((time) => {
            trip.totalLayoverTime += time
        })
        trip.totalLayoverTime = `Layover Duration: ${trip.totalLayoverTime} hour(s)`

        this.itinerary.forEach((trip) => {
            trip.selectedStyle = 'rgba(0, 0, 0, 0.00)'
        })
        trip.selectedStyle = 'linear-gradient(to right, rgba(0, 0, 0, 0.00), rgba(61, 18, 0, 0.95), rgba(0, 0, 0, 0.00))'
        this.historyService.trip = trip

        this.listService.backupItinerary = this.itinerary;

        this.$state.reload()
    }

}

export default ListController