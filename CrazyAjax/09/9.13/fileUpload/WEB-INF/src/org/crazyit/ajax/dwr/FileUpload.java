package org.crazyit.ajax.dwr;

import java.io.*;
import java.util.*;

import org.directwebremoting.*;

import org.crazyit.ajax.service.*;
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
public class FileUpload
{
	// ʹ��InputStream������Ҫ�ϴ����ļ�
	// String���͵Ĳ���������ͨ����
	public List<String> uploadFile(InputStream is, String fileName)
		throws Exception
	{
		WebContext wctx = WebContextFactory.get();
		String savePath = wctx.getHttpServletRequest()
				.getServletContext().getRealPath("/upload");
		// ����һ��UUID�ַ�����Ϊ���ļ�����
		// ��ԭ�ļ����ĺ�׺��Ϊ���ļ����ĺ�׺
		String newName = UUID.randomUUID()
			+fileName.substring(fileName.lastIndexOf("."));
		File file = new File(savePath + "/" + newName);
		// ����һ������Ϊ1024������
		byte[] buff = new byte[1024];
		// ʹ��IO�����ļ��ϴ���������
		FileOutputStream os = new FileOutputStream(file);
		int hasRead = 0;
		while((hasRead = is.read(buff)) > 0)
		{
			os.write(buff , 0 , hasRead);
		}
		// �ر�IO��
		is.close();
		os.close();
		// ����ҵ���߼�����ķ������ϴ��ļ���ӵ���ϵͳ����
		List<String> result = new FileService().addFile(newName);
		// ����ϵͳ�а���������ͼƬ�ļ�
		return result;
	}
}