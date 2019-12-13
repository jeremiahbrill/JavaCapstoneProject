package com.techelevator.model;

public class Workflow {
	
	private int id;
	private String name;
	private int categoryId;
	private String presentationText;
		
	
	public String getPresentationText() {
		return presentationText;
	}
	public void setPresentationText(String presentationText) {
		this.presentationText = presentationText;
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
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	

}
