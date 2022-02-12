package com.google.ff04zav.db.mysql;

public class User {
	
	private int id;
	private String name;
	
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public User(String name) {
		super();
		this.name = name;
	}
	
	public User(int id) {
		super();
		this.id = id;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
