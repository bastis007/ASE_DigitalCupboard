package com.springboot.digitalCupboard.domain;

import java.util.UUID;

import javax.persistence.*;

@Entity
public final class Garment {
	@Id
	private String id;
	@Column
	private String type;
	@Column
	private String size;
	@Column
	private String colour;
	
	public Garment(String id, String type, String size, String colour) {
	    this.id = id;
	    this.type = type;
	    this.size = size;
	    this.colour = colour;
	}
	
	public Garment(String type, String size, String colour) {
		this(UUID.randomUUID().toString(), type, size, colour);
	}
	
	protected Garment() {}

	public String getId() {
		return id;
	}
	
	public String getType() {
		return type;
	}

	public String getSize() {
		return size;
	}

	public String getColour() {
		return colour;
	}
	
	public void setSize(String size) {
		this.size = size;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}	
	
	@Override
	public String toString() {
	    return String.format(
	        "Customer[id=%s, type='%s', size='%s', colour='%s']",
	        id, type, size, colour);
	}
}
