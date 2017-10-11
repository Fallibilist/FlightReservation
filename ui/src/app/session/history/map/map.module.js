import mapLocations from './map.locations'
import mapComponent from './map.component.js'
import mapController from './map.controller.js'
import mapService from './map.service.js'

export default
  angular
    .module('map', ['ngMap'])
    .constant('mapLocations', mapLocations)
    .component('mapComponent', mapComponent)
    .controller('mapController', mapController)
    .service('mapService', mapService)
    .name
