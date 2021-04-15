package siva.bootexception.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import siva.bootexception.bean.Employee;
import siva.bootexception.exception.EmployeeNotFoundException;

@RestController
public class EmployeeRestController {
	
	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer employeeId) {
		if (employeeId != 5)
			throw new EmployeeNotFoundException("Employee Not Exit :: " + employeeId);
		return ResponseEntity.ok(new Employee(employeeId, "siva", "Software Engineer"));
	}
}
