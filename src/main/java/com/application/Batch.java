package com.application;

import java.util.List;

public class Batch {
	private int id;
    private String name;
    private String time;
   
    
	
	public Batch() {
		super();
	}
	public Batch(int id, String name, String time) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
    
}
