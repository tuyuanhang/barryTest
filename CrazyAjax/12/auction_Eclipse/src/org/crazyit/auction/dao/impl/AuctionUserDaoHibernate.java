package org.crazyit.auction.dao.impl;

import java.util.*;

import org.crazyit.common.dao.impl.*;

import org.crazyit.auction.domain.*;
import org.crazyit.auction.business.*;
import org.crazyit.auction.dao.*;

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
public class AuctionUserDaoHibernate
	extends BaseDaoHibernate4<AuctionUser> implements AuctionUserDao
{

	/**
	 * �����û�������������û�
	 * @param username ��ѯ������û���
	 * @param pass ��ѯ���������
	 * @return ָ���û����������Ӧ���û�
	 */
	public AuctionUser findByNameAndPass(String username , String pass)
	{
		// ִ��HQL��ѯ
		List<AuctionUser> ul = (List<AuctionUser>)find(
			"from AuctionUser au where au.username=?0 and au.userpass=?1" ,
			username , pass);
		// ���ز�ѯ�õ��ĵ�һ��AuctionUser����
		if (ul != null && ul.size() == 1)
		{
			return (AuctionUser)ul.get(0);
		}
		return null;
	}
	/**
	 * ������Ʒid�����۲�ѯ�û�
	 * @param itemId ��Ʒid;
	 * @param price ���۵ļ۸�
	 * @return ָ����Ʒ��ָ�����۶�Ӧ���û�
	 */
	public AuctionUser findByItemAndPrice(Integer itemId , Double price)
	{
		// ִ��HQL��ѯ
		List<AuctionUser> userList = (List<AuctionUser>)find(
			"select user from AuctionUser user inner join user.bids bid"
			+ " where bid.bidItem.id=?0 and bid.bidPrice=?1"
			, itemId , price);
		// ���ز�ѯ�õ��ĵ�һ��Bid���������AuctionUser����
		if (userList != null && userList.size() == 1)
		{
			return userList.get(0);
		}
		return null;
	}
}