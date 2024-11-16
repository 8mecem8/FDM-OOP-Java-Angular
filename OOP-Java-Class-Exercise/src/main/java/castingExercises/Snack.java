package castingExercises;

public class Snack implements BasketItem, FoodItem{
	
	private int fatContent;
	private int sugarContent;
	private String name;
	private double price;
	private int calories;
	
	
	
	public Snack(String name, double price, int calories, int fatContent, int sugarContent) {
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.fatContent = fatContent;
        this.sugarContent = sugarContent;
    }
	
	
	
	public int getFatContent() {
		return fatContent;
	}
	public void setFatContent(int fatContent) {
		this.fatContent = fatContent;
	}
	public int getSugarContent() {
		return sugarContent;
	}
	public void setSugarContent(int sugarContent) {
		this.sugarContent = sugarContent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	
	

}
