package com.haiming.messageboard.logic;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.haiming.messageboard.bean.Message;
import com.haiming.messageboard.bean.MessageComparator;
import com.haiming.messageboard.bean.MessagePage;
import com.haiming.messageboard.bean.Theme;
import com.haiming.messageboard.bean.User;
import com.haiming.messageboard.dao.Dao;
import com.haiming.messageboard.dao.SqliteDaoImpl;

public class MessageLogic {
	private Dao<Message> messageDao;
	private Dao<Theme> themeDao;

	public MessageLogic() {
		messageDao = new SqliteDaoImpl<Message>();
		themeDao = new SqliteDaoImpl<Theme>();
	}

	/**
	 * 保存帖子的内容
	 * 
	 * @param t
	 * @param message
	 * @param u
	 * @return
	 */
	public Message saveMessage(Theme t, String message, User u) {
		if (t == null || u == null || message == null)
			return null;
		Message m = new Message();
		m.setId(u.getId());
		m.setThemeid(t.getThemeid());
		m.setContent(message);
		m.setCreatedtime(new Date());
		try {
			messageDao.save(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	/**
	 * 通过主题的id获取这个主题下的所有回复
	 * 
	 * @param themeid
	 * @return
	 */
	public MessagePage getMessageByTheme(int themeid) {
		MessagePage messagePage = new MessagePage(  );
		Theme theme = null;
		Map<Message,User> map = null;
		try {
			theme = themeDao.get(themeid, Theme.class);
			if (theme != null) {
				Map<String, Object> sqlWhereMap = new HashMap<String, Object>();
				sqlWhereMap.put("t.themeid", themeid);
				map = messageDao.getUserAndMessage(themeid);
				//按时间从前到后排序
				//Collections.sort(list,new MessageComparator());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		messagePage.setDatamap(map);
		messagePage.setTheme(theme);

		return messagePage;
	}

}
