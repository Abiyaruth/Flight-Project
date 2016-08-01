angular
  .module('app')
  .controller('LoginController',['LoginService','$location','$routeParams',	function(LoginService, $location, $routeParams) {
	var ctrl = this;
	this.login = function() {
	  var login = {
	  "username" : ctrl.username,
	  "password" : ctrl.password
	  }
	  console.dir(login)
	  LoginService.getLoginDetails(login)
	  .then(function(result) {
		ctrl.user = result.data
		console.dir(ctrl.user);
		if(ctrl.user.code=='OK'){
			$location.path('/searchFlights')
		}
	})
	}
}])