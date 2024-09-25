package spring.tutor.app.curd.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.tutor.app.curd.example.exception.ResourceNotFoundException;
import spring.tutor.app.curd.example.model.Employees;
import spring.tutor.app.curd.example.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employees> getAllEmployees() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employees> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		return employeeService.findById(employeeId);
	}

	@PostMapping("/createemp")
	public Employees createEmployee(@RequestBody Employees employees) {
		return employeeService.save(employees);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employees> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@RequestBody Employees employeeDetails) throws ResourceNotFoundException {
		return employeeService.updateEmployee(employeeId, employeeDetails);

	}

	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {

		return employeeService.deleteEmployee(employeeId);

	}
}
