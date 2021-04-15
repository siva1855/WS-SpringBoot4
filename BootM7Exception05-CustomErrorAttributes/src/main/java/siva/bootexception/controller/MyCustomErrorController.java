package siva.bootexception.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyCustomErrorController extends AbstractErrorController {

	public MyCustomErrorController(ErrorAttributes errorAttributes) {
		super(errorAttributes);

	}

	@RequestMapping("/error")
	public @ResponseBody Map<String, Object> handleProblem(HttpServletRequest request) {

		@SuppressWarnings("deprecation")
		Map<String, Object> errors = super.getErrorAttributes(request, true);
		return errors;
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

}
