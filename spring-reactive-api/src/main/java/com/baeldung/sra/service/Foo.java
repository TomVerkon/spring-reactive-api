package com.baeldung.sra.service;

public class Foo {
	
	private int id = 0;
	
	private String name = null;
	
	public Foo(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
