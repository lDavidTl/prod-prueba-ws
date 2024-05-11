package com.producto.prd.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class MainController {
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> main() {
		System.out.println("OLA");
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
