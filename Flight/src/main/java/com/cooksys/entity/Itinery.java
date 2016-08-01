package com.cooksys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Itinery")
public class Itinery {
	@Id
	@GeneratedValue
	private long id;
   @Column(name="source")
   private String source;
   @Column(name="destination")
   private String destination;
   @Column(name="flightTime")
   private long flightTime;
   @Column(name="offset")
   private long offset;
   @ManyToOne 
   Users user;
 
public Users getUser() {
	return user;
}
public void setUser(Users user) {
	this.user = user;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getSource() {
	return source;
}
public void setSource(String source) {
	this.source = source;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}
public double getFlightTime() {
	return flightTime;
}

public long getOffset() {
	return offset;
}
public void setOffset(long offset) {
	this.offset = offset;
}
public void setFlightTime(long flightTime) {
	this.flightTime = flightTime;
}
public Itinery(long id, String source, String destination, long flightTime, long offset, Users user) {
	super();
	this.id = id;
	this.source = source;
	this.destination = destination;
	this.flightTime = flightTime;
	this.offset = offset;
	this.user = user;
}
public Itinery() {
	super();
}
   
}
