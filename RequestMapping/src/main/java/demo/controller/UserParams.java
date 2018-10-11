package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("params")
public class UserParams {
	
	@RequestMapping(params = "id=4")
	public String getID4() {
		System.out.println("Handler param: id= 4");
		return "index";
	}
	@RequestMapping(params = "id=6")
	public String getID6() {
		System.out.println("Handler param id = 6");
		return "index";
	}
}
