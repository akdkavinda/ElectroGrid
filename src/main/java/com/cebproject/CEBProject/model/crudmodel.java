package com.cebproject.CEBProject.model;

public class crudmodel {
	
	private String branchName;
	private String location;
	
	
	
	
	public crudmodel() {
		
	}
		
	public crudmodel(String branchName, String location) {
		super();
		this.branchName = branchName;
		this.location = location;
		
		
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
