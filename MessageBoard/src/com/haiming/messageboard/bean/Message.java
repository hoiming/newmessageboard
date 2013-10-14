package com.haiming.messageboard.bean;

import java.util.Date;

import com.haiming.messageboard.annotation.Column;
import com.haiming.messageboard.annotation.Entity;
import com.haiming.messageboard.annotation.Id;

@Entity("message")
public class Message {
	@Column("id")
	private int id;
	@Column("themeid")
	private int themeid;
	@Id("messageid")
	private int messageid;
	@Column("content")
	private String content;
	@Column("createdtime")
	private Date createdtime;

	public Message() {
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

	public int getMessageid() {
		return messageid;
	}

	public void setMessageid(int messageid) {
		this.messageid = messageid;
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

	public void setCreatedtime(Date crreatedtime) {
		this.createdtime = crreatedtime;
	}
	
	public String toString(){ 
		return id + " " + themeid + " " + messageid + " " + content + " " + createdtime;
	}

}
