package org.crazyit.blog.dao;

import java.util.List;

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
public interface BlogDao extends BaseDao<Blog>
{
	/**
	 * ��ѯָ��ҳ��Blog
	 * @param pageNo ��Ҫ��ѯ��ҳ��
	 * @param pageSize ÿҳ��ʾ��Blog��
	 * @return ��ѯ����Blog����
	 */
	List findAllByPage(int pageNo , int pageSize);
}