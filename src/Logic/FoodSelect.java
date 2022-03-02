package Logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Goksu
 * @author emre
 */
public class FoodSelect {

    ArrayList<Food> 	foodList;

    ArrayList<Food>  	produceList;
    ArrayList<Food> 	breakfastList;
    ArrayList<Food> 	mainDishesList;
    ArrayList<Food>  	freezerList;
    ArrayList<Food> 	drinkList;
    ArrayList<Food> 	addonsList;

    Food FoodSelected;
    String username;

    public FoodSelect(){
        // Get username from file
        try
        {

            username = textReader();
        }
        catch(FileNotFoundException e)
        {
            //System.out.println("1");
        }
        FoodSelected = null;
        foodList = getFoodFromSQL("food");

        // Get food from database
        produceList = getFoodFromSQL("Produce");
        breakfastList = getFoodFromSQL("Breakfast");
        mainDishesList = getFoodFromSQL("Main Dishes");
        freezerList = getFoodFromSQL("Freezer");
        drinkList = getFoodFromSQL("Drink");
        addonsList = getFoodFromSQL("Food Addons");

        // Add food to ArrayLists
        foodList.addAll(produceList);
        foodList.addAll(breakfastList);
        foodList.addAll(mainDishesList);
        foodList.addAll(freezerList);
        foodList.addAll(addonsList);
        foodList.addAll(drinkList);
    }

    /**
     * Gets foods from the database
     *
     * @param name Food name
     * @return ArrayList of food
     */
    public ArrayList<Food> getFoodFromSQL(String name) {

        try {

                Food food;
                ArrayList<Food> list = new ArrayList<Food>();
                java.sql.Connection connect = DriverManager.getConnection(
                        "" + username, "root", "root");

                PreparedStatement statement = ((java.sql.Connection) connect).prepareStatement("SELECT * FROM food WHERE main = '" + name + "'");

                //Statement statement = ((java.sql.Connection) connect).createStatement();
                //String sql1 = "SELECT * FROM food WHERE main = '" + name + "'";
                ResultSet resultset = statement.executeQuery();

                while (resultset.next()) {
                    food = new Food(resultset.getInt("id"), resultset.getString("foodname"), resultset.getString("main"), (Number)resultset.getDouble("calorie"));
                    food.setAmount( resultset.getDouble("quantity"));
                    food.setExpiryDate( resultset.getInt("expirydate" ));
                    list.add(food);

                }
                connect.close();
                return list;


        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }

    }

    /**
     * Get username from file
     *
     * @return Username
     * @throws FileNotFoundException
     */
    public static String textReader() throws FileNotFoundException
    {
        File file = new File("filename.txt");
        Scanner scan = new Scanner( file );
        String name = scan.next();
        scan.close();
        return name;
    }

    // Getters and setters
    public ArrayList<Food> getFood (){
        return foodList;
    }

    public ArrayList<Food> getAddonsList (){
        return addonsList;
    }

    public ArrayList<Food> getMainDishesList (){
        return mainDishesList;
    }
    public ArrayList<Food> getBreakfastList (){

        return breakfastList;
    }
    public ArrayList<Food> getProduceList (){

        return produceList;
    }
    public ArrayList<Food> getFreezerList (){

        return freezerList;
    }
    public ArrayList<Food> getDrinkList (){

        return drinkList;
    }

    // Get foods from their aisles
    public int getNumOfArrayList( ArrayList<Food> food1){
        return food1.size();
    }
    public int getNumOfFood( ){
        return foodList.size();
    }
    public int getNumOfMainDishes( ){
        return mainDishesList.size();
    }
    public int getNumOfBreakfast(){
        return breakfastList.size();
    }
    public int getNumOfProduce( ){
        return produceList.size();
    }
    public int getNumOfFreezer( ){
        return freezerList.size();
    }
    public int getNumOfAddons( ){ return addonsList.size(); }
    public int getNumOfDrinks( ){
        return drinkList.size();
    }

}
