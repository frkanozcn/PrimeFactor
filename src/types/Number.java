package types;

import java.util.ArrayList;
import java.util.List;

public class Number {

	private int value;
	private List<PrimeFactor> primeFactorList;

	public Number() {
		this.value = 0;
		this.primeFactorList = new ArrayList<PrimeFactor>();
	}

	public Number(int value) {
		this.value = value;
		this.primeFactorList = new ArrayList<PrimeFactor>();
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
