package com.cooksys.handlerclass;

import java.util.ArrayList;

public class Vertex {
	 private int flightTime;
	 private int offset;
	 private Double weight = Double.POSITIVE_INFINITY;
	private Vertex cityname; 
	private ArrayList<Edge> edges;
	public Vertex previous;

	public Vertex getPrevious() {
		return previous;
	}

	public void setPrevious(Vertex previous) {
		this.previous = previous;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}

	public Vertex getCityname() {
		return cityname;
	}

	public Vertex setCityname(Vertex cityname) {
		return this.cityname = cityname;
	}

	public int getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(int flightTime) {
		this.flightTime = flightTime;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (flightTime ^ (flightTime >>> 32));
		result = prime * result + (int) (offset ^ (offset >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (flightTime != other.flightTime)
			return false;
		if (offset != other.offset)
			return false;
		return true;
	}

	public Vertex(String d) {
	
	}

	@Override
	public String toString() {
		return "Vertex [flightTime=" + flightTime + ", offset=" + offset + ", weight=" + weight + ", cityname="
				+ cityname + ", edges=" + edges + ", previous=" + previous + "]";
	}

	public void addEdge(Edge edge) {
		// TODO Auto-generated method stub
		
	}

	


	  
}
