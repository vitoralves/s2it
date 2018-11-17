package com.s2it.api.service.impl;

import org.springframework.stereotype.Service;

import com.s2it.api.service.ApiService;

@Service
public class ApiServiceImpl implements ApiService{

	@Override
	public Integer getNewNumber(int a, int b) {
		String newNumber = "";
		
		int [] arrA = Integer.toString(a).chars().map(c -> c-'0').toArray();
		int [] arrB = Integer.toString(b).chars().map(c -> c-'0').toArray();
		
		if ((arrA.length + arrB.length) > 10) {
			return -1;
		}		
			
		for (int x = 0; x < arrA.length; x ++) {
			newNumber += arrA[x];
			
			if (arrB.length >= (x+1)) {
				newNumber += arrB[x];
			}
		}
		
		if (arrB.length > arrA.length) {
			newNumber += Integer.toString(b).substring(arrA.length, arrB.length);
		}
		
		return Integer.parseInt(newNumber) > 1000000 ? -1 : Integer.parseInt(newNumber);
	}

}
