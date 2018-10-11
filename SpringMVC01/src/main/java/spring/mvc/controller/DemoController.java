package spring.mvc.controller;



import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/index")
public class DemoController {
	@RequestMapping(value = "/json",method =  RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public String viewjson(@RequestBody String s) {
		System.out.println(s);
		return "index";
	}
	@RequestMapping(value = "/xml", method = RequestMethod.POST,consumes = MediaType.APPLICATION_XML_VALUE)
	public String viewxml(@RequestBody String s) {
		System.out.println(s);
		return "index";
	}
}
