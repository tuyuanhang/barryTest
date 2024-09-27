package org.crazyit.blog.service.impl;

import org.crazyit.blog.dao.*;
import org.crazyit.blog.domain.*;
import org.crazyit.blog.exception.*;
import org.crazyit.blog.service.*;
import org.crazyit.blog.vo.*;

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
public class BlogServiceImpl implements BlogService
{
	private BlogDao blogDao;
	private CommentDao commentDao;

	// ����ע��ҵ���߼�����������setter����
	public void setBlogDao(BlogDao blogDao)
	{
		this.blogDao = blogDao;
	}
	public void setCommentDao(CommentDao commentDao)
	{
		this.commentDao = commentDao;
	}

	/**
	 * ����һƪ�µ�Blog
	 * @param title Blog�ı���
	 * @param content Blog������
	 * @return �´���Blog������,�������ʧ�ܣ�����-1��
	 */
	public int createBlog(String title , String content)
	{
		try
		{
			Blog b = new Blog();
			b.setTitle(title);
			b.setContent(content);
			b.setAddTime(new Date());
			blogDao.save(b);
			return b.getId();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new BlogException("����Blog���³���");
		}
	}

	/**
	 * ����һ������
	 * @param user �������۵��û�
	 * @param email ���������û��ĵ�Email
	 * @param url ���������û��ĵ�url
	 * @param content �������۵�����
	 * param blogId ������������Ӧ��Blog Id
	 * @return �·������۵�����
	 */
	public int createComment(String user, String email, String url
		, String content, int blogId)
	{
		Blog b = blogDao.get(Blog.class , blogId);
		if (b == null)
		{
			return -1;
		}
		try
		{
			Comment c = new Comment();
			c.setUser(user);
			c.setEmail(email);
			c.setUrl(url);
			c.setContent(content);
			c.setAddTime(new Date());
			c.setBlog(b);
			commentDao.save(c);
			return c.getId();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new BlogException("�����������۳���");
		}
	}

	/**
	 * ����ָ��ҳ��Blog�б�
	 * @param pageNo ָ��ҳ��
	 * @param pageSize ÿҳ��ʾ��Blog����
	 * @return ָ��ҳ��Blog�б�
	 */
	public List<BlogBean> getAllBlogByPage(int pageNo , int pageSize)
	{
		List<BlogBean> result = new ArrayList<BlogBean>();
		try
		{
			List bl = blogDao.findAllByPage(pageNo , pageSize);
			for (Object o : bl)
			{
				Blog b = (Blog)o;
				result.add(new BlogBean(b.getId() ,
					b.getTitle() , null , null));
			}
			return result;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new BlogException("��ȡ���±����б����");
		}
	}
	/**
	 * ����Blog���µ�����
	 * @return Blog���µ�����
	 */
	public long getBlogCount()
	{
		try
		{
			return blogDao.findCount(Blog.class);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new BlogException("��ȡBlog������������");
		}
	}

	/**
	 * ����ָ��Blog,ָ��ҳ����Ӧ������
	 * @param blogId ָ��Blog��ID
	 * @param pageNo ָ��ҳ��
	 * @param pageSize ÿҳ��ʾ��������
	 * @return ָ��Blog��ָ��ҳ�����������
	 */
	public List<CommentBean> getCommentsByBlogAndPage(int blogId
		, int pageNo , int pageSize)
	{
		try
		{
			List<Comment> cl = commentDao.findByBlogAndPage(blogId , pageNo
				, pageSize);
			List<CommentBean> result = new ArrayList<CommentBean>();
			for (Comment c : cl)
			{
				result.add(new CommentBean(c.getUser() , c.getEmail() ,
					c.getUrl() , c.getContent() , c.getAddTime()));
			}
			return result;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new BlogException("��ȡ���������б����");
		}
	}

	public long getCommentCountByBlog(int blogId)
	{
		try
		{
			return commentDao.findCountByBlog(blogId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new BlogException("����Blog���»�ȡ������������");
		}
	}


	/**
	 * ����ָ��Blog����
	 * @param blogId ��Ҫ��ѯ��Blog���µ�id
	 * @return blogId��Ӧ��Blog����
	 */
	public BlogBean getBlog(int blogId)
	{
		try
		{
			Blog b = blogDao.get(Blog.class , blogId);
			return new BlogBean(b.getId() , b.getTitle() ,
				b.getContent() ,  b.getAddTime());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new BlogException("��ȡָ��Blog���³���");
		}
	}
}