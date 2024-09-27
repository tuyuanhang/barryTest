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
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class MessageServiceImpl implements MessageService
{
	// ��ҵ���߼����������������DAO���
	private UserDao userDao;
	private MessageDao messDao;
	// ����ע������DAO��������setter����
	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}
	public void setMessDao(MessageDao messDao)
	{
		this.messDao = messDao;
	}

	/**
	 * ����һ����Ϣ
	 * @param title ����Ϣ�ı���
	 * @param content ����Ϣ�ĸ��ڵ�
	 * @param userId ������Ϣ���û�Id
	 * @param session ����Ȩ�޿��Ƶ�Session
	 * @return �´�����Ϣ������,�������ʧ�ܣ�����-1��
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
			throw new MessageException("�����Ϣ�����쳣");
		}
	}

	/**
	 * ����һ���û�
	 * @param user �´������û�
	 * @return �´����û�������
	 */
	public int createUser(User user)
	{
		if (userDao.findByName(user.getName()) != null)
			throw new MessageException("���û����Ѿ�����");
		try
		{
			userDao.save(user);
			return user.getId();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new MessageException("ע���û������쳣");
		}
	}

	/**
	 * ��֤�û���¼�Ƿ�ɹ�
	 * @param user ��¼���õ��û���
	 * @return ��¼�ɹ������ص�¼�û�ID�����򷵻�-1
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
			throw new MessageException("�����¼�����쳣");
		}
		return -1;
	}

	/**
	 * ������ϢID������Ϣ
	 * @param msgId ��ϢID
	 * @return ָ��ID��Ӧ����Ϣ
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
			throw new MessageException("��ȡ��Ϣ���ݳ����쳣");
		}
		return null;
	}

	/**
	 * �����ض�ҳ��������Ϣ
	 * @param pageNo ָ��ҳ��
	 * @param session ����Ȩ�޿��Ƶ�Session
	 * @return ָ��ҳ��ȫ����Ϣ
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
			throw new MessageException("��ȡ��Ϣ�б�����쳣");
		}
		return null;
	}
}