package com.haiming.messageboard.logic;

import java.util.Date;

import com.haiming.messageboard.bean.Page;
import com.haiming.messageboard.bean.Theme;
import com.haiming.messageboard.bean.User;
import com.haiming.messageboard.dao.Dao;
import com.haiming.messageboard.dao.SqliteDaoImpl;

/**
 * 提供主题
 * @author Haiming-Liang
 *
 */
public class ThemeLogic {
	private Dao<Theme> dao;
	public ThemeLogic(){ 
		dao = new SqliteDaoImpl<Theme>();
	}
	public Page<Theme> getThemes(Page<Theme> page) {
		try {
			return dao.getNextPage(page, Theme.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * 保存主题
	 * @param theme
	 * @param user
	 */
	public void saveTheme(String theme,User user){ 
		Theme t = new Theme();
		t.setContent(theme);
		t.setId(user.getId());
		t.setCreatedtime(new Date());
		System.out.println(t);
		try {
			dao.save(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
