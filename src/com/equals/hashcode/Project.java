package com.equals.hashcode;

public class Project {

	private int pcode;
	private String ptitle;
	private int pduration;
	private String ename;
	
	@Override
	public String toString() {
		return "Project [pcode=" + pcode + ", ptitle=" + ptitle + ", pduration=" + pduration + ", ename=" + ename + "]";
	}
	
	public Project(int pcode, String ptitle, int pduration, String ename) {
		super();
		this.pcode = pcode;
		this.ptitle = ptitle;
		this.pduration = pduration;
		this.ename = ename;
	}
}
