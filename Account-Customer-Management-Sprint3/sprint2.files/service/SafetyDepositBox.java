package service;

public abstract class SafetyDepositBox 
{
	private boolean isAllotted;
	private double id = Math.random()*10;
	
	public boolean isAllotted() {return isAllotted;}
	public void setAllotted(boolean isAllotted) {	this.isAllotted = isAllotted;}
	public double getId() {return id;	}
	public void setId(double id) {this.id = id;}
	
	@Override
	public String toString() {
		return "SafetyDepositBox [isAllotted=" + isAllotted + ", id=" + id + "]";
	}
	
	
		
}
