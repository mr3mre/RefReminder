package Logic;

import java.math.BigDecimal;

public class Food {

    private int id;
    private String foodName;
    private String main;
    private Number caloriePerPortion;

    public Food( int id, String foodName, String main, Number calorie ) {
        this.id = id;
        this.foodName = foodName;
        this.main = main;
        caloriePerPortion = calorie;
    }

    public String getFoodName() {
        return foodName;
    }


    public String getMain() {
        return main;
    }

    public Number getCaloriePerPortion() {
        return caloriePerPortion;
    }

    public String toString() {
        return foodName;
    }
}
