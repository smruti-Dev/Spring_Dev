package spring.tutor.app.curd.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import spring.tutor.app.curd.example.exception.ResourceNotFoundException;
import spring.tutor.app.curd.example.model.Employees;
import spring.tutor.app.curd.example.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employees> findAll() {
		return employeeRepository.findAll();
	}

	public ResponseEntity<Employees> findById(Long employeeId) throws ResourceNotFoundException {
		Employees employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}

	public Employees save(Employees employee) {
		return employeeRepository.save(employee);
	}

	public ResponseEntity<Employees> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@RequestBody Employees employeeDetails) throws ResourceNotFoundException {
		Employees employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employee.setEmailId(employeeDetails.getEmailId());
		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setAge(employeeDetails.getAge());
		
		final Employees updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);

	}

	public Map<String, Boolean> deleteEmployee(Long employeeId) throws ResourceNotFoundException {
		Employees employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
