package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import types.Number;
import types.PrimeFactor;

public class GCF {

	private List<Number> numberList;
	private List<PrimeFactor> primeFactors;
	private int gcf;
	
	public GCF(List<Number> numberList) {
		this.numberList = numberList;
		this.primeFactors = findPrimeFactors(numberList);
		List<PrimeFactor> primeFactors = this.primeFactors;
		int gcf = 1;
		for (PrimeFactor primeFactor : primeFactors) {
			gcf *= Math.pow(primeFactor.getValue(), primeFactor.getPower());
		}
		this.gcf = gcf;
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

	public int getGcf() {
		return gcf;
	}

	public void setGcf(int gcf) {
		this.gcf = gcf;
	}

	private List<PrimeFactor> findPrimeFactors(List<Number> numberList) {
		// first number
		Number firstNumber = numberList.remove(0);
		
		List<PrimeFactor> primeFactorList = firstNumber.getPrimeFactorList();
		List<PrimeFactor> primeFactorListTemp = new ArrayList<PrimeFactor>();
		primeFactorList.forEach((pf) -> primeFactorListTemp.add(pf));
		
		HashMap<Integer, Integer> primeFactorMap = new HashMap<Integer, Integer>();
		primeFactorMap.putAll(firstNumber.getPrimeFactorMap());
		
		boolean isGCF1 = false;
		
		for (Number number : numberList) {
			HashMap<Integer, Integer> currPrimeFactorMap = number.getPrimeFactorMap();
			int currIndex = 0;
			for (PrimeFactor pf : primeFactorList) {
				int currValue = pf.getValue();
				int currPower = pf.getPower();
				if (!currPrimeFactorMap.containsKey(currValue)) {
					primeFactorListTemp.remove(pf);
					primeFactorMap.remove(currValue);
				} else if (currPrimeFactorMap.get(currValue) < currPower) {
					primeFactorListTemp.get(currIndex).setPower(currPrimeFactorMap.get(currValue));
					primeFactorMap.put(currValue, currPrimeFactorMap.get(currValue));
				}
				if (primeFactorListTemp.isEmpty()) {
					isGCF1 = true;
					break;
				}
				currIndex++;
			}
			if (isGCF1) break;
		}
		return primeFactorListTemp;
	}

}
