package org.crazyit.message.vo;

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
public class MessageBean
{
	// ������Ϣid
	private int id;
	// ��Ϣ����
	private String title;
	// ��Ϣ����
	private String content;
	// ��Ϣ������id
	private int owerId;
	// ��Ϣ�����ߵ�����
	private String owerName;


	// �޲����Ĺ�����
	public MessageBean()
	{
	}
	// ��ʼ��ȫ�����ԵĹ�����
	public MessageBean(int id , String title ,
		String content , int owerId , String owerName)
	{
		this.id = id;
		this.title = title;
		this.content = content;
		this.owerId = owerId;
		this.owerName = owerName;
	}

	// id���Ե�setter��getter����
	public void setId(int id)
	{
		this.id = id;
	}
	public int getId()
	{
		return this.id;
	}

	// title���Ե�setter��getter����
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return this.title;
	}

	// content���Ե�setter��getter����
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getContent()
	{
		return this.content;
	}

	// owerId���Ե�setter��getter����
	public void setOwerId(int owerId)
	{
		this.owerId = owerId;
	}
	public int getOwerId()
	{
		return this.owerId;
	}

	// owerName���Ե�setter��getter����
	public void setOwerName(String owerName)
	{
		this.owerName = owerName;
	}
	public String getOwerName()
	{
		return this.owerName;
	}
}