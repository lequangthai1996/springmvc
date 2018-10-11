package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/header")
@Controller
public class UserControllerHeader {
	
	@RequestMapping(headers = "id=4")
	public String header1() {
		System.out.println("Got header id = 4");
		return "index";
	}
	
	@RequestMapping(headers = "id=10")
	public String header2() {
		System.out.println("got header id = 10");
		return "index";
	}
	
	@RequestMapping(headers = "From=thailequang6991@gmail.com")
	public String from() {
		System.out.println("from thai le");
		return "index";
	}
	
	@RequestMapping("/showheader")
	public String acceptcharset(@RequestHeader("Accept-encoding") String encoding, 
			@RequestHeader("Connection") String connection
			){
		System.out.println("Accept-charset: " + encoding );
		System.out.println("keep-alive :" + connection);
		return "index";
	}
}
