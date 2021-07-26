public class Food {

    private String foodName;
    private String expiryDate;
    private String main;
    private double quantity;
    private double caloriePerPortion;

    public Food( String foodName, String expiryDate, String main, double quantity, double calorie ) {
        this.foodName = foodName;
        this.expiryDate = expiryDate;
        this.main = main;
        this.quantity = quantity;
        caloriePerPortion = calorie;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getMain() {
        return main;
    }

    public double getCaloriePerPortion() {
        return caloriePerPortion;
    }

    public double getQuantity() {
        return quantity;
    }

    public int getExpiryDate() {
        return expiryDate;
    }
}
