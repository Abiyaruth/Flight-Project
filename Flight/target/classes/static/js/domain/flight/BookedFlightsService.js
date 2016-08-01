angular.module('app').service('BookedFlightsService', ['$http', function($http) {
	this.getBook=function(book){
		return $http.get('itinery/get',book)
	}
	
}])
