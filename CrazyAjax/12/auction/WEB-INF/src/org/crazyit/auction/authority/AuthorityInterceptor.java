package org.crazyit.auction.authority;

import javax.servlet.http.HttpSession;
import org.aspectj.lang.*;

import org.crazyit.auction.exception.AuctionException;

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
public class AuthorityInterceptor
{
	// 进行权限检查的方法
	public void authority(JoinPoint jp)
		throws Throwable
	{
		HttpSession sess = null;
		// 获取被拦截方法的全部参数
		Object[] args = jp.getArgs();
		// 遍历被拦截方法的全部参数
		for (int i = 0 ; i < args.length ; i++ )
		{
			// 找到HttpSession类型的参数
			if (args[i] instanceof HttpSession) sess =
				(HttpSession)args[i];
		}
		// 取出HttpSession里的userId属性
		Integer userId = (Integer)sess.getAttribute("userId");
		// 如果HttpSession里的userId属性为null，或小于等于0
		if(userId == null || userId <= 0)
		{
			// 如果还未登录，抛出异常
			throw new AuctionException("您还没有登录，请先登录系统再执行该操作");
		}
	}
}