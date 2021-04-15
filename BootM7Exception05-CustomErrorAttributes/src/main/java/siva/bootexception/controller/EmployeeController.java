package siva.bootexception.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import siva.bootexception.exception.NotImplementedException;
import siva.bootexception.exception.UserNotFoundException;

@Controller
public class EmployeeController {
	
	@GetMapping("/showA")
	public String showA() {
		if (new Random().nextInt(10) <= 10)
			throw new RuntimeException("SAMPLE-A");

		return "Welcome";

	}

	@GetMapping("/showB")
	public String showB() {

		if (new Random().nextInt(10) <= 10)
			throw new NotImplementedException("SAMPLE-B");

		return "Welcome";

	}

	@GetMapping("/showC")
	public String showC() {
		if (new Random().nextInt(10) <= 10)
			throw new UserNotFoundException("SAMPLE-C");

		return "Welcome";

	}

	@GetMapping("/show")
	public String show() {
		return "Welcome";
	}

}
