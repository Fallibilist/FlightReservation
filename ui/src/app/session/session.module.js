import sessionComponent from './session.component.js'
import sessionController from './session.controller.js'

export default
  angular
    .module('session', [])
    .component('sessionComponent', sessionComponent)
    .controller('sessionController', sessionController)
    .name
