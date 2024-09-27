package org.crazyit.ajax.dwr;

import java.util.*;

import org.directwebremoting.*;
import org.directwebremoting.ui.dwr.Util;

import org.crazyit.ajax.dto.*;

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
public class JavaChat
{
	// 保存聊天信息的List对象
	private LinkedList<ChatMsg> messages =
		new LinkedList<ChatMsg>();
	public void addMessage(String text)
	{
		if (text != null && text.trim().length() > 0)
		{
			messages.addFirst(new ChatMsg(text));
			// 最多保留10条聊天记录
			while (messages.size() > 10)
			{
				messages.removeLast();
			}
		}
		WebContext wctx = WebContextFactory.get();
		// 控制修改当前Script Session关联的浏览器中文档的状态
		Browser.withSession(wctx.getScriptSession().getId() , new Runnable()
		{
			public void run()
			{
				// 将text文本框设为空
				Util.setValue("text", "");
			}
		});
		// 控制所有正在浏览该页面的所有浏览器中文档的状态
		Browser.withCurrentPage(new Runnable()
		{
			public void run()
			{
				// 删除chatlog列表里的所有列表项
				Util.removeAllOptions("chatlog");
				// 使用messages集合里集合元素的text属性为chatlog添加列表项
				Util.addOptions("chatlog" , messages , "text");
			}
		});
	}
}