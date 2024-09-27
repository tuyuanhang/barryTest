package org.crazyit.message.service;

import org.crazyit.message.domain.*;
import org.crazyit.message.exception.*;
import org.crazyit.message.vo.*;

import java.util.List;
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
public interface MessageService
{
	/**
	 * 创建一条消息
	 * @param title 新信息的标题
	 * @param message 新创建的消息
	 * @param userId 创建消息的用户Id
	 * @return 新创建消息的主键,如果创建失败，返回-1。
	 */
	int createMessage(Message message ,int userId);

	/**
	 * 创建一个用户
	 * @param user 新创建的用户
	 * @return 新创建用户的主键
	 */
	int createUser(User user);

	/**
	 * 验证用户登录是否成功
	 * @param user 登录的用户
	 * @return 登录成功，返回登录用户ID，否则返回-1
	 */
	int validateLogin(User user);

	/**
	 * 根据消息ID返回消息
	 * @param msgId 消息ID
	 * @return 指定ID对应的消息
	 */
	MessageBean getMessage(int msgId);

	/**
	 * 返回特定页面所有消息
	 * @param pageNo 指定页码
	 * @return 指定页的全部消息
	 */
	public List<MessageBean> getAllMessageByPage(int pageNo);
}