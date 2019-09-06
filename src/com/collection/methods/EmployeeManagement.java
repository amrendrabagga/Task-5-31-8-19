package com.collection.methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
				EmployeeSort.employeeSort(empList, reader);
				}
			
			}
		reader.close();
		}
		
	}

