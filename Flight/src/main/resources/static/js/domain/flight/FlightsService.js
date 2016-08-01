angular.module('app').service('FlightsService', ['$http', function($http) {
	
	this.getDetails=function(flight) {
		return $http.get('/flight/flights',flight)
	}
}])
