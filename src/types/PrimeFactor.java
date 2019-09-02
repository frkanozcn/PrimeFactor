package types;

public class PrimeFactor {

	private int value;
	private int power;

	public PrimeFactor() {
	}

	public PrimeFactor(int value, int power) {
		this.value = value;
		this.power = power;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

}
