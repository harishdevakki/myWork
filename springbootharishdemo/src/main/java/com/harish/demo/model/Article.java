package com.harish.demo.model;

public class Article {

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(String title, String body, String author) {
		super();
		this.title = title;
		this.body = body;
		this.author = author;
	}

	private String title;
	private String body;
	private String author;
	private String accessToken;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}
