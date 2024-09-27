package org.crazyit.extjs.service;

import org.crazyit.extjs.domain.*;

import java.util.*;
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
public class EmpService
{
	// 使用List集合模拟内存中数据库
	static List<Employee> employeeDb
		= new ArrayList<>();
	// 添加员工数据
	static {
		employeeDb.add(new Employee(1, "如来" , "最高Boss", null));
		employeeDb.add(new Employee(2, "唐僧" , "经理", 1));
		employeeDb.add(new Employee(3, "孙悟空" , "打怪主力", 2));
		employeeDb.add(new Employee(4, "猪八戒" , "美女爱好者", 2));
		employeeDb.add(new Employee(5, "沙僧" , "挑夫", 2));
		employeeDb.add(new Employee(6, "牛魔王" , "大怪", 1));
		employeeDb.add(new Employee(7, "蜘蛛精" , "先锋官", 6));
		employeeDb.add(new Employee(8, "白骨精" , "巡路小妖", 6));
		employeeDb.add(new Employee(9, "红孩儿" , "值班小怪", 6));
		employeeDb.add(new Employee(10, "宋江" , "部门经理", 1));
		employeeDb.add(new Employee(11, "武松" , "程序员", 10));
		employeeDb.add(new Employee(12, "林冲" , "美工", 10));
		employeeDb.add(new Employee(13, "鲁智深" , "测试工程师", 10));
	}
	// 根据经理ID获取该经理下属的员工
	public List<Employee> getEmployees(int mgrId)
	{
		// 如果mgrId小于等于0，直接返回第一个员工
		if(mgrId <= 0)
		{
			return employeeDb.subList(0 , 1);
		}
		List<Employee> result = new ArrayList<>();
		// 遍历系统中的员工
		for (Employee emp : employeeDb)
		{
			// 如果该员工的经理ID存在，且该员工的经理ID等于mgrId
			// 表明该员工是mgrId对应的经理的下属员工
			if(emp.getMgrId() != null &&
				emp.getMgrId() == mgrId)
			{
				result.add(emp);
			}
		}
		return result;
	}

	public void updateNode(int id , int mgrId)
	{
		// 遍历系统中的员工
		for (Employee emp : employeeDb)
		{
			// 根据员工ID找到对应的员工
			if(emp.getId() != null &&
				emp.getId() == id)
			{
				// 更新它的经理ID
				emp.setMgrId(mgrId);
			}
		}
	}
}
