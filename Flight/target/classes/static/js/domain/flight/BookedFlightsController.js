 angular.module('app').controller("BookedFlightsController", ["BookedFlightsService","$scope","$http", function(BookedFlightsService,$scope,$http) {
	var ctrl=this;
	 ctrl.getBook=function(){
		 BookedFlightsService.getBook()
		.then(function(result){
			ctrl.allBook=result.data
			console.log("allbooked")
			console.dir(ctrl.allbook)
		})
	  }	   
	  ctrl.getBook()
 }]);