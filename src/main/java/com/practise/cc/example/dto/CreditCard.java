package com.practise.cc.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CreditCard {
	private String type;
	private String number;
	private String expiration;
	private String owner;
}
