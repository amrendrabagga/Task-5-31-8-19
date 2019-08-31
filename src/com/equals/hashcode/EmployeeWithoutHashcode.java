package com.equals.hashcode;

public class EmployeeWithoutHashcode {

	private int eno;
	private String ename;
	private int salary;
	private String designation;
	
	public EmployeeWithoutHashcode(int eno, String ename, int salary, String designation) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.salary = salary;
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "EmployeeWithoutHashcode [eno=" + eno + ", ename=" + ename + ", salary=" + salary + ", designation=" + designation
				+ "]";
	}
}
