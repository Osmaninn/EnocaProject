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

import enoca.demoproject.Entities.Company;
import enoca.demoproject.Requests.CreateCompanyRequest;
import enoca.demoproject.Requests.UpdateCompanyRequest;
import enoca.demoproject.Responses.CompanyResponse;
import enoca.demoproject.Services.Abstracts.ICompanyService;

@RestController
@RequestMapping("/company")
public class CompanyControllers {

	private ICompanyService companyService;
	
	@Autowired
	public CompanyControllers(ICompanyService companyService) {
		this.companyService = companyService;
	}
	
	@PostMapping
	public HttpStatus add(@RequestBody CreateCompanyRequest company) {
		this.companyService.add(company);
		return HttpStatus.OK;
	}
	
	@GetMapping
	public List<CompanyResponse> getAll(){
		return this.companyService.getAll();
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable Long id,  @RequestBody UpdateCompanyRequest company) {
		this.companyService.update(id, company);
	}
	
	@DeleteMapping
	public void delete(@RequestBody Long id) {
		this.companyService.delete(id);
	}
	
	@GetMapping("/{id}")
	public CompanyResponse getById(@PathVariable Long id) {
		return this.companyService.getById(id);
	}
	
}
