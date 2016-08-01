angular.module('app').service('SearchFlightService', ['$http', function($http) {
	this.getDetails=function(flight) {
		return $http.get('/flight/flights',flight)
	}
	this.getBook=function(book){
		return $http.get('itinery/get',book)
	}
	this.postDetails=function(book){
		return $http.post('itinery/book',book)
	}
}])
