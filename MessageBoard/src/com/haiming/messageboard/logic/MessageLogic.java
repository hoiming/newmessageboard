package com.haiming.messageboard.logic;

import java.util.Date;

import com.haiming.messageboard.bean.Message;
import com.haiming.messageboard.bean.Theme;
import com.haiming.messageboard.bean.User;
import com.haiming.messageboard.dao.Dao;
import com.haiming.messageboard.dao.SqliteDaoImpl;

public class MessageLogic {
	private Dao<Message> dao ;
	public MessageLogic(){ 
		dao = new SqliteDaoImpl<Message>();
	}
	
	/**
	 * 保存帖子的内容
	 * @param t
	 * @param message
	 * @param u
	 * @return
	 */
	public Message saveMessage(Theme  t,String message,User u){ 
		if(t == null || u == null || message == null)
			return null;
		Message m = new Message();
		m.setId(u.getId());
		m.setThemeid(t.getThemeid());
		m.setContent(message);
		m.setCreatedtime(new Date());
		try {
			dao.save(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

}
