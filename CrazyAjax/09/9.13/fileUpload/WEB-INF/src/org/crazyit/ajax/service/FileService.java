package org.crazyit.ajax.service;

import java.util.*;
/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class FileService
{
	// 使用内存中的List集合模拟数据库，
	// 用于保存系统中所有的图片
	private static List<String> files
		= new LinkedList<>();
	// 添加文件
	public List<String> addFile(String fileName)
	{
		files.add(fileName);
		// 返回系统中所有图片
		return files;
	}
}
