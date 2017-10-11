/* @ngInject */
class LoginController {

    submission = {
        username: '',
        password: ''
    }

    usernameErrorCss = "black"
    passwordErrorCss = "black"

    constructor(loginService, userDataService, $state) {
        this.submission = {
            username: '',
            password: ''
        }
        this.loginService = loginService
        this.userDataService = userDataService
        this.$state = $state
    }

    guest() {
        this.submission = {
            username: '',
            password: ''
        }
        this.submission.username = 'guest'
        this.submission.password = 'guest'
        this.login()
    }

    login() {
        this.loginService.login(this.submission).then((succeedResponse) => {
            this.userDataService.setUserCredentials(this.submission.username, this.submission.password)
            this.usernameErrorCss = "black"
            this.passwordErrorCss = "black"

            this.$state.go('session.book')
        }, (errorResponse) => {
            if (errorResponse.status === 404) {
                // Username not found, shows error on username field
                this.submission.username = ''
                this.submission.password = ''
                this.usernameErrorCss = "red"
                this.passwordErrorCss = "black"
            }

            if (errorResponse.status === 401) {
                // Password not found, shows error on password field
                this.submission.password = ''
                this.passwordErrorCss = "red"
                this.usernameErrorCss = "black"
            }

        })
    }
}

export default LoginController