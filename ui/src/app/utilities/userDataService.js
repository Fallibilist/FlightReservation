/* @ngInject */
class UserDataService {
    credentials = new Credentials(undefined, undefined)

    constructor($state) {
        this.$state = $state
    }

    setUserCredentials(username, password) {
        this.credentials.username = username
        this.credentials.password = password
    }

    loggedIn() {
        return this.credentials.username !== undefined && this.credentials.password !== undefined
    }
}

class Credentials {
    constructor(username, password) {
        this.username = username
        this.password = password
    }

    getUsername() {
        this.username
    }
    getPassword() {
        this.password
    }
}

export default UserDataService