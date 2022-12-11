package enoca.demoproject.Responses;

import enoca.demoproject.Entities.Company;

public class CompanyResponse {
	private String CompanyName;
	
	public CompanyResponse(Company company) {
		this.setCompanyName(company.getCompanyName());
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
}
