import historyComponent from './history.component.js'
import historyController from './history.controller.js'
import historyService from './history.service.js'

import list from './list/list.module.js'
import map from './map/map.module.js'
import info from './info/info.module.js'

export default
angular
  .module('history', [list, map, info])
  .component('historyComponent', historyComponent)
  .controller('historyController', historyController)
  .service('historyService', historyService)
  .name