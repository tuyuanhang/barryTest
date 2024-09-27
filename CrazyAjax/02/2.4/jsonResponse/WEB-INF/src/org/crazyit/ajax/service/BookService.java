package org.crazyit.ajax.service;

import java.util.*;

import org.crazyit.ajax.domain.Book;

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
public class BookService
{
	// ģ���ڴ������ݿ�
	static Map<Integer , List<Book>> bookDb =
		new LinkedHashMap<>();
	static
	{
		// ��ʼ��bookDb����
		List<Book> list1 = new ArrayList<>();
		List<Book> list2 = new ArrayList<>();
		List<Book> list3 = new ArrayList<>();
		list1.add(new Book(1 , "���Java����" , "���" , 109));
		list1.add(new Book(2 , "������Java EE��ҵӦ��ʵս" , "���" , 99));
		list1.add(new Book(3 , "���Android����" , "���" , 89));
		list2.add(new Book(4 , "���μ�" , "��ж�" , 23));
		list2.add(new Book(5 , "ˮ�" , "ʩ����" , 20));
		list3.add(new Book(6 , "�ں�֮��" , "��˹����.����" , 16));
		list3.add(new Book(7 , "����ʱ�˵Ŀ���" , "���" , 18));
		bookDb.put(1 , list1);
		bookDb.put(2 , list2);
		bookDb.put(3 , list3);
	}
	public List<Book> getBookByCategory(int categoryId)
	{
		return bookDb.get(categoryId);
	}
}
