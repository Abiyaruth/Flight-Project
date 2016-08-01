/**
 * 
 */

angular.module('app').controller("MapController", ["MapService", function(MapService) {
	
	var ctrl = this;
	
	//Map object
	var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 7,
        center: {lat: 27.6648, lng: -81.5158}
      });
	
	//Add Marker
	 var createMarker = function (info){
	 var marker = new google.maps.Marker({
        map: $scope.map,
        position: new google.maps.LatLng(info.latitude, info.longitude),
       title: info.city
    });
	   $scope.markers.push(marker);
	 }
	 
	//Sample data
//	var jacksonville = new google.maps.Marker({
//	        map: map,
//	        position: {lat: 30.3322, lng: -81.6557}
//	      });
//	
//	var miami = new google.maps.Marker({
//        map: map,
//        position: {lat: 25.7617, lng: -80.1918}
//      });
//	
//	var tallahassee = new google.maps.Marker({
//		map: map,
//		position: {lat: 30.4383, lng: -84.2807}
//	})

	//Add a line to the map
    ctrl.addPoly = function addPoly(pointA, pointB, color) {
      
    	geodesicPoly = new google.maps.Polyline({
            strokeColor: color,
            strokeOpacity: 1.0,
            strokeWeight: 3,
            geodesic: true,
            map: map
          });
    	
    	geodesicPoly.setPath([pointA.getPosition(), pointB.getPosition()]);
    }
    
	
//	//Add lines manually
//    ctrl.addPoly(jacksonville, miami, '#CC0099');
//    
//    ctrl.addPoly(miami, tallahassee, '#AA1100');

    
    //Add lines from web service
	MapService.getMarkerByCityName(map, "Orlando").then(function(marker) {
		ctrl.addPoly(tallahassee, marker, '#FF3388');
	})
	
	
  
	//Calculating fastest route
	var directionsDisplay = new google.maps.DirectionsRenderer();
    var directionsService = new google.maps.DirectionsService();
	function calcRoute(){
		var start=ctrl.origin;
		var end =ctrl.destination;
	}
	var request={
			origin:start,
			destination:end,
			travelMode :google.maps.TravelMode.TRANSIT
	};
	directionsService.route(request, function(response, status) {
        if (status == google.maps.DirectionsStatus.OK) {
          directionsDisplay.setDirections(response);            
          console.log('enter!');  
        }
	})

}]);