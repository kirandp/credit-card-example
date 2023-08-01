package com.practise.cc.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practise.cc.example.dto.CreditCardResponse;
import com.practise.cc.example.service.CreditCardService;

@RestController
@RequestMapping("/api")
public class CreditCardController {
	@Autowired
	private CreditCardService creditCardService;
	
	@GetMapping("/getCreditCardData")
	public ResponseEntity<CreditCardResponse> getCreditCardData(@RequestParam String type)
	{
		CreditCardResponse response = creditCardService.getCreditCardInfo(type);
		return ResponseEntity.ok(response);
	}
}
