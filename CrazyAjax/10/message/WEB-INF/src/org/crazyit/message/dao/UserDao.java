package org.crazyit.message.dao;

import java.util.*;

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
public interface UserDao extends BaseDao<User>
{
	/**
	 * �����û��������û�
	 * @param name ��Ҫ�����û����û���
	 * @return ���ҵ����û�
	 */
	User findByName(String name);

	/**
	 * �����û�������������û�
	 * @param name ��Ҫ�����û����û���
	 * @param pass ��Ҫ�����û�������
	 * @return ���ҵ����û�
	 */
	User findByNameAndPass(String name ,String pass);
}