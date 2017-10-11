import listComponent from './list.component.js'
import listController from './list.controller.js'
import listService from './list.service.js'

export default
  angular
    .module('list', [])
    .component('listComponent', listComponent)
    .controller('listController', listController)
    .service('listService', listService)
    .name
