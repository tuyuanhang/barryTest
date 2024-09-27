package org.crazyit.ajax.dwr;

import java.io.*;
import java.util.*;

import org.directwebremoting.*;

import org.crazyit.ajax.service.*;
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
public class FileUpload
{
	// 使用InputStream代表需要上传的文件
	// String类型的参数代表普通参数
	public List<String> uploadFile(InputStream is, String fileName)
		throws Exception
	{
		WebContext wctx = WebContextFactory.get();
		String savePath = wctx.getHttpServletRequest()
				.getServletContext().getRealPath("/upload");
		// 生成一个UUID字符串作为主文件名，
		// 以原文件名的后缀作为新文件名的后缀
		String newName = UUID.randomUUID()
			+fileName.substring(fileName.lastIndexOf("."));
		File file = new File(savePath + "/" + newName);
		// 定义一个长度为1024的数组
		byte[] buff = new byte[1024];
		// 使用IO流将文件上传到服务器
		FileOutputStream os = new FileOutputStream(file);
		int hasRead = 0;
		while((hasRead = is.read(buff)) > 0)
		{
			os.write(buff , 0 , hasRead);
		}
		// 关闭IO流
		is.close();
		os.close();
		// 调用业务逻辑组件的方法将上传文件添加到“系统”中
		List<String> result = new FileService().addFile(newName);
		// 返回系统中包含的所有图片文件
		return result;
	}
}