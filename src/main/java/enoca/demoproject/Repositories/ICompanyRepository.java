package enoca.demoproject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import enoca.demoproject.Entities.Company;

public interface ICompanyRepository extends JpaRepository<Company, Long> {

}
