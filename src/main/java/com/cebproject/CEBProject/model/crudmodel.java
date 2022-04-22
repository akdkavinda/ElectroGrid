package com.cebproject.CEBProject.model;

public class crudmodel {
	
	private int id;
	private String branchName;
	private String location;
	
	
	
	
	public crudmodel() {
		
	}




	public crudmodel(int id, String branchName, String location) {
		super();
		this.id = id;
		this.branchName = branchName;
		this.location = location;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getBranchName() {
		return branchName;
	}




	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}




	public String getLocation() {
		return location;
	}




	public void setLocation(String location) {
		this.location = location;
	}
		
	
	
}
