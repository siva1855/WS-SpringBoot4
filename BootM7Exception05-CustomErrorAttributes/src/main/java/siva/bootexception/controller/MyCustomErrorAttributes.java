package siva.bootexception.controller;

import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

@Component
public class MyCustomErrorAttributes extends DefaultErrorAttributes {

	public Map<String, Object> getErrorAttributes(WebRequest request, ErrorAttributeOptions options) {
		Map<String, Object> errors = super.getErrorAttributes(request, options);
		errors.put("Java", "Business Logic");
		return errors;
	}
}
