package org.crazyit.ajax.dto;
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
public class ChatMsg
{
	// ChatMsg��װ���ַ���
	private String text;
	public ChatMsg()
	{
	}
	public ChatMsg(String text)
	{
		this.text = text;
	}
	// text���Ե�setter��gette����
	public void setText(String text)
	{
		this.text = text;
	}
	public String getText()
	{
		return text;
	}
}