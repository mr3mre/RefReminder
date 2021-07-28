package Logic;

import java.util.ArrayList;
import java.util.HashMap;

public class Storage {

    private ArrayList<Food> foodList;
    private HashMap<String, ArrayList<Food>> categorizedList;

    public Storage() {
        foodList = new ArrayList<>();

        categorizedList = new HashMap<>();
        categorizedList.put( "Meat", new ArrayList<>() );
        categorizedList.put( "Vegetable", new ArrayList<>() );
        categorizedList.put( "Fruit", new ArrayList<>() );
        categorizedList.put( "Legume", new ArrayList<>() );
        categorizedList.put( "Dairy", new ArrayList<>() );
    }

    public ArrayList<Food> getFoodList() {
        return foodList;
    }

    public ArrayList<Food> getMeatList() {
        return categorizedList.get( "Meat" );
    }

    public ArrayList<Food> getVegetableList() {
        return categorizedList.get( "Vegetable" );
    }

    public ArrayList<Food> getFruitList() {
        return categorizedList.get( "Fruit" );
    }

    public ArrayList<Food> getLegumesList() {
        return categorizedList.get( "Legume" );
    }

    public ArrayList<Food> getDairyList() {
        return categorizedList.get( "Dairy" );
    }

    public void addFood( Food food ) {
        foodList.add( food );

        String main = food.getMain();
        categorizedList.get( main ).add( food );
    }

    public void removeFood( Food food ) {
        foodList.remove( food );

        String main = food.getMain();
        categorizedList.get( main ).remove( food );
    }
}
