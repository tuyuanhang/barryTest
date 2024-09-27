package org.crazyit.message.service;

import org.crazyit.message.domain.*;
import org.crazyit.message.exception.*;
import org.crazyit.message.vo.*;

import java.util.List;
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
public interface MessageService
{
	/**
	 * ����һ����Ϣ
	 * @param title ����Ϣ�ı���
	 * @param message �´�������Ϣ
	 * @param userId ������Ϣ���û�Id
	 * @return �´�����Ϣ������,�������ʧ�ܣ�����-1��
	 */
	int createMessage(Message message ,int userId);

	/**
	 * ����һ���û�
	 * @param user �´������û�
	 * @return �´����û�������
	 */
	int createUser(User user);

	/**
	 * ��֤�û���¼�Ƿ�ɹ�
	 * @param user ��¼���û�
	 * @return ��¼�ɹ������ص�¼�û�ID�����򷵻�-1
	 */
	int validateLogin(User user);

	/**
	 * ������ϢID������Ϣ
	 * @param msgId ��ϢID
	 * @return ָ��ID��Ӧ����Ϣ
	 */
	MessageBean getMessage(int msgId);

	/**
	 * �����ض�ҳ��������Ϣ
	 * @param pageNo ָ��ҳ��
	 * @return ָ��ҳ��ȫ����Ϣ
	 */
	public List<MessageBean> getAllMessageByPage(int pageNo);
}