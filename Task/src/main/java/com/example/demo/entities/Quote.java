package com.example.demo.entities;


public class Quote {
	
	private long id;
	private String content;
	private String author;
	public Quote(long id, String content, String author) {
		super();
		this.id = id;
		this.content = content;
		this.author = author;
	}
	public Quote() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "Quote [id=" + id + ", content=" + content + ", author=" + author + "]";
	}
	
	

}
