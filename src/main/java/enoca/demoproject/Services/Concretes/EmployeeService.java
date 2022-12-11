package enoca.demoproject.Services.Concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import enoca.demoproject.Entities.Company;
import enoca.demoproject.Entities.Employee;
import enoca.demoproject.Repositories.ICompanyRepository;
import enoca.demoproject.Repositories.IEmployeeRepository;
import enoca.demoproject.Requests.CreateEmployeeRequest;
import enoca.demoproject.Requests.UpdateEmployeeRequest;
import enoca.demoproject.Responses.CompanyResponse;
import enoca.demoproject.Responses.EmployeeResponse;
import enoca.demoproject.Services.Abstracts.ICompanyService;
import enoca.demoproject.Services.Abstracts.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService{
	
private IEmployeeRepository employeeRepository;
private ICompanyRepository companyRepository;

	public EmployeeService(IEmployeeRepository employeeRepository, ICompanyRepository companyRepository) {
		this.employeeRepository = employeeRepository;
		this.companyRepository= companyRepository;
	}
	
	@Override
	public void add(CreateEmployeeRequest model) {
		
		Optional<Company> company = this.companyRepository.findById(model.getCompanyId());
		if(!company.isEmpty()) {
			Employee employee = new Employee();
			employee.setEmployeeName(model.getEmployeeName());
			employee.setEmployeeSurname(model.getEmployeeSurname());
			employee.setCompany(company.get());
			this.employeeRepository.save(employee);
		}
		
		
	}

	@Override
	public void delete(long id) {
		Optional<Employee> employee= this.employeeRepository.findById(id);
		if(!employee.isEmpty()) {
			delete(employee.get());
		}
		
	}

	@Override
	public void delete(Employee entity) {
		this.employeeRepository.delete(entity);
		
	}

	@Override
	public void update(Long id, UpdateEmployeeRequest entity) {
		Optional<Employee> employee= this.employeeRepository.findById(id);
		Optional<Company> company = companyRepository.findById(entity.getCompanyId());
		if(!employee.isEmpty() && !employee.isEmpty()) {
			employee.get().setEmployeeName(entity.getEmployeeName());
			employee.get().setEmployeeSurname(entity.getEmployeeSurname());
			employee.get().setCompany(company.get());
			this.employeeRepository.save(employee.get());
		}
		
	}

	@Override
	public List<EmployeeResponse> getAll() {
		List<EmployeeResponse> employees= this.employeeRepository.findAll()
				.stream().map(e -> new EmployeeResponse(e)).collect(Collectors.toList());
		return employees;
	}

	@Override
	public EmployeeResponse getById(long id) {
		EmployeeResponse employee= new EmployeeResponse(this.employeeRepository.findById(id).get());
				return employee;
			
	}
	
}
