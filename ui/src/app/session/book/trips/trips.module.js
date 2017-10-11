import tripsComponent from './trips.component.js'
import tripsController from './trips.controller.js'
import tripsService from './trips.service.js'

export default
  angular
    .module('trips', [])
    .component('tripsComponent', tripsComponent)
    .controller('tripsController', tripsController)
    .service('tripsService', tripsService)
    .name
