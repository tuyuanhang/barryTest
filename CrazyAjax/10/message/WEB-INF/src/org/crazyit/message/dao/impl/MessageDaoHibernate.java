package org.crazyit.message.dao.impl;

import org.crazyit.message.domain.*;
import org.crazyit.message.dao.*;
import org.crazyit.common.dao.impl.*;

import java.io.Serializable;
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
public class MessageDaoHibernate
	extends BaseDaoHibernate4<Message> implements MessageDao
{
	/**
	 * ��ѯָ���û���ָ��ҳ����Ϣ
	 * @param pageNo ��Ҫ��ѯ��ָ��ҳ
	 * @return ��ѯ������Ϣ����
	 */
	public List<Message> findAllByPage(int pageNo)
	{
		return findByPage("select m from Message m order by m.id desc"
			, pageNo , PAGE_SIZE);
	}
}
