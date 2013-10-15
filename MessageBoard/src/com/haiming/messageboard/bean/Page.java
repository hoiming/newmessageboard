package com.haiming.messageboard.bean;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import com.haiming.messageboard.dao.Dao;
import com.haiming.messageboard.dao.SqliteDaoImpl;

/**
 * 用于分页显示的bean
 * @author Haiming-Liang
 *
 */
public class Page<T>  {
	//每页显示10条记录
	public  static final  int pageSize  =10;
	private int currentPage;
	private int totalPage;
	private Class<T> clazz;
	private Dao<T> dao = new SqliteDaoImpl<T>();
	private List<T> datalist ;
	public Page(Class<T> clazz)  { 
		this.clazz = clazz;
		currentPage = 0;
		datalist = new ArrayList<T>();
		try {
			totalPage = dao.sumOfRecords( clazz ) / pageSize;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(totalPage);
	}
	public void setCurrentPage(int p){ 
		currentPage  = p;
	}
	public void setTotalPage(int t){ 
		totalPage = t;
	}
	public int getCurrentPage(){ 
		return currentPage;
	}
	public int getTotalPage(){ 
		return totalPage;
	}
	public void setDatalist(List<T> list){ 
		this.datalist = list;
	}
	public List<T> getDatalist(){ 
		return datalist;
	}
	public String toString(){ 
		return ("currentPage:"+currentPage + " totalPage:" +totalPage + datalist);
	}
 

}
