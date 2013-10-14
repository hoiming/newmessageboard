package com.haiming.messageboard.dao;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.haiming.messageboard.bean.Page;
import com.haiming.messageboard.exception.NotFoundAnnotationException;

/**
 * 定义该有的接口
 * @author Haiming-Liang
 *
 */
public interface Dao<T>   {
	//分页查询,返回下一页的内容
	Page<T> getNextPage(Page<T> page,Class<T> clazz) throws Exception;
	//查询一条记录
	T  get(Object id,Class<T> clazz) throws Exception;
	//不根据ID查询记录
	T getWithoutID(Object obj,Class<T> clazz) throws Exception;
	void save(T t) throws Exception;
	void update(T t) throws Exception;
	void delete(Object id,Class<T> clazz) throws Exception;
	List<T> findAllByConditions(Map<String,Object> sqlWhere,Class<T> clazz) throws Exception;
	List<T> findAllByConditionsWithLimit(Map<String, Object> sqlWhereMap,
			Class<T> clazz,int floor,int ceiling) throws Exception;
	int sumOfRecords(Class<T> clazz) throws Exception;
 

}
