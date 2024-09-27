package org.crazyit.extjs.service;

import org.crazyit.extjs.domain.*;

import java.util.*;
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
public class EmpService
{
	// ʹ��List����ģ���ڴ������ݿ�
	static List<Employee> employeeDb
		= new ArrayList<>();
	// ���Ա������
	static {
		employeeDb.add(new Employee(1, "����" , "���Boss", null));
		employeeDb.add(new Employee(2, "��ɮ" , "����", 1));
		employeeDb.add(new Employee(3, "�����" , "�������", 2));
		employeeDb.add(new Employee(4, "��˽�" , "��Ů������", 2));
		employeeDb.add(new Employee(5, "ɳɮ" , "����", 2));
		employeeDb.add(new Employee(6, "ţħ��" , "���", 1));
		employeeDb.add(new Employee(7, "֩�뾫" , "�ȷ��", 6));
		employeeDb.add(new Employee(8, "�׹Ǿ�" , "Ѳ·С��", 6));
		employeeDb.add(new Employee(9, "�캢��" , "ֵ��С��", 6));
		employeeDb.add(new Employee(10, "�ν�" , "���ž���", 1));
		employeeDb.add(new Employee(11, "����" , "����Ա", 10));
		employeeDb.add(new Employee(12, "�ֳ�" , "����", 10));
		employeeDb.add(new Employee(13, "³����" , "���Թ���ʦ", 10));
	}
	// ���ݾ���ID��ȡ�þ���������Ա��
	public List<Employee> getEmployees(int mgrId)
	{
		// ���mgrIdС�ڵ���0��ֱ�ӷ��ص�һ��Ա��
		if(mgrId <= 0)
		{
			return employeeDb.subList(0 , 1);
		}
		List<Employee> result = new ArrayList<>();
		// ����ϵͳ�е�Ա��
		for (Employee emp : employeeDb)
		{
			// �����Ա���ľ���ID���ڣ��Ҹ�Ա���ľ���ID����mgrId
			// ������Ա����mgrId��Ӧ�ľ��������Ա��
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
		// ����ϵͳ�е�Ա��
		for (Employee emp : employeeDb)
		{
			// ����Ա��ID�ҵ���Ӧ��Ա��
			if(emp.getId() != null &&
				emp.getId() == id)
			{
				// �������ľ���ID
				emp.setMgrId(mgrId);
			}
		}
	}
}
