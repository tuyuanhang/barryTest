package org.crazyit.extjs.service;

import org.crazyit.extjs.domain.*;
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
public class BookService
{
	// ʹ��List����ģ���ڴ��е����ݿ�
	static Map<Category , List<Book>> bookDb = new LinkedHashMap<>();
	static
	{
		List<Book> books = new ArrayList<Book>();
		books.add(new Book(1, "���Java����" ,"���" ,109));
		books.add(new Book(2, "���Android����" ,"���" ,89));
		books.add(new Book(3, "���Ajax����" ,"���" ,69));
		bookDb.put(new Category(1 , "���ͼ��") , books);
		books = new ArrayList<Book>();
		books.add(new Book(4, "���μ�" ,"��ж�" ,21));
		books.add(new Book(5, "��������" ,"�޹���" ,18));
		bookDb.put(new Category(2 , "С˵") , books);
		books = new ArrayList<Book>();
		books.add(new Book(6, "�ں�֮��" ,"��˹��������" ,22));
		books.add(new Book(7, "�ϻ���" ,"ׯ��" ,14));
		bookDb.put(new Category(3 , "��ѧ��") , books);
	}
	public Book getBookById(int id)
	{
		for(List<Book> books : bookDb.values())
		{
			for(Book book : books)
			{
				if(book.getId() == id)
				{
					return book;
				}
			}
		}
		return null;
	}

	public List<Book> getAllBooks()
	{
		List<Book> result = new ArrayList<>();
		for(List<Book> books : bookDb.values())
		{
			result.addAll(books);
		}
		return result;
	}

	public List<Book> getBooksByPage(int start , int page , int limit)
	{
		List<Book> allBooks = getAllBooks();
		int toIndex = page * limit < allBooks.size() ? page * limit : allBooks.size();
		return allBooks.subList(start , toIndex);
	}

	public List<Book> getBooksByPrefix(String prefix)
	{
		List<Book> result = new ArrayList<>();
		for(List<Book> books : bookDb.values())
		{
			for (Book book : books )
			{
				if(book.getName().startsWith(prefix))
				{
					result.add(book);
				}
			}
		}
		return result;
	}

	public int getBookCount()
	{
		return getAllBooks().size();
	}

	public Set<Category> getAllCategorys()
	{
		return bookDb.keySet();
	}

	public List<Book> getBooksByCategory(int categoryId)
	{
		for(Category category : bookDb.keySet())
		{
			if(category.getId() == categoryId)
			{
				return bookDb.get(category);
			}
		}
		return null;
	}
	public boolean updateBook(int id , String name
		, String author, double price)
	{
		for(List<Book> books : bookDb.values())
		{
			for (Book book : books )
			{
				if(book.getId() == id)
				{
					book.setName(name);
					book.setAuthor(author);
					book.setPrice(price);
					return true;
				}
			}
		}
		return false;
	}

	public boolean deleteBook(int id)
	{
		for(List<Book> books : bookDb.values())
		{
			for (Book book : books )
			{
				if(book.getId() == id)
				{
					books.remove(book);
					return true;
				}
			}
		}
		return false;
	}
}
