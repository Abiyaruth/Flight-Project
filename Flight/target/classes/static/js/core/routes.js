angular.
  module('app').
  config(['$routeProvider', 'baseRoute',
    function config($routeProvider, baseRoute) {

      $routeProvider.
      	when('/map', {
          
          templateUrl: baseRoute + "map/template.html",
          controller: 'MapController',
          controllerAs: 'mapController'
          
        }).
        when('/login',{
        	templateUrl : baseRoute +"login/loginTemplate.html",
        	controller : 'LoginController',
        	controllerAs : 'loginController'
        }).
        when('/register',{
        	templateUrl : baseRoute +"register/registerTemplate.html",
        	controller : 'RegisterController',
        	controllerAs : 'registerController'
        }).
        when('/searchFlights',{
        	templateUrl : baseRoute +"flight/searchFlightTemplate.html",
        	controller : 'SearchFlightController',
        	controllerAs : 'searchFlightController'
        }).
        when('/bookedFlights',{
        	templateUrl : baseRoute +"flight/bookTemplate.html",
        	controller : 'BookedFlightsController',
        	controllerAs : 'bookedFlightsController'
        }).
      
        when('/flight',{
        	templateUrl : baseRoute +"flight/flightTemplate.html",
        	controller : 'FlightsController',
        	controllerAs : 'flightsController'
        }).
        otherwise('/flight');
    }
  ]);