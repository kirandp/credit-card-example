package com.practise.cc.example.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.practise.cc.example.dateutil.CreditCardDateUtil;
import com.practise.cc.example.dto.CreditCard;
import com.practise.cc.example.dto.CreditCardResponse;
import com.practise.cc.example.service.CreditCardService;


@Service
public class CreditCardServiceImpl implements CreditCardService{
	

	
	@Value("${credit.card.url}")
	public String creditCardURL;
	
	@Autowired
	public RestTemplate restTemplate;
	
	
	@Value("${credit.card.expiration.date}")
	public String creditCardExpirationDate;

	@Override
	public CreditCardResponse getCreditCardInfo(String type) {
		CreditCardDateUtil dateUtil = new CreditCardDateUtil();
		CreditCardResponse creditCardResponse = restTemplate.getForObject(creditCardURL, CreditCardResponse.class);		
		List<CreditCard> cardList = creditCardResponse.getData();
		List<CreditCard> expiredCreditCardList = cardList.stream().filter(cc-> cc.getType().equals(type)).filter((cc)->{
			if(dateUtil.getDateObject(cc.getExpiration()).compareTo(dateUtil.getDateObject(creditCardExpirationDate))>0)
			{
				return true;
			}
			return false;
		}).collect(Collectors.toList());
		creditCardResponse.setData(expiredCreditCardList);
		return creditCardResponse;         
	}
	
	
}
