package org.crazyit.ajax.dwr;

import org.directwebremoting.annotations.*;
import org.directwebremoting.create.*;

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
@RemoteProxy(creator=NewCreator.class , name="hello")
public class HelloDwr
{
	// ����һ���򵥵ķ���
	public String hello(Person p)
	{
		return p.getName() + "�����ã�������ѧϰʹ��DWR��ע��...";
	}
}
