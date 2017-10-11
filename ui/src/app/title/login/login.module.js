import loginComponent from './login.component.js'
import loginController from './login.controller.js'
import loginService from './login.service.js'

export default
  angular
    .module('login', [])
    .component('loginComponent', loginComponent)
    .controller('loginController', loginController)
    .service('loginService', loginService)
    .name
