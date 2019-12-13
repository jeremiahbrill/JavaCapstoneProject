package com.techelevator.model;

public class Answer {
	
	private int id;
	private String textAnswer;
	private String videoAnswer;
	private String imageAnswer;
	private String linkAnswer;
	private String presentationText;
	private int subworkflowId;
	
	
	public String getPresentationText() {
		return presentationText;
	}
	public void setPresentationText(String presentationText) {
		this.presentationText = presentationText;
	}
	public int getSubworkflowId() {
		return subworkflowId;
	}
	public void setSubworkflowId(int subworkflowId) {
		this.subworkflowId = subworkflowId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTextAnswer() {
		return textAnswer;
	}
	public void setTextAnswer(String textAnswer) {
		this.textAnswer = textAnswer;
	}
	public String getVideoAnswer() {
		return videoAnswer;
	}
	public void setVideoAnswer(String videoAnswer) {
		this.videoAnswer = videoAnswer;
	}
	public String getImageAnswer() {
		return imageAnswer;
	}
	public void setImageAnswer(String imageAnswer) {
		this.imageAnswer = imageAnswer;
	}
	public String getLinkAnswer() {
		return linkAnswer;
	}
	public void setLinkAnswer(String linkAnswer) {
		this.linkAnswer = linkAnswer;
	}

	
	

}
