package org.crazyit.blog.dao.impl;

import org.crazyit.blog.domain.*;
import org.crazyit.blog.dao.*;
import org.crazyit.common.dao.impl.*;


import java.util.List;

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
public class BlogDaoHibernate
	extends BaseDaoHibernate4<Blog> implements BlogDao
{
	/**
	 * ��ѯָ��ҳ��Blog
	 * @param pageNo ��Ҫ��ѯ��ҳ��
	 * @return ��ѯ����Blog����
	 */
	public List findAllByPage(int pageNo , int pageSize)
	{
		//���ط�ҳ��ѯ�Ľ��
		return findByPage("select b from Blog b order by b.id desc"
			, pageNo , pageSize);
	}
}