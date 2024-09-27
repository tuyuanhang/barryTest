package org.crazyit.ajax.dwr;

import java.util.*;

import org.crazyit.ajax.domain.*;

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
public class HelloDwr
{
	// ��һ���򵥵�hello����
	public String hello(String name)
	{
		return name + "�����ã����Ѿ���ʼ��DWR��ѧϰ֮�ã�ף��ѧ�ÿ���...";
	}
	// ʹ��һ��JavaBean��Ϊ�����ķ���
	public String sendObj(Person p )
	{
		return p.getName() + "�����ã����Ѿ�ѧ����ʹ��JavaBean����...";
	}
	// ����JavaBeanʵ���ķ���
	public Person getBean (String name)
	{
		return new Person(name);
	}
	// ����һ����ͨ��Java����Cat����Ϊ�������ṩsetter��getter����
	public Cat getObject(String name)
	{
		return new Cat("��������" + name);
	}
	// ����һ�����϶���
	public List<Person> getPersonList()
	{
		List<Person> result = new ArrayList<Person>();
		result.add(new Person("����aaaa"));
		result.add(new Person("����bbbb"));
		result.add(new Person("����cccc"));
		return result;
	}
	// ����һ���������
	public Person[] getPersonArray()
	{
		Person[] result = new Person[3];
		result[0] = new Person("����aaaa");
		result[1] = new Person("����bbbb");
		result[2] = new Person("����cccc");
		return result;
	}
	// ����һ��Map����
	public Map<String, Person> getPersonMap()
	{
		// ����һ��Map����
		Map<String, Person> result = new HashMap<String, Person>();
		// ���Map���������
		result.put("first" , new Person("Map aaaa"));
		result.put("second" , new Person("Map bbb"));
		result.put("third" , new Person("Map cccc"));
		// ����Map
		return result;
	}
	// Զ�̷����Ĳ����Ǽ���
	public String sendList(List<Person> pl)
	{
		String result = "";
		for (Person p : pl)
		{
			result += p.getName() + "<br />";
		}
		return result;
	}
	// Զ�̷����Ĳ����ǲ������͵ļ���
	public String sendListNoGeneric(List pl)
	{
		String result = "";
		for (Object p : pl)
		{
			result += ((Person)p).getName() + "<br />";
		}
		return result;
	}

	// Զ�̷����Ĳ����Ǽ���
	public String sendMap(Map<String , Person> pmap)
	{
		String result = "";
		for (String key : pmap.keySet())
		{
			result += "��" + key + " ��ֵΪ��" +
				pmap.get(key).getName() + "<br />";
		}
		return result;
	}
}
