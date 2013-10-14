package com.haiming.messageboard.logic;

import com.haiming.messageboard.bean.Page;
import com.haiming.messageboard.bean.Theme;
import com.haiming.messageboard.dao.Dao;
import com.haiming.messageboard.dao.SqliteDaoImpl;

/**
 * 提供主题
 * @author Haiming-Liang
 *
 */
public class ThemeProvider {
	private Dao<Theme> dao;
	public ThemeProvider(){ 
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
	
	

}
