package org.crazyit.message.dao.impl;

import org.crazyit.message.domain.*;
import org.crazyit.message.dao.*;
import org.crazyit.common.dao.impl.*;

import java.util.*;
import java.io.Serializable;
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
public class UserDaoHibernate
	extends BaseDaoHibernate4<User> implements UserDao
{
	/**
	 * �����û��������û�
	 * @param name ��Ҫ���ҵ��û����û���
	 * @return ���ҵ����û�
	 */
	public User findByName(String name)
	{
		List ul = find("select u from User u where u.name = ?0"
			, name);
		if (ul != null && ul.size() > 0)
		{
			return (User)ul.get(0);
		}
		return null;
	}

	/**
	 * �����û�������������û�
	 * @param name ��Ҫ�����û����û���
	 * @param pass ��Ҫ�����û�������
	 * @return ���ҵ����û�
	 */
	public User findByNameAndPass(String name , String pass)
	{
		List ul = find("select u from User u where"
			+ " u.name = ?0 and u.pass=?1" , name , pass);
		if (ul != null && ul.size() > 0)
		{
			return (User)ul.get(0);
		}
		return null;
	}
}