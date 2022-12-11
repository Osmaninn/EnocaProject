package enoca.demoproject.Services.Concretes;

import java.security.cert.CollectionCertStoreParameters;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import enoca.demoproject.Entities.Company;
import enoca.demoproject.Repositories.ICompanyRepository;
import enoca.demoproject.Requests.CreateCompanyRequest;
import enoca.demoproject.Requests.UpdateCompanyRequest;
import enoca.demoproject.Responses.CompanyResponse;
import enoca.demoproject.Services.Abstracts.ICompanyService;

@Service
public class CompanyService implements ICompanyService{
	
	private ICompanyRepository companyRepository;
	
	public CompanyService(ICompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}
	
	@Override
	public void add(CreateCompanyRequest entity) {
		Company company = new Company();
		company.setCompanyName(entity.getCompanyName());
		this.companyRepository.save(company);
		
	}

	@Override
	public void delete(long id) {
		Optional<Company> company = this.companyRepository.findById(id);
		if(!company.isEmpty()) {
			delete(company.get());
		}
		
	}

	@Override
	public void delete(Company entity) {
		this.companyRepository.delete(entity);
		
	}

	@Override
	public void update(Long id, UpdateCompanyRequest entity) {
		Optional<Company> company = this.companyRepository.findById(id);
		
		if(!company.isEmpty()) {
			company.get().setCompanyName(entity.getCompanyName());
			this.companyRepository.save(company.get());
		}
		
	}

	@Override
	public List<CompanyResponse> getAll() {
		List<CompanyResponse> companies = this.companyRepository.findAll()
				.stream().map(c-> new CompanyResponse(c)).collect(Collectors.toList());
		return companies;
	}

	@Override
	public CompanyResponse getById(long id) {
		CompanyResponse company = new CompanyResponse(this.companyRepository.findById(id).get());
		
		return company;
		
		
	}

}
