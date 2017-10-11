/* @ngInject */
class NewuserController {

    submission = {
        username: '',
        password: ''
    }

    usernameErrorCss = "black"
    passwordErrorCss = "black"

    constructor(newuserService, $state) {
        this.newuserService = newuserService
        this.$state = $state
    }

    createNewUser() {
        let user = {
            credentials: this.submission
        }

        this.newuserService.createNewUser(user).then((succeedResponse) => {
            this.$state.go('title.login')
        }, (errorResponse) => {
            if (errorResponse.status === 409) {
                // Username taken
                this.submission.username = ''
                this.usernameErrorCss = "red"
                this.passwordErrorCss = "black"
            }

            if (errorResponse.status === 406) {
                // Required field missing
                this.usernameErrorCss = "red"
                this.passwordErrorCss = "red"
            }
        })
    }
}

export default NewuserController