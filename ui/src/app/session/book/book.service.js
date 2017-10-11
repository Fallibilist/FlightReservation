/* @ngInject */
class BookService {
    
    constructor($http, apiUrl) {
        this.$http = $http
        this.apiUrl = apiUrl
    }

}

export default BookService