import bookComponent from './book.component.js'
import bookController from './book.controller.js'
import bookService from './book.service.js'

import flights from './flights/flights.module.js'
import trips from './trips/trips.module.js'

export default
  angular
    .module('book', [flights, trips])
    .component('bookComponent', bookComponent)
    .controller('bookController', bookController)
    .service('bookService', bookService)
    .name
