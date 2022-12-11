package enoca.demoproject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import enoca.demoproject.Entities.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

}
