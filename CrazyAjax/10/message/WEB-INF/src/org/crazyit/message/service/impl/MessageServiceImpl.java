package org.crazyit.message.service.impl;

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
public class MessageServiceImpl implements MessageService
{
	// 该业务逻辑组件所依赖的两个DAO组件
	private UserDao userDao;
	private MessageDao messDao;
	// 依赖注入两个DAO组件所需的setter方法
	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}
	public void setMessDao(MessageDao messDao)
	{
		this.messDao = messDao;
	}

	/**
	 * 创建一条消息
	 * @param title 新信息的标题
	 * @param content 新消息的父节点
	 * @param userId 创建消息的用户Id
	 * @param session 进行权限控制的Session
	 * @return 新创建消息的主键,如果创建失败，返回-1。
	 */
	public int createMessage(Message message ,int userId)
	{
		try
		{
			User u = userDao.get(User.class , userId);
			if ( u != null)
			{
				message.setUser(u);
				return (Integer)messDao.save(message);
			}
			return -1;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new MessageException("添加消息出现异常");
		}
	}

	/**
	 * 创建一个用户
	 * @param user 新创建的用户
	 * @return 新创建用户的主键
	 */
	public int createUser(User user)
	{
		if (userDao.findByName(user.getName()) != null)
			throw new MessageException("该用户名已经存在");
		try
		{
			userDao.save(user);
			return user.getId();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new MessageException("注册用户出现异常");
		}
	}

	/**
	 * 验证用户登录是否成功
	 * @param user 登录所用的用户名
	 * @return 登录成功，返回登录用户ID，否则返回-1
	 */
	public int validateLogin(User user)
	{
		try
		{
			User u = userDao.findByNameAndPass(user.getName()
				, user.getPass());
			if (u != null)
			{
				return u.getId();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new MessageException("处理登录出现异常");
		}
		return -1;
	}

	/**
	 * 根据消息ID返回消息
	 * @param msgId 消息ID
	 * @return 指定ID对应的消息
	 */
	public MessageBean getMessage(int msgId)
	{
		try
		{
			Message m = messDao.get(Message.class , msgId);
			if (m != null)
			{
				return new MessageBean(0 , m.getTitle() ,
					m.getContent() , m.getUser().getId() ,
					m.getUser().getName());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new MessageException("获取消息内容出现异常");
		}
		return null;
	}

	/**
	 * 返回特定页面所有消息
	 * @param pageNo 指定页码
	 * @param session 进行权限控制的Session
	 * @return 指定页的全部消息
	 */
	public List<MessageBean> getAllMessageByPage(int pageNo)
	{
		try
		{
			List<Message> ml = messDao.findAllByPage(pageNo);
			if (ml != null && ml.size() > 0)
			{
				List<MessageBean> result = new ArrayList<>();
				for (Message msg : ml)
				{
					result.add(new MessageBean(msg.getId(),msg.getTitle(),
						null , 0 , msg.getUser().getName()));
				}
				return result;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new MessageException("获取消息列表出现异常");
		}
		return null;
	}
}