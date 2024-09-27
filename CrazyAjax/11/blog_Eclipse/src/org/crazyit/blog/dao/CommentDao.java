package org.crazyit.blog.dao;

import java.util.*;

import org.crazyit.blog.domain.*;
import org.crazyit.common.dao.*;
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
public interface CommentDao extends BaseDao<Comment>
{
	/**
	 * 根据Blog、和页码来查找评论
	 * @param b 评论所对应Blog文章的ID
	 * @param pageNo 查找指定页的Blog
	 * @param pageSize 每页显示的评论数量
	 * @return 查找到的评论集合
	 */
	List<Comment> findByBlogAndPage(int blogId , int pageNo , int pageSize);

	/**
	 * 根据Blog文件来获取它关联的评论总数
	 * @param blogId 指定Blog文章的ID
	 * @return 指定Blog文章所关联的评论的总数
	 */
	long findCountByBlog(int blogId);
}