package org.crazyit.message.dao;

import java.util.List;

import org.crazyit.message.domain.*;
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
public interface MessageDao extends BaseDao<Message>
{
	// ����ÿҳ��ʾ�ļ�¼����
	public static final int PAGE_SIZE = 4;
	/**
	 * ��ѯָ��ҳӦ����ʾ����Ϣ�����Ʒ�ҳ�Ĳ�ѯ������
	 * @param pageNo ��Ҫ��ѯ��ҳ��
	 * @return ��ѯ������Ϣ����
	 */
	List<Message> findAllByPage(int pageNo);
}