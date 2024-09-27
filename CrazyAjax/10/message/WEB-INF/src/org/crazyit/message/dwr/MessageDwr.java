package org.crazyit.message.dwr;

import org.crazyit.message.dao.*;
import org.crazyit.message.domain.*;
import org.crazyit.message.exception.*;
import org.crazyit.message.service.*;
import org.crazyit.message.vo.*;

import java.util.List;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

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
public class MessageDwr
{
	// 该前端处理类所依赖的业务逻辑组件
	private MessageService messageService;
	// 依赖注入messageService组件所必须的setter方法
	public void setMessageService(MessageService messageService)
	{
		this.messageService = messageService;
	}

	// 创建一条新消息
	public int createMessage(String title , String content,
		HttpSession session)throws MessageException
	{
		Integer userId = (Integer)session.getAttribute("userId");
		Message m = new Message();
		m.setTitle(title);
		m.setContent(content);
		return messageService.createMessage(m , userId);
	}

	// 创建一个用户
	public int createUser(String user , String pass ,
		HttpSession session)throws MessageException
	{
		User u = new User();
		u.setName(user);
		u.setPass(pass);
		int userId = messageService.createUser(u);
		session.setAttribute("userId" , userId);
		return userId;
	}

	// 处理用户
	public int loginPro(String userName , String pass
		, HttpSession session) throws MessageException
	{
		User user = new User();
		user.setName(userName);
		user.setPass(pass);
		int userId = messageService.validateLogin(user);
		if(userId > 0)
		{
			session.setAttribute("userId" , userId);
		}
		return userId;
	}

	// 判断当前页面的浏览者是否已登录
	public int isLogin(HttpSession session)
		throws MessageException
	{
		Integer userId = (Integer)session.getAttribute("userId");
		if (userId != null && userId > 0)
		{
			return (Integer)userId;
		}
		return -1;
	}

	// 根据消息ID返回消息
	public MessageBean getMessage(int msgId
		, HttpSession session)throws MessageException
	{
		return messageService.getMessage(msgId);
	}

	// 返回指定页所显示全部消息
	public List<MessageBean> getAllMessageByPage(int pageNo
		, HttpSession session)throws MessageException
	{
		return messageService.getAllMessageByPage(pageNo);
	}
}