package com.cooksys.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.pojo.Flight;
import com.cooksys.pojo.FlightReq;
import com.cooksys.service.FlightService;
import com.cooksys.service.LocationService;
import com.cooksys.service.RouteService;

@RestController
@CrossOrigin(methods = RequestMethod.POST)
@RequestMapping("flights")
public class FlightsController {

	@Autowired
	LocationService locationService;

	@Autowired
	FlightService flightService;

	@Autowired
	RouteService routeService;

	@RequestMapping
	public ArrayList<Flight> getFlightList() {
		return flightService.getDailyFlightList();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ArrayList<Flight> getShortestPath(@RequestBody FlightReq flightreq) {
		return routeService.findShortestPath(flightreq);

	}

}
