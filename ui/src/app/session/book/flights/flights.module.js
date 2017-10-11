import flightsComponent from './flights.component.js'
import flightsController from './flights.controller.js'
import flightsService from './flights.service.js'

export default
  angular
    .module('flights', [])
    .component('flightsComponent', flightsComponent)
    .controller('flightsController', flightsController)
    .service('flightsService', flightsService)
    .name
