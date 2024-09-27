package org.crazyit.blog.service;

import org.crazyit.blog.exception.*;
import org.crazyit.blog.vo.*;

import java.util.*;
import javax.servlet.http.HttpServletRequest;

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
public interface BlogService
{
	/**
	 * ����һƪ�µ�Blog
	 * @param title Blog�ı���
	 * @param content Blog������
	 * @return �´���Blog������,�������ʧ�ܣ�����-1��
	 */
	int createBlog(String title , String content);

	/**
	 * ����һ������
	 * @param user �������۵��û�
	 * @param email ���������û��ĵ�Email
	 * @param url ���������û��ĵ�url
	 * @param content �������۵�����
	 * param blogId ������������Ӧ��Blog Id
	 * @return �·������۵�����
	 */
	int createComment(String user, String email, String url,
				String content, int blogId);

	/**
	 * ����ָ��ҳ��Blog�б�
	 * @param pageNo ָ��ҳ��
	 * @param pageSize ÿҳ��ʾ��Blog����
	 * @return ָ��ҳ��Blog�б�
	 */
	List<BlogBean> getAllBlogByPage(int pageNo , int pageSize);

	/**
	 * ����Blog���µ�����
	 * @return Blog���µ�����
	 */
	long getBlogCount();

	/**
	 * ����ָ��Blog,ָ��ҳ����Ӧ������
	 * @param blogId ָ��Blog��ID
	 * @param pageNo ָ��ҳ��
	 * @param pageSize ÿҳ��ʾ����������
	 * @return ָ��Blog��ָ��ҳ�����������
	 */
	List<CommentBean> getCommentsByBlogAndPage(int blogId
		, int pageNo , int pageSize);

	/**
	 * ����ָ��Blog���¶�Ӧ����������
	 * @param blogId ָ��Blog��ID
	 * @return ��Blog���µ����۵�����
	 */
	long getCommentCountByBlog(int blogId);

	/**
	 * ����ָ��Blog����
	 * @param blogId ��Ҫ��ѯ��Blog���µ�id
	 * @return blogId��Ӧ��Blog����
	 */
	BlogBean getBlog(int blogId);
}