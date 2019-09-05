package types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Number {

	private int value;
	private List<PrimeFactor> primeFactorList;
	private HashMap<Integer, Integer> primeFactorMap;

	public Number() {
		this.value = 0;
		this.primeFactorList = new ArrayList<PrimeFactor>();
		this.primeFactorMap = new HashMap<Integer, Integer>();
	}

	public Number(int value) {
		this.value = value;
		findPrimeFactors();
	}

	public Number(List<PrimeFactor> primeFactorList) {
		this.primeFactorList = primeFactorList;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<PrimeFactor> getPrimeFactorList() {
		return primeFactorList;
	}

	public void setPrimeFactorList(List<PrimeFactor> primeFactorList) {
		this.primeFactorList = primeFactorList;
	}

	public HashMap<Integer, Integer> getPrimeFactorMap() {
		return primeFactorMap;
	}

	public void setPrimeFactorMap(HashMap<Integer, Integer> primeFactorMap) {
		this.primeFactorMap = primeFactorMap;
	}

	public void findPrimeFactors() {
		int value = getValue();
		List<PrimeFactor> primeFactorList = new ArrayList<PrimeFactor>();
		int currFactor = 2;
		while (currFactor <= value) {
			PrimeFactor primeFactor = new PrimeFactor();
			int power = 0;
			while (value > 0) {
				if (value % currFactor == 0) {
					power++;
					value = value / currFactor;
				} else {
					break;
				}
			}
			
			if (power > 0) {
				primeFactor.setValue(currFactor);
				primeFactor.setPower(power);
				primeFactorList.add(primeFactor);
			}
			currFactor++;
		}
		setPrimeFactorList(primeFactorList);
		this.primeFactorMap = new HashMap<Integer, Integer>();
		primeFactorList.forEach((pf) -> this.primeFactorMap.put(pf.getValue(), pf.getPower()));
	}

	private int getFactorPower(int number, int factor) {
		int counter = 0;
		while (number > 0) {
			if (number % factor == 0) {
				counter++;
				number = number / factor;
			} else {
				break;
			}
		}
		return counter;
	}

}
