package org.crazyit.ajax.service;

import java.util.*;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class FileService
{
	// ʹ���ڴ��е�List����ģ�����ݿ⣬
	// ���ڱ���ϵͳ�����е�ͼƬ
	private static List<String> files
		= new LinkedList<>();
	// ����ļ�
	public List<String> addFile(String fileName)
	{
		files.add(fileName);
		// ����ϵͳ������ͼƬ
		return files;
	}
}
