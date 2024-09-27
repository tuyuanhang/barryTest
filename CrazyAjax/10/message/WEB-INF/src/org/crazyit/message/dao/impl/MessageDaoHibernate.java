package org.crazyit.message.dao.impl;

import org.crazyit.message.domain.*;
import org.crazyit.message.dao.*;
import org.crazyit.common.dao.impl.*;

import java.io.Serializable;
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
public class MessageDaoHibernate
	extends BaseDaoHibernate4<Message> implements MessageDao
{
	/**
	 * 查询指定用户、指定页的消息
	 * @param pageNo 需要查询的指定页
	 * @return 查询到的消息集合
	 */
	public List<Message> findAllByPage(int pageNo)
	{
		return findByPage("select m from Message m order by m.id desc"
			, pageNo , PAGE_SIZE);
	}
}
