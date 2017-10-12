/* @ngInject */
class InfoController {

    constructor(infoService, historyService) {
        this.infoService = infoService
        this.historyService = historyService
    }

}

export default InfoController