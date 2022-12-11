package enoca.demoproject.Responses;

import enoca.demoproject.Entities.Employee;

public class EmployeeResponse {
	
	private String employeeName;
	
	private String employeeSurname;
	
	private String companyName;
		
	public EmployeeResponse(Employee employee) {
		this.setEmployeeName(employee.getEmployeeName());
		this.setEmployeeSurname(employee.getEmployeeSurname());
		this.setCompanyName(employee.getCompany().getCompanyName());
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeSurname() {
		return employeeSurname;
	}

	public void setEmployeeSurname(String employeeSurname) {
		this.employeeSurname = employeeSurname;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
