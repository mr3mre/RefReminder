package Logic;

import java.math.BigDecimal;


public class Food {

    public final static int AMOUNT = 100;
    private int id;
    private String foodName;
    private String main;
    private int expiryDate;
    private double quantity;
    private Number caloriePerPortion;
    private double amount;
    //double calorie1 = food.getCaloriePerPortion().doubleValue();

    public Food( int id, String foodName, String main, Number calorie) {
        this.id = id;
        this.foodName = foodName;
        this.main = main;
        quantity = 0;
        expiryDate = 0;
        caloriePerPortion = calorie;
    }

    public double getAmount() {
        return amount; }

    public void setAmount( double amount) {
        this.amount = amount;
    }
    public double getQuantity() {
        return quantity;
    }
    public void setExpiryDate( int expiryDate) {
        this.expiryDate = expiryDate;
    }

    public double getExpiryDate() {
        return expiryDate;
    }
    public void setQuantity( double quantity) {
        this.quantity = quantity;
    }

    public String getFoodName() {

        return foodName;
    }

    public int getId(){
        return id; }

    public String getMain() {

        return main;
    }

    public Number getCaloriePerPortion() {

        return caloriePerPortion;
    }

    public String toString() {

        return foodName;
    }
