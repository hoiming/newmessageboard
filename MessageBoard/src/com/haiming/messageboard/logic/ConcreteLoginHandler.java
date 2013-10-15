package com.haiming.messageboard.logic;

import com.haiming.messageboard.bean.User;
import com.haiming.messageboard.dao.Dao;
import com.haiming.messageboard.dao.SqliteDaoImpl;

public class ConcreteLoginHandler implements LoginHandler{
 
	private Dao<User> dao ;
	private static User singleUser ;
	public ConcreteLoginHandler( ){ 
		this.dao = new SqliteDaoImpl();
		 
	}
	public static User userInstance(){ 
		if(singleUser != null){ 
			return singleUser;
		}
		return null;
	}
	/**
	 * 验证用户名密码是否一致,初始换单例的用户对象
	 */
	@Override
	public boolean verify(String username, String password) {
		User user = new User(username,password);
		User dbUser = new User();
		try {
			dbUser = dao.getWithoutID(user, User.class);
			singleUser = dbUser;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (user.equals(dbUser))
			return true;
		return false;
	}

}
