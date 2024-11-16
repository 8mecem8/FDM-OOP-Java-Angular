package service;

public class SmallSafetyDepositBox extends SafetyDepositBox
{
	private double capacity;

	public double getCapacity() {return capacity;}


	public void setCapacity(double capacity) {this.capacity = capacity;}

	@Override
	public String toString() {
		return "SmallSafetyDepositBox [capacity=" + capacity + "]";
	}
}
