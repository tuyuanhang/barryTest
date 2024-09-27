package org.crazyit.ajax.dwr;

import java.util.*;

import org.crazyit.ajax.domain.*;

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
public class HelloDwr
{
	// 第一个简单的hello方法
	public String hello(String name)
	{
		return name + "，您好！您已经开始了DWR的学习之旅，祝您学得开心...";
	}
	// 使用一个JavaBean作为参数的方法
	public String sendObj(Person p )
	{
		return p.getName() + "，您好！您已经学会了使用JavaBean参数...";
	}
	// 返回JavaBean实例的方法
	public Person getBean (String name)
	{
		return new Person(name);
	}
	// 返回一个普通的Java对象，Cat对象为其属性提供setter和getter方法
	public Cat getObject(String name)
	{
		return new Cat("服务器端" + name);
	}
	// 返回一个集合对象
	public List<Person> getPersonList()
	{
		List<Person> result = new ArrayList<Person>();
		result.add(new Person("集合aaaa"));
		result.add(new Person("集合bbbb"));
		result.add(new Person("集合cccc"));
		return result;
	}
	// 返回一个数组对象
	public Person[] getPersonArray()
	{
		Person[] result = new Person[3];
		result[0] = new Person("数组aaaa");
		result[1] = new Person("数组bbbb");
		result[2] = new Person("数组cccc");
		return result;
	}
	// 返回一个Map对象
	public Map<String, Person> getPersonMap()
	{
		// 创建一个Map对象
		Map<String, Person> result = new HashMap<String, Person>();
		// 填充Map对象的内容
		result.put("first" , new Person("Map aaaa"));
		result.put("second" , new Person("Map bbb"));
		result.put("third" , new Person("Map cccc"));
		// 返回Map
		return result;
	}
	// 远程方法的参数是集合
	public String sendList(List<Person> pl)
	{
		String result = "";
		for (Person p : pl)
		{
			result += p.getName() + "<br />";
		}
		return result;
	}
	// 远程方法的参数是不带泛型的集合
	public String sendListNoGeneric(List pl)
	{
		String result = "";
		for (Object p : pl)
		{
			result += ((Person)p).getName() + "<br />";
		}
		return result;
	}

	// 远程方法的参数是集合
	public String sendMap(Map<String , Person> pmap)
	{
		String result = "";
		for (String key : pmap.keySet())
		{
			result += "键" + key + " 其值为：" +
				pmap.get(key).getName() + "<br />";
		}
		return result;
	}
}
