package Logic;

import java.math.BigDecimal;

/**
* Food class for foods' detailed information 
* @author emre, Eren
* @date 28.07.2021
*/
public class Food {

    public final static int AMOUNT = 100;
    private int id;
    private int expiryDate = 0;
    private String foodName;
    private String main;
    private Number caloriePerPortion;
    private double amount;

    /**
     * Constructs a Food instance
     *
     * @param id Food id in database
     * @param foodName Food name
     * @param main Food aisle
     * @param calorie Calorie value
     */
    public Food( int id, String foodName, String main, Number calorie ) {
        this.id = id;
        this.foodName = foodName;
        this.main = main;
        caloriePerPortion = calorie;
    }

    // Getters and setters
    public double getAmount() { return amount; }

    public void setAmount( double amount) { this.amount = amount; }

    public String getFoodName() {
        return foodName;
    }

    public int getId(){ return id; }

    public int getExpiryDate(){ return expiryDate; }

    public void setExpiryDate( int expiryDate ) { this.expiryDate = expiryDate; }

    public String getMain() {
        return main;
    }

    public void setMain( String main ) { this.main = main; }

    public Number getCaloriePerPortion() {
        return caloriePerPortion;
    }

    public String toString() {
        return foodName;
    }
}
