package com.collection.methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class EmployeeSort {

	public static void employeeSort(ArrayList<Employee> empList, BufferedReader reader) throws IOException {

		System.out.println("SORT BY");
		System.out.println("1. EMPLOYEE ID");
		System.out.println("2. EMPLOYEE NAME");
		System.out.println("3. EMPLOYEE SALARY");
		System.out.println("4. EMPLOYEE DESIGNATION");
		System.out.println("5. EMPLOYEE DEPT");
		int type = Integer.parseInt(reader.readLine());
		System.out.println("ORDER TYPE(ASC OR DESC)");
		String order = reader.readLine().trim();
		int flag = 0;// default is ascending
		if (order.equals("desc"))
			flag = 1;
		else if (order.equals("asc") || order.equals(""))
			flag = 0;

		switch (type) {

		case 1:
			Comparator<Employee> comparatorEno = (Employee emp1, Employee emp2) -> emp1.getEno() - emp2.getEno();
			if (flag == 1) {
				empList.sort(comparatorEno.reversed());
			} else
				empList.sort(comparatorEno);

			empList.forEach(x -> System.out.println(x));
			break;

		case 2:
			Comparator<Employee> comparatorEname = (Employee emp1, Employee emp2) -> emp1.getEname()
					.compareTo(emp2.getEname());
			if (flag == 1)
				empList.sort(comparatorEname.reversed());
			else
				empList.sort(comparatorEname);

			empList.forEach(x -> System.out.println(x));
			break;

		case 3:
			//if salary is same then sort by eno
			Comparator<Employee> comparatorSalary = (Employee emp1, Employee emp2) -> {
				if (emp1.getSalary() == emp2.getSalary())
					return emp1.getEno() - emp2.getEno();
				else
					return (int) (emp1.getSalary() - emp2.getSalary());

			};
			if (flag == 1)
				empList.sort(comparatorSalary.reversed());
			else
				empList.sort(comparatorSalary);

			empList.forEach(x -> System.out.println(x));
			break;

		case 4:
			Comparator<Employee> comparatorDesg = (Employee emp1, Employee emp2) -> emp1.getDesignation()
					.compareTo(emp2.getDesignation());
			if (flag == 1)
				empList.sort(comparatorDesg.reversed());
			else
				empList.sort(comparatorDesg);

			empList.forEach(x -> System.out.println(x));
			break;

		case 5:
			Comparator<Employee> comparatorDept = (Employee emp1, Employee emp2) -> emp1.getDept()
					.compareTo(emp2.getDept());
			if (flag == 1)
				empList.sort(comparatorDept.reversed());
			else
				empList.sort(comparatorDept);

			empList.forEach(x -> System.out.println(x));
			break;

		default:
			Comparator<Employee> comparatorDefault = (Employee emp1, Employee emp2) -> emp1.getEno() - emp2.getEno();
			if (flag == 1)
				empList.sort(comparatorDefault.reversed());
			else
				empList.sort(comparatorDefault);

			empList.forEach(x -> System.out.println(x));
		}
	}
}
