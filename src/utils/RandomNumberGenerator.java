package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {

	private List<Integer> randomNumbers;
	private static final int RANDOM_NUMBER_LOWER_BOUND = 0;
	private static final int RANDOM_NUMBER_UPPER_BOUND = 100;

	public RandomNumberGenerator(int numberOfRandomNumbers) {
		this.randomNumbers = new ArrayList<Integer>();
		if (numberOfRandomNumbers > 0) {
			for (int i = 0; i < numberOfRandomNumbers; i++) {
				Random r = new Random();
				randomNumbers.add(r.nextInt(RANDOM_NUMBER_UPPER_BOUND) + RANDOM_NUMBER_LOWER_BOUND);
			}
		}
	}

	public List<Integer> getRandomNumbers() {
		return randomNumbers;
	}

	public void setRandomNumbers(List<Integer> randomNumbers) {
		this.randomNumbers = randomNumbers;
	}

}
