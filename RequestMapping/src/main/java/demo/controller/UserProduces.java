package demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produces")
public class UserProduces {
	
	
	@RequestMapping(value = "/json", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String handlerJson(@RequestBody String s) {
        return "{ \"username:\" \"thai\"}";
	}
	

	@RequestMapping(value = "/xml",method = RequestMethod.POST, produces =  MediaType.APPLICATION_XML_VALUE )
	public @ResponseBody String handlerXML(@RequestBody String s) {
		return "<username>thai</username>";
	}
}
