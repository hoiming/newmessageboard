package com.haiming.messageboard.test;

import org.junit.Ignore;
import org.junit.Test;

import com.haiming.messageboard.bean.Message;
import com.haiming.messageboard.bean.Page;
import com.haiming.messageboard.bean.Theme;
import com.haiming.messageboard.bean.User;
import com.haiming.messageboard.dao.SqliteDaoImpl;

public class TestSqliteDaoImpl {

	private SqliteDaoImpl<User> dao = new SqliteDaoImpl<User>();
	private SqliteDaoImpl<Theme> themeDao = new SqliteDaoImpl<Theme>();
	private SqliteDaoImpl<Message> messageDao = new SqliteDaoImpl<Message>();
	private SqliteDaoImpl<Theme> pageDao = new SqliteDaoImpl<Theme>();

	@Ignore
	public void testSave() throws Exception {
		Message m = new Message();
		m.setId(0);
		m.setThemeid(1);
		m.setContent("哈哈哈哈哈");
		messageDao.save(m);

	}

	@Ignore
	public void testSaveTheme() throws Exception {
		for (int i = 0; i < 40; i++) {
			Theme t = new Theme();
			t.setId(0);
			t.setContent("Test Content");
			themeDao.save(t);
		}

	}

	@Ignore
	public void testGetWithoutID() throws Exception {
		int themeid = 0;
		Theme t = themeDao.get(themeid, Theme.class);
		// System.out.println(t);

		int messageid = 0;
		Message m = messageDao.get(messageid, Message.class);
		System.out.println(m);
	}

	@Test
	public void testPage() throws Exception {
		Page<Theme> page = new Page<Theme>(Theme.class);
		page = pageDao.getNextPage(page, Theme.class);

		System.out.println(page);
		page = pageDao.getNextPage(page, Theme.class);
		System.out.println(page);
		page = pageDao.getNextPage(page, Theme.class);
		System.out.println(page);
		page = pageDao.getNextPage(page, Theme.class);
		System.out.println(page);
		page = pageDao.getNextPage(page, Theme.class);
		System.out.println(page);
		page = pageDao.getNextPage(page, Theme.class);
		System.out.println(page);

	}

}
