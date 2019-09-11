package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import types.Number;
import types.PrimeFactor;

public class LCM {

	private List<Number> numberList;
	private List<PrimeFactor> primeFactors;
	private int lcm;

	public LCM(List<Number> numberList) {
		this.numberList = numberList;
		this.primeFactors = findPrimeFactors(numberList);
		List<PrimeFactor> primeFactors = this.primeFactors;
		int lcm = 1;
		for (PrimeFactor primeFactor : primeFactors) {
			lcm *= Math.pow(primeFactor.getValue(), primeFactor.getPower());
		}
		this.lcm = lcm;
	}

	public List<Number> getNumberList() {
		return numberList;
	}

	public void setNumberList(List<Number> numberList) {
		this.numberList = numberList;
	}

	public List<PrimeFactor> getPrimeFactors() {
		return primeFactors;
	}

	public void setPrimeFactors(List<PrimeFactor> primeFactors) {
		this.primeFactors = primeFactors;
	}

	public int getLcm() {
		return lcm;
	}

	public void setLcm(int lcm) {
		this.lcm = lcm;
	}

	private List<PrimeFactor> findPrimeFactors(List<Number> numberList) {
		List<PrimeFactor> primeFactors = new ArrayList<PrimeFactor>();
		HashMap<Integer, Integer> primeFactorMap = new HashMap<Integer, Integer>();
		for (Number number : numberList) {
			List<PrimeFactor> currPrimeFactors = number.getPrimeFactorList();
			for (PrimeFactor currPrimeFactor : currPrimeFactors) {
				if (!primeFactorMap.containsKey(currPrimeFactor.getValue())
						|| primeFactorMap.get(currPrimeFactor.getValue()) < currPrimeFactor.getPower()) {
					primeFactorMap.put(currPrimeFactor.getValue(), currPrimeFactor.getPower());
				}
			}
		}
		Set<Integer> keySet = primeFactorMap.keySet();
		Iterator<Integer> iterator = keySet.iterator();
		while (keySet != null && iterator.hasNext()) {
			Integer nextKey = iterator.next();
			Integer nextValue = primeFactorMap.get(nextKey);
			PrimeFactor primeFactor = new PrimeFactor(nextKey, nextValue);
			primeFactors.add(primeFactor);
		}
		return primeFactors;
	}

}
