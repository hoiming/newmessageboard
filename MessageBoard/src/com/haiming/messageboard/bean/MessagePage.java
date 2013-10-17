package com.haiming.messageboard.bean;

import java.util.Map;

/**
 * 显示帖子的页面Bean
 * 
 * @author Haiming-Liang
 * 
 */
public class MessagePage {
	private Theme theme;
	private Map<Message, User> datamap;

	public MessagePage() {
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public Map<Message, User> getDatamap() {
		return datamap;
	}

	public void setDatamap(Map<Message, User> datamap) {
		this.datamap = datamap;
	}

	public String toString() {
		return theme + " " + datamap.toString();
	}
}
