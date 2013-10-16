package com.haiming.messageboard.utils;

import java.io.UnsupportedEncodingException;

/**
 * 一个工具类，提供字符串编码转换
 * 
 * @author Haiming-Liang
 * 
 */
public class MyTools {

	public static String toUTF8(String str) {
		String srcEncoding = "ISO-8859-1";
		String destEncoding = "UTF-8";
		try {
			str = new String(str.getBytes(srcEncoding), destEncoding);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 把一些字符转义，例如尖括号
	 * 
	 * @param str
	 * @return
	 */
	public static String changeHTML(String str) {
		return str.replace("&", str).replace(" ", "&nbsp;").replace("<", "&lt")
				.replace(">", "&gt;").replace("<", "&lt;")
				.replace("\r\n", "<br>");
	}
}
