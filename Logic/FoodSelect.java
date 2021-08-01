package Logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Goksu
 * @author H.Emre
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

        produceList = getFoodFromSQL("Produce");
        breakfastList = getFoodFromSQL("Breakfast");
        mainDishesList = getFoodFromSQL("Main Dishes");
        freezerList = getFoodFromSQL("Freezer");
        drinkList = getFoodFromSQL("Drink");
        addonsList = getFoodFromSQL("Food Addons");

        foodList.addAll(produceList);
        foodList.addAll(breakfastList);
        foodList.addAll(mainDishesList);
        foodList.addAll(freezerList);
        foodList.addAll(addonsList);
        foodList.addAll(drinkList);


//        System.out.println(foodList);
//        System.out.println(vegetableList);
//        System.out.println(fruitList);
//        System.out.println(meatList);
//        System.out.println(legumesList);
//        System.out.println(dairyList);
//        System.out.println(drinkList);
    }

    public Food selectFood(ArrayList<Food> list, int index){
        return list.get(index);
    }


    public ArrayList<Food> getFoodFromSQL(String name) {

        try {

                Food food;
                ArrayList<Food> list = new ArrayList<Food>();
                java.sql.Connection connect = DriverManager.getConnection(
                        "jdbc:mysql://34.141.44.144:3306/" + username, "root", "root");

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


        }catch(Exception e){
            System.out.println(e);
            return null;
        }

    }

    public static String textReader() throws FileNotFoundException
    {
        File file = new File("filename.txt");
        Scanner scan = new Scanner( file );
        String name = scan.next();
        scan.close();
        return name;
    }
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
