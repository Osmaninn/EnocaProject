package enoca.demoproject.Services.Abstracts;

import java.util.List;

import enoca.demoproject.Requests.CreateEmployeeRequest;
import enoca.demoproject.Requests.UpdateEmployeeRequest;
import enoca.demoproject.Responses.EmployeeResponse;
import enoca.demoproject.Entities.Employee;

public interface IEmployeeService{
	public void add(CreateEmployeeRequest model);
	
	public void delete(long id);
	
	public void delete(Employee entity);
	
	public void update(Long id, UpdateEmployeeRequest entity);
	
	public List<EmployeeResponse> getAll();
	
	public EmployeeResponse getById(long id);
}
