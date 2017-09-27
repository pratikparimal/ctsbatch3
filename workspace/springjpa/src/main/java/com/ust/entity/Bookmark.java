package com.ust.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bookmark {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	String bookmarkUrl;

	public Bookmark() {}
	public Bookmark(String bookmarkUrl) {
		super();
		this.bookmarkUrl = bookmarkUrl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookmarkUrl() {
		return bookmarkUrl;
	}
	public void setBookmarkUrl(String bookmarkUrl) {
		this.bookmarkUrl = bookmarkUrl;
	}
	@Override
	public String toString() {
		return "Bookmark [id=" + id + ", bookmarkUrl=" + bookmarkUrl + "]";
	}
	
	
}
