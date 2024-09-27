package org.crazyit.blog.dao.impl;

import org.crazyit.blog.domain.*;
import org.crazyit.blog.dao.*;
import org.crazyit.common.dao.impl.*;

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
public class CommentDaoHibernate
	extends BaseDaoHibernate4<Comment> implements CommentDao
{
	/**
	 * ����Blog����ҳ������������
	 * @param b ��������ӦBlog���µ�ID
	 * @param pageNo ����ָ��ҳ��Blog
	 * @return ���ҵ������ۼ���
	 */
	public List<Comment> findByBlogAndPage(int blogId , int pageNo , int pageSize)
	{
		return findByPage("select c from Comment c where c.blog.id = ?0"
			+ " order by c.id desc"
			, pageNo , pageSize , blogId);
	}

	/**
	 * ����Blog�ļ�����ȡ����������������
	 * @param blogId ָ��Blog���µ�ID
	 * @return ָ��Blog���������������۵�����
	 */
	public long findCountByBlog(int blogId)
	{
		List result = find("select count(*) from Comment c "
			+ "where c.blog.id = ?0" , blogId);
		// ��ѯ�õ���ʵ������
		if (result != null && result.size() == 1 )
		{
			return (Long)result.get(0);
		}
		return 0;
	}
}