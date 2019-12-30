package br.com.teste.eurekaclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/hello-worlds/{name}")
	public String getHelloWorld(@PathVariable String name) {
		return "Hello World " + name;
	}
	

	@GetMapping("/hello-worlds")
	public String getHelloWorld() {
		return "Hello World ";
	}

}
