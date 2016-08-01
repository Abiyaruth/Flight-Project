package com.cooksys.pojo;

public class ItineryReq {
 String origin;
 String destination;
 long flightTime;
 long offset;
public String getOrigin() {
	return origin;
}
public void setOrigin(String origin) {
	this.origin = origin;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}
public void setFlightTime(long flightTime) {
	this.flightTime = flightTime;
}
public void setOffset(long offset) {
	this.offset = offset;
}
public ItineryReq() {
	super();
}

public long getFlightTime() {
	return flightTime;
}
public long getOffset() {
	return offset;
}
public ItineryReq(String origin, String destination, long flightTime, long offset) {
	super();
	this.origin = origin;
	this.destination = destination;
	this.flightTime = flightTime;
	this.offset = offset;
}
@Override
public String toString() {
	return "ItineryReq [origin=" + origin + ", destination=" + destination + ", flightTime=" + flightTime + ", offset="
			+ offset + "]";
}

 
}
