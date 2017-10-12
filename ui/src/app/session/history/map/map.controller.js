/* @ngInject */
class MapController {
    zoom = 7
    center = [35.5175, -86.5804]
    markers = []
    paths = []

    constructor(mapService, mapLocations, historyService, $state, userDataService) {
        this.mapService = mapService
        this.historyService = historyService

        if (!userDataService.loggedIn()) {
            $state.go('title.login')
        }

        this.drawTrip()
    }

    addMarker({
        latitude,
        longitude,
        city
    }) {
        let iconSelection = ''
        switch (city) {
            case 'MemphisO':
                iconSelection = '{ url:"/img/memphisFrom.png", scaledSize:[90,100], origin: [0,0], anchor: [45,100] }'
                break;
            case 'MemphisD':
                iconSelection = '{ url:"/img/memphisTo.png", scaledSize:[90,100], origin: [0,0], anchor: [45,100] }'
                break;
            case 'ChattanoogaO':
                iconSelection = '{ url:"/img/chattanoogaFrom.png", scaledSize:[90,90], origin: [0,0], anchor: [45,90] }'
                break;
            case 'ChattanoogaD':
                iconSelection = '{ url:"/img/chattanoogaTo.png", scaledSize:[90,90], origin: [0,0], anchor: [45,90] }'
                break;
            case 'KnoxvilleO':
                iconSelection = '{ url:"/img/knoxvilleFrom.png", scaledSize:[90,90], origin: [0,0], anchor: [45,90] }'
                break;
            case 'KnoxvilleD':
                iconSelection = '{ url:"/img/knoxvilleTo.png", scaledSize:[90,90], origin: [0,0], anchor: [45,90] }'
                break;
            case 'NashvilleO':
                iconSelection = '{ url:"/img/nashvilleFrom.png", scaledSize:[90,90], origin: [0,0], anchor: [45,90] }'
                break;
            case 'NashvilleD':
                iconSelection = '{ url:"/img/nashvilleTo.png", scaledSize:[90,90], origin: [0,0], anchor: [45,90] }'
                break;
            default:
                console.dir("Error in city icon display")
        }

        this.markers.push({
            position: `[${latitude}, ${longitude}]`,
            icon: iconSelection
        })
    }

    addPath(origin, destination) {
        let pathColor = ''
        switch (origin.city) {
            case 'MemphisO':
            case 'MemphisD':
                pathColor = 'red'
                break;
            case 'ChattanoogaO':
            case 'ChattanoogaD':
                pathColor = 'blue'
                break;
            case 'KnoxvilleO':
            case 'KnoxvilleD':
                pathColor = 'black'
                break;
            case 'NashvilleO':
            case 'NashvilleD':
                pathColor = 'yellow'
                break;
            default:
                console.dir("Error in city icon display")
        }

        this.paths.push({
            path: `[[${origin.latitude}, ${origin.longitude}], [${destination.latitude}, ${destination.longitude}]]`,
            strokeColor: pathColor,
            strokeOpacity: 1.0,
            strokeWeight: 3,
            geodesic: true
        })
    }

    drawTrip() {
        if (this.historyService.trip && this.historyService.trip.origins) {
            for (let i = 0; i < this.historyService.trip.origins.length; i++) {
                this.mapService.getMarkerByCityName(this.historyService.trip.origins[i]).then((originResponse) => {
                    this.mapService.getMarkerByCityName(this.historyService.trip.destinations[i]).then((destinationResponse) => {
                        let flightOrigin = {
                            latitude: originResponse.data.latitude,
                            longitude: originResponse.data.longitude,
                            city: originResponse.data.city + 'O'
                        }
                        let flightDestination = {
                            latitude: destinationResponse.data.latitude,
                            longitude: destinationResponse.data.longitude,
                            city: destinationResponse.data.city + 'D'
                        }

                        this.addMarker(flightOrigin)
                        this.addPath(flightOrigin, flightDestination)

                        if ((i + 1) === this.historyService.trip.origins.length) {
                            this.addMarker(flightDestination)
                        }

                    })
                })
            }
        } else {
            this.historyService.trip = {
                destinationInfo: 'Select a Flight'
            }
        }
    }

}

export default MapController