package castingExercises;

public class ReadyMeal implements BasketItem, FoodItem {
	
	private String cuisineType; 
	private String name;
	private double price;
	private int calories;
	
	
	
	public ReadyMeal(String name, double price, int calories, String cuisineType) {
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.cuisineType = cuisineType;
    }
	
	
	
	
	
	
	public String getCuisineType() {
		return cuisineType;
	}
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
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


