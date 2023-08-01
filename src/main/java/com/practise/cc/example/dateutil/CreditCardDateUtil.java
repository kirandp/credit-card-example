package com.practise.cc.example.dateutil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CreditCardDateUtil {
	@Value("${credit.card.date.format}")
	public String creditCardDateFormat;

//	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(creditCardDateFormat);
	
	SimpleDateFormat sdf = new SimpleDateFormat("M/yy");

	public Date getDateObject(String inputDateStr) {
		Date parsedDate = null;
		try {
			parsedDate = sdf.parse(inputDateStr);
		} catch (ParseException e) {
			System.out.println("Date Error Occured===============>");
			e.printStackTrace();
		}
		return parsedDate;
	}
}