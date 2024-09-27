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
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class MessageDwr
{
	// ��ǰ�˴�������������ҵ���߼����
	private MessageService messageService;
	// ����ע��messageService����������setter����
	public void setMessageService(MessageService messageService)
	{
		this.messageService = messageService;
	}

	// ����һ������Ϣ
	public int createMessage(String title , String content,
		HttpSession session)throws MessageException
	{
		Integer userId = (Integer)session.getAttribute("userId");
		Message m = new Message();
		m.setTitle(title);
		m.setContent(content);
		return messageService.createMessage(m , userId);
	}

	// ����һ���û�
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

	// �����û�
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

	// �жϵ�ǰҳ���������Ƿ��ѵ�¼
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

	// ������ϢID������Ϣ
	public MessageBean getMessage(int msgId
		, HttpSession session)throws MessageException
	{
		return messageService.getMessage(msgId);
	}

	// ����ָ��ҳ����ʾȫ����Ϣ
	public List<MessageBean> getAllMessageByPage(int pageNo
		, HttpSession session)throws MessageException
	{
		return messageService.getAllMessageByPage(pageNo);
	}
}