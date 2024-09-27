package org.crazyit.blog.dao.impl;

import org.crazyit.blog.domain.*;
import org.crazyit.blog.dao.*;
import org.crazyit.common.dao.impl.*;


import java.util.List;

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
public class BlogDaoHibernate
	extends BaseDaoHibernate4<Blog> implements BlogDao
{
	/**
	 * 查询指定页的Blog
	 * @param pageNo 需要查询的页码
	 * @return 查询到的Blog集合
	 */
	public List findAllByPage(int pageNo , int pageSize)
	{
		//返回分页查询的结果
		return findByPage("select b from Blog b order by b.id desc"
			, pageNo , pageSize);
	}
}