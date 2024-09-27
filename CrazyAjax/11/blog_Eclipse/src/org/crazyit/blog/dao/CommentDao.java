package org.crazyit.blog.dao;

import java.util.*;

import org.crazyit.blog.domain.*;
import org.crazyit.common.dao.*;
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
public interface CommentDao extends BaseDao<Comment>
{
	/**
	 * ����Blog����ҳ������������
	 * @param b ��������ӦBlog���µ�ID
	 * @param pageNo ����ָ��ҳ��Blog
	 * @param pageSize ÿҳ��ʾ����������
	 * @return ���ҵ������ۼ���
	 */
	List<Comment> findByBlogAndPage(int blogId , int pageNo , int pageSize);

	/**
	 * ����Blog�ļ�����ȡ����������������
	 * @param blogId ָ��Blog���µ�ID
	 * @return ָ��Blog���������������۵�����
	 */
	long findCountByBlog(int blogId);
}