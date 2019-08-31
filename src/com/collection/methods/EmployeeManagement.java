package com.collection.methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeManagement {

	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int i = 1;

		ArrayList<Employee> empList = new ArrayList<>();

		while (i != 0) {

			System.out.println("OPTIONS");
			System.out.println("=============================================================");
			System.out.println("1. ADD EMPLOYEE");
			System.out.println("2. VIEW EMPLOYEES");
			System.out.println("3. REMOVE EMPLOYEE");
			System.out.println("4. CLEAR DATA");
			System.out.println("5. CHANGE SALARY");
			System.out.println("6. SEARCH EMPLOYEE");
			System.out.println("7. VIEW DEPARTMENT WISE LIST");
			System.out.println("8. VIEW SORTED EMPLOYEES ");
			System.out.println("9. EXIT");

			int input = Integer.parseInt(reader.readLine());
			if (input == 9)
				System.exit(0);

			switch (input) {

			case 1:

				System.out.println("ENTER EMPLOYEE DETAILS - ");
				System.out.println("ENTER ENO ");
				int eno = Integer.parseInt(reader.readLine());

				System.out.println("ENTER ENAME ");
				String ename = reader.readLine();

				System.out.println("ENTER SALARY ");
				long salary = Integer.parseInt(reader.readLine());

				System.out.println("ENTER DESIGNATION ");
				String designation = reader.readLine();

				System.out.println("ENTER DEPARTMENT NAME ");
				String dept = reader.readLine();

				Employee emp = new Employee(eno, ename, salary, designation, dept);
				empList.add(emp);
				System.out.println(emp);
				System.out.println("EMPLOYEE ADDED SUCCESSFULLY");

				break;

			case 2:

				if (empList.size() != 0) {
					for (Employee e : empList) {
						System.out.println(e);
					}
				} else
					System.out.println("NO DATA PRESENT");

				break;

			case 3:

				System.out.println("ENTER ENO ");
				int eno1 = Integer.parseInt(reader.readLine());
				empList.removeIf(x -> x.getEno() == eno1);
				System.out.println("EMPLOYEE REMOVED SUCCESSFULLY");

				break;

			case 4:

				empList.clear();
				System.out.println("DATA REMOVED");

				break;

			case 5:

				System.out.println("ENTER ENO AND NEW SALARY ");
				int eno2 = Integer.parseInt(reader.readLine());
				long newSalary = Long.parseLong(reader.readLine());
				Employee fetchEmp = empList.stream().filter(x -> x.getEno() == eno2).findFirst().orElse(null);
				if (fetchEmp != null) {
					fetchEmp.setSalary(newSalary);
					System.out.println("SALARY CHANGED SUCCESSFULLY");
				} else
					System.out.println("NO SUCH ENO FOUND");

				break;

			case 6:

				System.out.println("ENTER ENO ");
				int eno3 = Integer.parseInt(reader.readLine());
				empList.stream().filter(x -> x.getEno() == eno3).forEach(x -> System.out.println(x));

				break;

			case 7:

				System.out.println("ENTER DEPARTMENT NAME ");
				String dept1 = reader.readLine();
				Map<String, List<Employee>> deptWiseEmployee = empList.stream().filter(x -> x.getDept().equals(dept1))
						.collect(Collectors.groupingBy(x -> x.getDept(), Collectors.toList()));
				deptWiseEmployee.forEach((k, v) -> System.out.println(k + " ->" + v));

				break;
				
			case 8:
				
				System.out.println("ON WHICH FIELD");
				String type = reader.readLine();
				System.out.println("ORDER TYPE(ASC OR DESC");
				String order = reader.readLine();
				int flag = 0;// default is ascending
				if (order.equals("desc"))
					flag = 1;

				switch (type) {

				case "eno":
					Comparator<Employee> comparatorEno = (Employee emp1, Employee emp2) -> emp1.getEno()
							- emp2.getEno();
					if (flag == 1) {
						empList.sort(comparatorEno.reversed());
					} else
						empList.sort(comparatorEno);

					empList.forEach(x -> System.out.println(x));
					break;

				case "ename":
					Comparator<Employee> comparatorEname = (Employee emp1, Employee emp2) -> emp1.getEname()
							.compareTo(emp2.getEname());
					if (flag == 1)
						empList.sort(comparatorEname.reversed());
					else
						empList.sort(comparatorEname);

					empList.forEach(x -> System.out.println(x));
					break;

				case "sal":
					Comparator<Employee> comparatorSalary = (Employee emp1,
							Employee emp2) -> (int) (emp1.getSalary() - emp2.getSalary());
					if (flag == 1)
						empList.sort(comparatorSalary.reversed());
					else
						empList.sort(comparatorSalary);

					empList.forEach(x -> System.out.println(x));
					break;

				case "desg":
					Comparator<Employee> comparatorDesg = (Employee emp1, Employee emp2) -> emp1.getDesignation()
							.compareTo(emp2.getDesignation());
					if (flag == 1)
						empList.sort(comparatorDesg.reversed());
					else
						empList.sort(comparatorDesg);

					empList.forEach(x -> System.out.println(x));
					break;

				case "dept":
					Comparator<Employee> comparatorDept = (Employee emp1, Employee emp2) -> emp1.getDept()
							.compareTo(emp2.getDept());
					if (flag == 1)
						empList.sort(comparatorDept.reversed());
					else
						empList.sort(comparatorDept);

					empList.forEach(x -> System.out.println(x));
					break;

				default:
					Comparator<Employee> comparatorDefault = (Employee emp1, Employee emp2) -> emp1.getEno()
							- emp2.getEno();
					if (flag == 1)
						empList.sort(comparatorDefault.reversed());
					else
						empList.sort(comparatorDefault);

					empList.forEach(x -> System.out.println(x));
				}
			}
		}
		reader.close();
	}
}
