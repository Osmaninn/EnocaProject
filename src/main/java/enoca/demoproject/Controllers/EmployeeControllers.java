package enoca.demoproject.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import enoca.demoproject.Requests.CreateEmployeeRequest;
import enoca.demoproject.Requests.UpdateEmployeeRequest;
import enoca.demoproject.Responses.EmployeeResponse;
import enoca.demoproject.Services.Abstracts.IEmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeControllers {

private IEmployeeService employeeService;
	
	@Autowired
	public EmployeeControllers(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping
	public HttpStatus add(@RequestBody CreateEmployeeRequest employee) {
		this.employeeService.add(employee);
		return HttpStatus.OK;
	}
	
	@GetMapping
	public List<EmployeeResponse> getAll(){
		return this.employeeService.getAll();
	}
	
	@PutMapping("{id}")
	public void update(@PathVariable Long id, @RequestBody UpdateEmployeeRequest employee) {
		this.employeeService.update(id, employee);
	}
	
	@DeleteMapping
	public void delete(@RequestBody long id) {
		this.employeeService.delete(id);
	}
	
	@GetMapping("/{id}")
	public EmployeeResponse getById(@PathVariable Long id) {
		return this.employeeService.getById(id);
	}
}
