import newuserComponent from './newuser.component.js'
import newuserController from './newuser.controller.js'
import newuserService from './newuser.service.js'

export default
  angular
    .module('newuser', [])
    .component('newuserComponent', newuserComponent)
    .controller('newuserController', newuserController)
    .service('newuserService', newuserService)
    .name
