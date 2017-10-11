/* @ngInject */
class SessionController {
    
    constructor(userDataService, $state) {
        if(!userDataService.loggedIn()) {
            $state.go('title.login')
        }
    }

}

export default SessionController