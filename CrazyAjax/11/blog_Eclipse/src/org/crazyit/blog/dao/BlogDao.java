package org.crazyit.blog.dao;

import java.util.List;

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
public interface BlogDao extends BaseDao<Blog>
{
	/**
	 * 查询指定页的Blog
	 * @param pageNo 需要查询的页码
	 * @param pageSize 每页显示的Blog数
	 * @return 查询到的Blog集合
	 */
	List findAllByPage(int pageNo , int pageSize);
}