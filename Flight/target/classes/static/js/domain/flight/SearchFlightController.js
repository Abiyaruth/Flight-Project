angular.module('app').controller("SearchFlightController",["SearchFlightService","$scope","$interval", function(SearchFlightService,$scope,$interval)
		{
// Searches Flights
	
	    var ctrl=this;
		//Gets the flight details
		 this.flight = function (){
			 var flight = {
					 "origin": ctrl.origin,
					    "destination": ctrl.destination,
					    "flightTime": ctrl.flightTime,
					    "offset": ctrl.offset
			 }
			 console.log("In searchflight controller")
			 
			 SearchFlightService.getDetails(flight).then(function(result){
				 ctrl.detail=result.data;
				 console.log(ctrl.detail)
			 }) 
		 }
		 
		 $interval(ctrl.flight, 1000*5);
		 
//Gets the Booked Flight	 
		 
		 ctrl.getBook=function(){
			 SearchFlightService.getBook()
			.then(function(result){
				ctrl.allBook=result.data
				console.log("allbooked")
				console.dir(ctrl.allbook)
			})
		  }	   
		  ctrl.getBook()
		  
//Adds the selected itinery and stores in database
		  
	    this.book=function(flightTime, offset){
	    	var book = {
	    			"flightTime" :flightTime,
	    			"offset":offset,
	    			"origin":$scope.selectedSource,
	    			"destination":$scope.selectedDestination,
	    	    	}
	    	console.dir(book)
	    	console.dir($scope)
	    	SearchFlightService.postDetails(book).then((response)=>{
	    		if(response.status==200){
	    		ctrl.allBook.push(book);
	    		}
	    		else
	    			{
	    			console.log("failed");
	    			}
	    	})
	    	}

	    
	   
		}]);