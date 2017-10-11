import infoComponent from './info.component.js'
import infoController from './info.controller.js'
import infoService from './info.service.js'

export default
  angular
    .module('info', [])
    .component('infoComponent', infoComponent)
    .controller('infoController', infoController)
    .service('infoService', infoService)
    .name
