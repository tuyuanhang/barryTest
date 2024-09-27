package org.crazyit.auction.dao.impl;

import java.util.*;

import org.crazyit.common.dao.impl.*;

import org.crazyit.auction.domain.*;
import org.crazyit.auction.business.*;
import org.crazyit.auction.dao.*;

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
public class AuctionUserDaoHibernate
	extends BaseDaoHibernate4<AuctionUser> implements AuctionUserDao
{

	/**
	 * 根据用户名，密码查找用户
	 * @param username 查询所需的用户名
	 * @param pass 查询所需的密码
	 * @return 指定用户名、密码对应的用户
	 */
	public AuctionUser findByNameAndPass(String username , String pass)
	{
		// 执行HQL查询
		List<AuctionUser> ul = (List<AuctionUser>)find(
			"from AuctionUser au where au.username=?0 and au.userpass=?1" ,
			username , pass);
		// 返回查询得到的第一个AuctionUser对象
		if (ul != null && ul.size() == 1)
		{
			return (AuctionUser)ul.get(0);
		}
		return null;
	}
	/**
	 * 根据物品id、出价查询用户
	 * @param itemId 物品id;
	 * @param price 竞价的价格
	 * @return 指定物品、指定竞价对应的用户
	 */
	public AuctionUser findByItemAndPrice(Integer itemId , Double price)
	{
		// 执行HQL查询
		List<AuctionUser> userList = (List<AuctionUser>)find(
			"select user from AuctionUser user inner join user.bids bid"
			+ " where bid.bidItem.id=?0 and bid.bidPrice=?1"
			, itemId , price);
		// 返回查询得到的第一个Bid对象关联的AuctionUser对象
		if (userList != null && userList.size() == 1)
		{
			return userList.get(0);
		}
		return null;
	}
}