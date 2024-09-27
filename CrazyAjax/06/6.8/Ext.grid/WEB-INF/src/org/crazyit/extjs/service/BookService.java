package org.crazyit.extjs.service;

import org.crazyit.extjs.domain.*;
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
public class BookService
{
	// 使用List集合模拟内存中的数据库
	static Map<Category , List<Book>> bookDb = new LinkedHashMap<>();
	static
	{
		List<Book> books = new ArrayList<Book>();
		books.add(new Book(1, "疯狂Java讲义" ,"李刚" ,109));
		books.add(new Book(2, "疯狂Android讲义" ,"李刚" ,89));
		books.add(new Book(3, "疯狂Ajax讲义" ,"李刚" ,69));
		bookDb.put(new Category(1 , "编程图书") , books);
		books = new ArrayList<Book>();
		books.add(new Book(4, "西游记" ,"吴承恩" ,21));
		books.add(new Book(5, "三国演义" ,"罗贯中" ,18));
		bookDb.put(new Category(2 , "小说") , books);
		books = new ArrayList<Book>();
		books.add(new Book(6, "乌合之众" ,"古斯塔夫·勒庞" ,22));
		books.add(new Book(7, "南华经" ,"庄子" ,14));
		bookDb.put(new Category(3 , "哲学类") , books);
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
