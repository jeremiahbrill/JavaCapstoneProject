package com.techelevator.model;

public class Jobs {
	
	private int id;
	private String name;
	private String jobDescription;
	private String jobCity;
	private String jobState;
	private String jobUrl;
	private String jobPositionId;
	
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
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getJobCity() {
		return jobCity;
	}
	public void setJobCity(String jobCity) {
		this.jobCity = jobCity;
	}
	public String getJobState() {
		return jobState;
	}
	public void setJobState(String jobState) {
		this.jobState = jobState;
	}
	public String getJobUrl() {
		return jobUrl;
	}
	public void setJobUrl(String jobUrl) {
		this.jobUrl = jobUrl;
	}
	public String getJobPositionId() {
		return jobPositionId;
	}
	public void setJobPositionId(String jobPositionId) {
		this.jobPositionId = jobPositionId;
	}
	
}
