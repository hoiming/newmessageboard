package com.haiming.messageboard.test;

import org.junit.Test;

import com.haiming.messageboard.bean.User;
import com.haiming.messageboard.dao.SqliteDaoImpl;

public class TestSqliteDaoImpl {
 
	private SqliteDaoImpl<User> dao = new SqliteDaoImpl<User>();
	@Test
	public void testSave() throws Exception {
		User user = new User("Haiming","Teacher");
		dao.save(user);
		System.out.println();
	}

}
