package demo.controller;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserControllerConsume {
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public String handlerJson(@RequestBody String s) {
		System.out.println(s);
		return "index";
	}
	
	@RequestMapping(consumes = MediaType.APPLICATION_XML_VALUE, method = RequestMethod.POST)
	public String handlerXml(@RequestBody String s) {
		System.out.println(s);
		return "index";
	}
}
