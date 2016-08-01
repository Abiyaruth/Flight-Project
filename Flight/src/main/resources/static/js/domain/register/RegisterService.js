angular.module('app').service('RegisterService', ['$http', function($http) {
	
	var url = 'user/';

	
	this.sendRegister = function(user) { return $http.post(url + 'create', user) };
}])