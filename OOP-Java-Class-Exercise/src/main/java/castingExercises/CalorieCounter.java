package castingExercises;

import java.util.ArrayList;

public class CalorieCounter {
    public ArrayList<FoodItem> getAllLowCalorieFoods() {
        // Example method to get low-calorie foods
        ArrayList<FoodItem> lowCalorieFoods = new ArrayList<>();
        lowCalorieFoods.add(new ReadyMeal("Salad", 5.99, 200, "Vegetarian"));
        lowCalorieFoods.add(new Snack("Apple", 0.99, 80, 2, 10));
        return lowCalorieFoods;
    }

    public void removeHighCalorieFoodsFromBasket(Basket basket, int maxCalories) {
        ArrayList<FoodItem> itemsToRemove = new ArrayList<>();
        for (FoodItem item : basket.getAllItems()) {
            if (item.getCalories() > maxCalories) {
                itemsToRemove.add(item);
            }
        }
        for (FoodItem item : itemsToRemove) {
            basket.removeItem(item);
        }
    }
}
