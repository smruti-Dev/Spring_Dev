package spring.tutor.app.curd.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.tutor.app.curd.example.model.Employees;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Long>{
	 

}
