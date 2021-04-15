package siva.bootexception.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyCustomErrorController implements ErrorController {

	@RequestMapping("/error")
	public @ResponseBody String handleProblem(HttpServletRequest request) {
		int code = (Integer) request.getAttribute("javax.servlet.error.status_code");
		Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
		StringBuilder builder = new StringBuilder();
		builder.append("<html><body>");
		builder.append("<h2>ERROR DETAILS</h2>");
		builder.append("<p>Status code :").append(code).append("</p>");
		builder.append("<p>Exception :").append(exception == null ? "Page Not Found" : exception.getMessage()).append("</p>");
		builder.append("</body></html>");
		return builder.toString();
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

}
