package org.crazyit.ajax.dto;
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
public class ChatMsg
{
	// ChatMsg包装的字符串
	private String text;
	public ChatMsg()
	{
	}
	public ChatMsg(String text)
	{
		this.text = text;
	}
	// text属性的setter和gette方法
	public void setText(String text)
	{
		this.text = text;
	}
	public String getText()
	{
		return text;
	}
}