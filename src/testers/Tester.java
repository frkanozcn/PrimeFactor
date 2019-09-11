package testers;

import java.util.ArrayList;
import java.util.List;

import types.Number;
import types.PrimeFactor;
import utils.GCF;
import utils.LCM;
import utils.RandomNumberGenerator;

public class Tester {

	public Tester() {
	}

	public static void main(String[] args) {
		///*
		int size = 2;
		RandomNumberGenerator r = new RandomNumberGenerator(size);
		List<Integer> randomNumbers = r.getRandomNumbers();
		List<Number> numberList = new ArrayList<Number>();
		for (Integer randomNumber : randomNumbers) {
			Number n = new Number(randomNumber);
			print("Value: " + n.getValue());
			print("Prime factors: " + print(n.getPrimeFactorList()));
			numberList.add(n);
		}
		/** GCF */
		/*
		GCF gcf = new GCF(numberList);
		List<PrimeFactor> primeFactors = gcf.getPrimeFactors();
		print("GCF: ");
		//primeFactors.forEach((pf) -> print(pf.getValue() + "^" + pf.getPower()));
		print(print(primeFactors));
		print(gcf.getGcf());
		*/
		LCM lcm = new LCM(numberList);
		List<PrimeFactor> primeFactors = lcm.getPrimeFactors();
		print("LCM: ");
		//primeFactors.forEach((pf) -> print(pf.getValue() + "^" + pf.getPower()));
		print(print(primeFactors));
		print(lcm.getLcm());
		//*/
	}
	
	private static void print(Object s) {
		System.out.println(s.toString());
	}
	
	private static String print(List<PrimeFactor> primeFactors) {
		String output = "1";
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
