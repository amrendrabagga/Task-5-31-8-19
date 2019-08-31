package com.equals.hashcode;

import java.util.HashMap;

public class EmployeeProjectWithHashcode {

	public static void main(String args[]) {
		
		Employee emp1 = new Employee(111,"anuj",10000,"HR");
		Employee emp2 = new Employee(111,"anuj",10000,"HR");
		Employee emp3 = new Employee(113,"atul",30000,"MANAGER");
		Employee emp4 = new Employee(114,"abhishek",40000,"SDE2");
		Employee emp5 = new Employee(115,"aagam",50000,"SDE1");
		
		
		Project project1 = new Project(5001,"E_COMMERCE",120,"amazon");
		Project project2 = new Project(5002,"VEDIO HANDLER",100,"youtube");
		Project project3 = new Project(5003,"GAME",50,"sony");
		Project project4 = new Project(5004,"HR MANAGEMENT",80,"worldpay");
		Project project5 = new Project(5005,"FOOD APP",60,"zomato");
		
		HashMap<Employee,Project> hmap = new HashMap<>();
		hmap.put(emp1, project1);
		hmap.put(emp2, project2);
		hmap.put(emp3, project3);
		hmap.put(emp4, project4);
		hmap.put(emp5, project5);

		hmap.forEach((k,v)->System.out.println(k+" -> "+v));
		
	}
}
