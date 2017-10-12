import title from './title/title.module.js'
import titleLogin from './title/login/login.module.js'
import titleNewuser from './title/newuser/newuser.module.js'

import session from './session/session.module.js'
import sessionBook from './session/book/book.module.js'
import sessionHistory from './session/history/history.module.js'

import appComponent from './app.component.js'
import appController from './app.controller.js'

import apiUrl from './api.url.js'
import userDataService from './utilities/userDataService.js'

export default
angular
  .module('flight', [
    'ngAria',
    'ngAnimate',
    'ngMaterial',
    'ngMessages',
    'ui.router',

    title,
    titleLogin,
    titleNewuser,
    session,
    sessionBook,
    sessionHistory
  ])
  .config(['$stateProvider', '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {

      const titleState = {
        abstract: true,
        name: 'title',
        url: '/title',
        component: 'titleComponent'
      }

      const loginState = {
        name: 'title.login',
        url: '/login',
        component: 'loginComponent'
      }

      const newuserState = {
        name: 'title.newuser',
        url: '/newuser',
        component: 'newuserComponent'
      }

      const sessionState = {
        abstract: true,
        name: 'session',
        url: '/session',
        component: 'sessionComponent'
      }

      const bookState = {
        name: 'session.book',
        url: '/book',
        component: 'bookComponent'
      }

      const historyState = {
        name: 'session.history',
        url: '/history',
        component: 'historyComponent'
      }

      $stateProvider.state(titleState)
        .state(loginState)
        .state(newuserState)
        .state(sessionState)
        .state(bookState)
        .state(historyState)

      $urlRouterProvider.otherwise('/title/login')
    }
  ])
  .constant('apiUrl', apiUrl)
  .component('appComponent', appComponent)
  .controller('appController', appController)
  .service('userDataService', userDataService)
  .name