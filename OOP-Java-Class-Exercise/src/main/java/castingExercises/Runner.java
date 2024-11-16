package castingExercises;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        CalorieCounter calorieCounter = new CalorieCounter();
        ArrayList<FoodItem> lowCalorieFoods = calorieCounter.getAllLowCalorieFoods();

        for (FoodItem foodItem : lowCalorieFoods) {
            if (foodItem instanceof ReadyMeal) {
                ReadyMeal readyMeal = (ReadyMeal) foodItem;
                System.out.println("ReadyMeal: " + readyMeal.getName() + ", Price: " + readyMeal.getPrice() + ", Cuisine Type: " + readyMeal.getCuisineType());
            } else if (foodItem instanceof Snack) {
                Snack snack = (Snack) foodItem;
                System.out.println("Snack: " + snack.getName() + ", Price: " + snack.getPrice() + ", Fat Content: " + snack.getFatContent() + ", Sugar Content: " + snack.getSugarContent());
            }
        }
        
        
        
        
     // Create a Basket and add items
        Basket basket = new Basket();
        basket.addItem(new ReadyMeal("Burger", 7.99, 600, "Fast Food"));
        basket.addItem(new Snack("Chips", 1.99, 500, 10, 15));
        basket.addItem(new ReadyMeal("Salad", 5.99, 200, "Vegetarian"));
        basket.addItem(new Snack("Apple", 0.99, 80, 3, 10));

        // Remove high-calorie foods
        calorieCounter.removeHighCalorieFoodsFromBasket(basket, 500);

        // Verify the items in the basket
        for (FoodItem item : basket.getAllItems()) {
            System.out.println("Item in Basket: " + item.getName() + ", Calories: " + item.getCalories());
        }
        
        
        
        
    }
}
