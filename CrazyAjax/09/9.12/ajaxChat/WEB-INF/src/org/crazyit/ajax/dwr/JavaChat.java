package org.crazyit.ajax.dwr;

import java.util.*;

import org.directwebremoting.*;
import org.directwebremoting.ui.dwr.Util;

import org.crazyit.ajax.dto.*;

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
public class JavaChat
{
	// ����������Ϣ��List����
	private LinkedList<ChatMsg> messages =
		new LinkedList<ChatMsg>();
	public void addMessage(String text)
	{
		if (text != null && text.trim().length() > 0)
		{
			messages.addFirst(new ChatMsg(text));
			// ��ౣ��10�������¼
			while (messages.size() > 10)
			{
				messages.removeLast();
			}
		}
		WebContext wctx = WebContextFactory.get();
		// �����޸ĵ�ǰScript Session��������������ĵ���״̬
		Browser.withSession(wctx.getScriptSession().getId() , new Runnable()
		{
			public void run()
			{
				// ��text�ı�����Ϊ��
				Util.setValue("text", "");
			}
		});
		// �����������������ҳ���������������ĵ���״̬
		Browser.withCurrentPage(new Runnable()
		{
			public void run()
			{
				// ɾ��chatlog�б���������б���
				Util.removeAllOptions("chatlog");
				// ʹ��messages�����Ｏ��Ԫ�ص�text����Ϊchatlog����б���
				Util.addOptions("chatlog" , messages , "text");
			}
		});
	}
}