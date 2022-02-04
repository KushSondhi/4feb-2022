package com.file.proj.app.employees;

public class Employee {
	
	private int empId;
	private String empName;
	private double empSalary;
	private String empDoj;
	
	public Employee(int empId, String empName,String empDoj,double empSalary) {
		
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empDoj = empDoj;
	}
	public Employee() {
		
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public String getEmpDoj() {
		return empDoj;
	}
	public void setEmpDoj(String empDoj) {
		this.empDoj = empDoj;
	}
	
	public String toString() {
		return (empId+" "+empName+" "+empSalary+" "+empDoj);
	}
	
	public static Employee createEmployee(String str) {
		
		String[] val = str.split(",");
		int empId = Integer.parseInt(val[0]);
		String empName = val[1];
		String empDoj = val[2];
		double empSalary = Double.parseDouble(val[3]);
		
		Employee emp = new Employee(empId,empName,empDoj,empSalary);
		return emp;
		
	}

}
