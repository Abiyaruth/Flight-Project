angular.module('app').controller("FlightsController", ["FlightsService","$scope","$http","$interval", function(FlightsService,$scope,$http,$interval) {

	
	// gets the details from java
	
	 var ctrl=this;
//	//Gets the flight details
	 this.flight = function update(){
		 var flight = {
				 "origin": ctrl.origin,
				    "destination": ctrl.destination,
				    "flightTime": ctrl.flightTime,
				    "offset": ctrl.offset
		 }
		 $interval(update,1000*5);
		 console.log(ctrl.origin)
		 console.log("In flight controller")
		 
		 FlightsService.getDetails(flight).then(function(result){
			 ctrl.detail=result.data;
			 console.log(ctrl.detail)
		 }) 
	 }
	
//	// generates the detail randomly and displays and also updates on real time
//	 
//	$scope.origin= 'Miami';
//	$scope.destination='Jacksonville';
//	 $scope.flightTime = 1;
//	 $scope.offset=0;
//	   function update() {
//		 $scope.origin = ['Orlando', 'Jacksonville','Tallahasse'][Math.floor(Math.random() * 3)]
//		 $scope.destination = [ 'Miami','Orlando','Tallahasse'][Math.floor(Math.random() * 3)]
//	     $scope.flightTime = Math.floor((Math.random() * 4) + 1);
//	     $scope.offset = Math.floor((Math.random() * 10) + 0);
//	   }
//	   $interval(update, 1000 * 5);
	
}]);
