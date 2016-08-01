package com.cooksys.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.handlerclass.Edge;
import com.cooksys.handlerclass.Vertex;
import com.cooksys.pojo.Flight;
import com.cooksys.pojo.FlightReq;

@Service
public class RouteService {
	private List<Vertex> nodes;
	private List<Edge> edges;
	private Set<Vertex> settledNodes;
	private Set<Vertex> unSettledNodes;
	private Map<Vertex, Vertex> predecessors;
	private Map<Vertex, Integer> distance;
	@Autowired
	FlightService flightService;

	public RouteService() {
		super();

	}

	public ArrayList<Flight> findMinimalFlightTime(FlightReq flightreq) {

		ArrayList<Flight> flights = flightService.getDailyFlightList();

		List<Vertex> nodes = new ArrayList<Vertex>();
		for (Flight flight : flights) {
			String d = flight.getDestination();
			boolean hasNode = false;
			for (Vertex node : nodes) {
				if (node.getCityname().equals(d)) {
					hasNode = true;
					break;
				}
			}
			if (!hasNode) {
				Vertex v = new Vertex(d);
				nodes.add(v);
			}

			String o = flight.getOrigin();
			for (Vertex node : nodes) {
				if (node.getCityname().equals(o)) {
					hasNode = true;
					break;
				}
			}
			if (!hasNode) {
				Vertex v1 = new Vertex(o);
				v1.addEdge(new Edge(flight));
				nodes.add(v1);

			}
		}
		for (Vertex v : nodes) {
			if (v.getCityname().equals(flightreq.getOrigin())) {
				v.setWeight(0d);
				break;
			}
		}
		List<Vertex> adjacentNodes = getNeighbors(nodes);
		for (Vertex target : adjacentNodes) {
			if (getShortestDistance(target) > getShortestDistance(nodes) + getDistance(nodes, target)) {
				distance.put(target, getShortestDistance(nodes) + getDistance(nodes, target));
				predecessors.put(target, (Vertex) nodes);
				unSettledNodes.add(target);
			}
		}
		return flights;
	}
	private int getShortestDistance(Vertex target) {
		Integer d = distance.get(nodes);
		if (d == null) {
			return Integer.MAX_VALUE;
		} else {
			return d;
		}
	}

	private List<Vertex> getNeighbors(List<Vertex> nodes) {
		List<Vertex> neighbors = new ArrayList<Vertex>();
		for (Edge edge : edges) {
			if (edge.getSource().equals(((Flight) nodes).getOrigin()) && !isSettled(edge.getDestination(), edge)) {
				neighbors.add(edge.getDestination());
			}
		}
		return neighbors;
	}

	private boolean isSettled(Vertex destination, Object vertex) {
		return settledNodes.contains(vertex);
	}

	private int getShortestDistance(List<Vertex> nodes) {
		Integer d = distance.get(nodes);
		if (d == null) {
			return Integer.MAX_VALUE;
		} else {
			return d;
		}
	}

	private int getDistance(List<Vertex> nodes, Vertex target) {
		for (Edge edge : edges) {
			if (edge.getSource().equals(nodes) && edge.getDestination().equals(target)) {
				return edge.getWeight();
			}
		}
		throw new RuntimeException("Should not happen");
	}

	// gets the path
	public LinkedList<Vertex> getPath(Vertex target) {
		LinkedList<Vertex> path = new LinkedList<Vertex>();
		Vertex step = target;

		// check if a path exists
		if (predecessors.get(step) == null) {
			return null;
		}
		path.add(step);
		while (predecessors.get(step) != null) {
			step = predecessors.get(step);
			path.add(step);
		}
		// Put it into the correct order
		Collections.reverse(path);
		return path;
	}

	public ArrayList<Flight> findShortestPath(FlightReq flightreq) {
		findMinimalFlightTime(flightreq);
		
		
		
		return null;
	}

}
