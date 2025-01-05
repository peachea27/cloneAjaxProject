package ksy;

import java.util.ArrayList;

public class Department {
	private int deptNo;
	private String deptName;
	private ArrayList<Employee> empList;
	
	Department(int deptNo, String deptName){
		this.deptNo = deptNo;
		this.deptName =deptName;
		this.empList = new ArrayList<Employee>();
	}
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public ArrayList<Employee> getEmpList() {
		return empList;
	}
	public void setEmpList(ArrayList<Employee> empList) {
		this.empList = empList;
	}
	public int getDeptNo() {
		return deptNo;
	}
	
	public void addEmployee(Employee e) {
		this.empList.add(e);
	}

	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", deptName=" + deptName + ", empList=" + empList + "]";
	}

	public void outputEntireEmployees() {
		for (Employee e : this.empList) {
			System.out.println(e.toString());
		}
	}
	
}
