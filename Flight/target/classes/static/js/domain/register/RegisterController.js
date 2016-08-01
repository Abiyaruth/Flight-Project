angular
  .module('app')
  .controller('RegisterController',['RegisterService','$location','$routeParams', 'LoginService','$scope',	function(RegisterService, $location, $routeParams, LoginService,$scope) {
	var ctrl = this;
	this.signup = function() {
		  var user = {
		  "username" : ctrl.username,
		  "password" : ctrl.password

		  }
		  console.log("inside register controller")
		  RegisterService.sendRegister(user)
		  .then(function(result) {
		   ctrl.user=result.data
		   console.dir(ctrl.user)
		  })
	}
	
		  console.dir(ctrl.user);
	}])