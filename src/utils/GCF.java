package utils;

import java.util.HashMap;
import java.util.List;

import types.Number;
import types.PrimeFactor;

public class GCF {

	private List<Number> numberList;
	private List<PrimeFactor> primeFactors;
	
	public GCF(List<Number> numberList) {
		this.numberList = numberList;
		this.primeFactors = findPrimeFactors(numberList);
	}

	private List<PrimeFactor> findPrimeFactors(List<Number> numberList) {
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (Number n : numberList) {
			
		}
		
		return null;
	}

}
