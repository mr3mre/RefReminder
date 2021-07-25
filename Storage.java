import java.util.ArrayList;

public class Storage {

    private final int totalCapacity = CAPACITY;

    private ArrayList<Food> foodList;
    private ArrayList<Food> meatList;
    private ArrayList<Food> vegetableList;
    private ArrayList<Food> fruitList;
    private ArrayList<Food> legumesList;
    private ArrayList<Food> dairyList;
    private Food food;

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public ArrayList<Food> getFoodList() {
        return foodList;
    }

    public ArrayList<Food> getMeatList() {
        return meatList;
    }

    public ArrayList<Food> getVegetableList() {
        return vegetableList;
    }

    public ArrayList<Food> getFruitList() {
        return fruitList;
    }

    public ArrayList<Food> getLegumesList() {
        return legumesList;
    }

    public ArrayList<Food> getDairyList() {
        return dairyList;
    }

    public void addFood( Food food ) {
        foodList.add( food );
    }

    public void removeFood( Food food ) {
        foodList.remove( food );
    }
}
