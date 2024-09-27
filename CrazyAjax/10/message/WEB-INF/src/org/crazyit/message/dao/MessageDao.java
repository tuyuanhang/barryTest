package org.crazyit.message.dao;

import java.util.List;

import org.crazyit.message.domain.*;
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
public interface MessageDao extends BaseDao<Message>
{
	// 设置每页显示的记录条数
	public static final int PAGE_SIZE = 4;
	/**
	 * 查询指定页应该显示的消息（控制分页的查询方法）
	 * @param pageNo 需要查询的页码
	 * @return 查询到的消息集合
	 */
	List<Message> findAllByPage(int pageNo);
}