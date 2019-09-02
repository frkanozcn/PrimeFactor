package testers;

import java.util.ArrayList;
import java.util.List;

import types.Number;
import types.PrimeFactor;
import utils.RandomNumberGenerator;

public class Tester {

	public Tester() {
	}

	public static void main(String[] args) {
		int size = 1;
		RandomNumberGenerator r = new RandomNumberGenerator(size);
		List<Integer> randomNumbers = r.getRandomNumbers();
		List<Number> numberList = new ArrayList<Number>();
		for (int i = 0; i < size; i++) {
			Number n = new Number();
			n.setValue(randomNumbers.get(i));
			n.findPrimeFactors();
			print("Value: " + n.getValue());
			print("Prime factors: " + print(n.getPrimeFactorList()));
		}
		
	}
	
	private static void print(Object s) {
		System.out.println(s.toString());
	}
	
	private static String print(List<PrimeFactor> primeFactors) {
		String output = "";
		if (primeFactors == null || primeFactors.isEmpty()) {
			return output;
		}
		output = primeFactors.get(0).getValue() + "^" + primeFactors.get(0).getPower();
		if (primeFactors.size() == 1) {
			return output;
		}
		for (int i = 1; i < primeFactors.size(); i++) {
			output = output + " * ";
			output = output + primeFactors.get(i).getValue() + "^" + primeFactors.get(i).getPower();
		}
		return output;
	}

}
