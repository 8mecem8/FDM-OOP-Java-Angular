package castingExercises;

import java.util.ArrayList;

public class Basket {
    private ArrayList<FoodItem> items = new ArrayList<>();

    public void addItem(FoodItem item) {
        items.add(item);
    }

    public void removeItem(FoodItem item) {
        items.remove(item);
    }

    public ArrayList<FoodItem> getAllItems() {
        return new ArrayList<>(items);
    }
}
