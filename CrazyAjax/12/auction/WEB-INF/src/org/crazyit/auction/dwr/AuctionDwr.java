package org.crazyit.auction.dwr;

import java.util.*;
import javax.servlet.http.*;

import org.crazyit.auction.business.*;
import org.crazyit.auction.exception.*;
import org.crazyit.auction.dao.*;
import org.crazyit.auction.domain.*;
import org.crazyit.auction.service.AuctionService;

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
public class AuctionDwr
{
	// 该前端处理类所依赖的业务逻辑组件
	private AuctionService auctionService;
	public void setAuctionService(AuctionService auctionService)
	{
		this.auctionService = auctionService;
	}
	// 通过赢取者获取物品的方法
	public List<ItemBean> getItemByWiner(HttpSession sess)
		throws Exception
	{
		// 从HttpSession中取出userId属性
		Integer winerId = (Integer)sess.getAttribute("userId");
		return auctionService.getItemByWiner(winerId);
	}
	// 获取所有流拍物品的方法
	public List<ItemBean> getFailItems() throws Exception
	{
		return auctionService.getFailItems();
	}
	// 处理用户登录的方法
	public boolean validLogin(String username , String pass
		, String verCode , HttpSession sess) throws Exception
	{
		String rand = (String)sess.getAttribute("rand");
		if (!rand.equalsIgnoreCase(verCode))
		{
			throw new AuctionException("您输入的验证码不对,请重试");
		}
		int result = auctionService.validLogin(username , pass);
		if (result > 0)
		{
			sess.setAttribute("userId" , result);
			return true;
		}
		return false;
	}
	// 获取用户竞价的方法
	public List<BidBean> getBidByUser(HttpSession sess) throws Exception
	{
		// 从HttpSession中取出userId属性
		Integer userId = (Integer)sess.getAttribute("userId");
		return auctionService.getBidByUser(userId);
	}
	// 根据属主获取物品的方法
	public List<ItemBean> getItemsByOwner(HttpSession sess) throws Exception
	{
		// 从HttpSession中取出userId属性
		Integer userId = (Integer)sess.getAttribute("userId");
		return auctionService.getItemsByOwner(userId);
	}
	// 获取所有物品种类的方法
	public List<KindBean> getAllKind() throws Exception
	{
		return auctionService.getAllKind();
	}
	// 添加物品的方法
	public int addItem(String name , String desc , String remark
		, double initPrice, int avail , int kind , HttpSession sess)
		throws Exception
	{
		// 从HttpSession中取出userId属性
		Integer userId = (Integer)sess.getAttribute("userId");
		Item item = new Item();
		item.setItemName(name);
		item.setItemDesc(desc);
		item.setItemRemark(remark);
		item.setInitPrice(initPrice);
		return auctionService.addItem(item , avail , kind , userId);
	}
	// 添加种类的方法
	public int addKind(String name , String desc)
		throws Exception
	{
		Kind kind = new Kind();
		kind.setKindName(name);
		kind.setKindDesc(desc);
		return auctionService.addKind(kind);
	}
	// 根据种类获取物品的方法
	public List<ItemBean> getItemsByKind(int kindId) throws Exception
	{
		return auctionService.getItemsByKind(kindId);
	}
	// 根据种类ID获取种类的方法
	public String getKind(int kindId) throws Exception
	{
		return auctionService.getKind(kindId);
	}
	// 根据物品ID获取物品的方法
	public ItemBean getItem(int itemId)
		throws Exception
	{
		return auctionService.getItem(itemId);
	}
	// 添加竞价记录的方法
	public int addBid(int itemId , double bidPrice , HttpSession sess)
		throws Exception
	{
		Integer userId = (Integer)sess.getAttribute("userId");
		Bid bid = new Bid();
		bid.setBidPrice(bidPrice);
		return auctionService.addBid(itemId , bid , userId);
	}
}