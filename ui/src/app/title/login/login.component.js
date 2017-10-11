import templateUrl from './login.template.html'

export default {
  templateUrl,
  controller: 'loginController',
  controllerAs: '$loginCtrl',
  bindings: {
    submission: '='
  }
}