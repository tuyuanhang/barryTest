package org.crazyit.chat.service;

import java.util.*;
import java.io.*;

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
public class ChatService
{
	// ʹ�õ���ģʽ�����ChatService
	private static ChatService cs;
	// ʹ��Properties���󱣴�ϵͳ�������û�
	private Properties userList;
	// ʹ��LinkedList���󱣴�������Ϣ
	private LinkedList<String> chatMsg;
	// ������˽��
	private ChatService()
	{
	}
	// ͨ����̬��������Ψһ��ChatService����
	public static ChatService instance()
	{
		if (cs == null)
		{
			cs = new ChatService();
		}
		return cs;
	}
	// ��֤�û��ĵ�¼
	public boolean validLogin(String user , String pass)
		throws IOException
	{
		// �����û�����ȡ����
		String loadPass = loadUser().getProperty(user);
		// ��¼�ɹ�
		if (loadPass != null
			&& loadPass.equals(pass))
		{
			return true;
		}
		return false;
	}
	// ��ע���û�
	public boolean addUser(String name , String pass)
		throws Exception
	{
		// ��userListΪnull����ʼ��userList����
		if (userList == null)
		{
			userList = loadUser();
		}
		// ���userList�Ѿ�����ע����û�
		if (userList.containsKey(name))
		{
			throw new Exception("�û����Ѿ����ڣ�������ѡ���û���");
		}
		userList.setProperty(name , pass);
		saveUserList();
		return true;
	}
	// ��ȡϵͳ������������Ϣ
	public String getMsg()
	{
		// ���chatMsg����Ϊnull������������ʼ����
		if(chatMsg == null)
		{
			chatMsg = new LinkedList<>();
			return "";
		}
		StringBuilder result = new StringBuilder();
		// ��chatMsg������������Ϣƴ��������
		for (String line : chatMsg)
		{
			result.append(line + "\n");
		}
		return result.toString();
	}
	// �û����ԣ����������Ϣ
	public void addMsg(String user , String msg)
	{
		// ���chatMsg����Ϊnull����ʼ��chatMsg����
		if (chatMsg == null)
		{
			chatMsg = new LinkedList<>();
		}
		// ��ౣ��40��������Ϣ��������40��֮�󣬽�ǰ��������Ϣɾ��
		if (chatMsg.size() > 40)
		{
			chatMsg.removeFirst();
		}
		//����µ�������Ϣ
		chatMsg.add(user + "˵��" + msg);
	}
	//------------������ϵͳ�Ĺ��߷���--------------
	// ��ȡϵͳ�û���Ϣ
	private Properties loadUser() throws IOException
	{
		if (userList == null)
		{
			// ����userFile.properties�ļ�
			File f = new File("userFile.properties");
			// ����ļ������ڣ��½����ļ�
			if (!f.exists())
			{
				f.createNewFile();
			}
			// �½�Properties�ļ�
			userList = new Properties();
			// ��ȡuserFile.properties�ļ�����û���Ϣ
			userList.load(new FileInputStream(f));
		}
		return userList;
	}
	// ����ϵͳ�����û�
	private boolean saveUserList() throws IOException
	{
		if (userList == null)
		{
			return false;
		}
		// ��userList��Ϣ���浽Properties�ļ���
		userList.store(new FileOutputStream("userFile.properties"),
			"Users Info List");
		return true;
	}
}
