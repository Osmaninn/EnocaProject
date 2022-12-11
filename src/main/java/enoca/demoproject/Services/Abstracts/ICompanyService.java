package enoca.demoproject.Services.Abstracts;

import java.util.List;

import enoca.demoproject.Entities.Company;
import enoca.demoproject.Requests.CreateCompanyRequest;
import enoca.demoproject.Requests.UpdateCompanyRequest;
import enoca.demoproject.Responses.CompanyResponse;

public interface ICompanyService {
	public void add(CreateCompanyRequest entity);
	
	public void delete(long id);
	
	public void delete(Company entity);
	
	public void update(Long id, UpdateCompanyRequest entity);
	
	public List<CompanyResponse> getAll();
	
	public CompanyResponse getById(long id);
}
