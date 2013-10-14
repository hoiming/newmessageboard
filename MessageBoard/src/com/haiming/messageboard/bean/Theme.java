package com.haiming.messageboard.bean;

import java.util.Date;

import com.haiming.messageboard.annotation.Column;
import com.haiming.messageboard.annotation.Entity;
import com.haiming.messageboard.annotation.Id;
@Entity("theme")
public class Theme {
	@Column("id")
	private int id;
	@Id("themeid")
	private int themeid;
	@Column("content")
	private String content;
	@Column("createdtime")
	private Date createdtime;

	public Theme() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getThemeid() {
		return themeid;
	}

	public void setThemeid(int themeid) {
		this.themeid = themeid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedtime() {
		return createdtime;
	}

	public void setCreatedtime(Date time) {
		this.createdtime = time;
	}
	public String toString(){ 
		return id+ " " + themeid + " " + content + " " + createdtime;
	}

}
