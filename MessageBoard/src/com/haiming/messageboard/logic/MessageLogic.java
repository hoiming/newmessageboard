package com.haiming.messageboard.logic;

import com.haiming.messageboard.bean.Message;
import com.haiming.messageboard.dao.Dao;
import com.haiming.messageboard.dao.SqliteDaoImpl;

public class MessageLogic {
	private Dao<Message> dao ;
	public MessageLogic(){ 
		dao = new SqliteDaoImpl<Message>();
	}
	
	public void saveMessage(){ 
		
	}

}
