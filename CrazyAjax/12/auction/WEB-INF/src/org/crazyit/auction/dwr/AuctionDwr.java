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
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class AuctionDwr
{
	// ��ǰ�˴�������������ҵ���߼����
	private AuctionService auctionService;
	public void setAuctionService(AuctionService auctionService)
	{
		this.auctionService = auctionService;
	}
	// ͨ��Ӯȡ�߻�ȡ��Ʒ�ķ���
	public List<ItemBean> getItemByWiner(HttpSession sess)
		throws Exception
	{
		// ��HttpSession��ȡ��userId����
		Integer winerId = (Integer)sess.getAttribute("userId");
		return auctionService.getItemByWiner(winerId);
	}
	// ��ȡ����������Ʒ�ķ���
	public List<ItemBean> getFailItems() throws Exception
	{
		return auctionService.getFailItems();
	}
	// �����û���¼�ķ���
	public boolean validLogin(String username , String pass
		, String verCode , HttpSession sess) throws Exception
	{
		String rand = (String)sess.getAttribute("rand");
		if (!rand.equalsIgnoreCase(verCode))
		{
			throw new AuctionException("���������֤�벻��,������");
		}
		int result = auctionService.validLogin(username , pass);
		if (result > 0)
		{
			sess.setAttribute("userId" , result);
			return true;
		}
		return false;
	}
	// ��ȡ�û����۵ķ���
	public List<BidBean> getBidByUser(HttpSession sess) throws Exception
	{
		// ��HttpSession��ȡ��userId����
		Integer userId = (Integer)sess.getAttribute("userId");
		return auctionService.getBidByUser(userId);
	}
	// ����������ȡ��Ʒ�ķ���
	public List<ItemBean> getItemsByOwner(HttpSession sess) throws Exception
	{
		// ��HttpSession��ȡ��userId����
		Integer userId = (Integer)sess.getAttribute("userId");
		return auctionService.getItemsByOwner(userId);
	}
	// ��ȡ������Ʒ����ķ���
	public List<KindBean> getAllKind() throws Exception
	{
		return auctionService.getAllKind();
	}
	// �����Ʒ�ķ���
	public int addItem(String name , String desc , String remark
		, double initPrice, int avail , int kind , HttpSession sess)
		throws Exception
	{
		// ��HttpSession��ȡ��userId����
		Integer userId = (Integer)sess.getAttribute("userId");
		Item item = new Item();
		item.setItemName(name);
		item.setItemDesc(desc);
		item.setItemRemark(remark);
		item.setInitPrice(initPrice);
		return auctionService.addItem(item , avail , kind , userId);
	}
	// �������ķ���
	public int addKind(String name , String desc)
		throws Exception
	{
		Kind kind = new Kind();
		kind.setKindName(name);
		kind.setKindDesc(desc);
		return auctionService.addKind(kind);
	}
	// ���������ȡ��Ʒ�ķ���
	public List<ItemBean> getItemsByKind(int kindId) throws Exception
	{
		return auctionService.getItemsByKind(kindId);
	}
	// ��������ID��ȡ����ķ���
	public String getKind(int kindId) throws Exception
	{
		return auctionService.getKind(kindId);
	}
	// ������ƷID��ȡ��Ʒ�ķ���
	public ItemBean getItem(int itemId)
		throws Exception
	{
		return auctionService.getItem(itemId);
	}
	// ��Ӿ��ۼ�¼�ķ���
	public int addBid(int itemId , double bidPrice , HttpSession sess)
		throws Exception
	{
		Integer userId = (Integer)sess.getAttribute("userId");
		Bid bid = new Bid();
		bid.setBidPrice(bidPrice);
		return auctionService.addBid(itemId , bid , userId);
	}
}