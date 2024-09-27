package org.crazyit.message.authority;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.*;

import org.crazyit.message.exception.MessageException;

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
public class AuthorityInterceptor
{
	// ����Ȩ�޼��ķ���
	public void authority(JoinPoint jp)
		throws java.lang.Throwable
	{
		HttpSession sess = null;
		// ��ȡ�����ط�����ȫ������
		Object[] args = jp.getArgs();
		// ���������ط�����ȫ������
		for (int i = 0 ; i < args.length ; i++ )
		{
			// �ҵ�HttpSession���͵Ĳ���
			if (args[i] instanceof HttpSession) sess =
				(HttpSession)args[i];
			// ȡ��HttpSession���user����
			Integer userId = (Integer)sess.getAttribute("userId");
			// ���HttpSession���userId���Բ����ڣ���С�ڵ���0
			if ( userId == null || userId <= 0)
			{
				// �����δ��¼���׳��쳣
				throw new MessageException("����û�е�¼��"
					+ "���ȵ�¼ϵͳ��ִ�иò���");
			}
		}
	}
}