package demo.controller;

import java.lang.reflect.Method;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("requestmethod")
public class UserRequestMethod {
	
	@RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
	public String getMethod(@PathVariable("id") String id) {
		System.out.println("Get - ID: "+ id);
		return "index";
	}
	
	@RequestMapping(value = {"/{id}"}, method = RequestMethod.DELETE)
	public String deleteMethod(@PathVariable("id") String id) {
		System.out.println("Delete - ID: "+ id);
		return "index";
	}
}
