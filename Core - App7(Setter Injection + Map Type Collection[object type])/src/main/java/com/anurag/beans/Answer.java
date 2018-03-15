package com.anurag.beans;

import java.util.Date;

public class Answer {
	private int id;
	private String answer;
	private Date postedDate;
	@Override
	public String toString() {
		return "Answer [id=" + id + ", answer=" + answer + ", postedDate=" + postedDate + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Date getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}
	
}
