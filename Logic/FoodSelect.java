package Logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class FoodSelect {

    ArrayList<Food> 	foodList;
    ArrayList<Food>  	vegetableList;
    ArrayList<Food> 	fruitList;
    ArrayList<Food> 	meatList;
    ArrayList<Food>  	legumesList;
    ArrayList<Food> 	dairyList;
    ArrayList<Food> 	drinkList;

    Food FoodSelected;
    String username;

    public FoodSelect(){
        try
        {

            username = textReader();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("1");
        }
        FoodSelected = null;
        foodList = getFoodFromSQL("food");
        vegetableList = getFoodFromSQL("vegetable");
        fruitList = getFoodFromSQL("fruit");
        meatList = getFoodFromSQL("meat");
        legumesList = getFoodFromSQL("legumes");
        dairyList = getFoodFromSQL("dairy");
        drinkList = getFoodFromSQL("drinks");

        foodList.addAll(vegetableList);
        foodList.addAll(fruitList);
        foodList.addAll(meatList);
        foodList.addAll(legumesList);
        foodList.addAll(dairyList);
        foodList.addAll(drinkList);


        System.out.println(foodList);
        System.out.println(vegetableList);
        System.out.println(fruitList);
        System.out.println(meatList);
        System.out.println(legumesList);
        System.out.println(dairyList);
        System.out.println(drinkList);
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

    public ArrayList<Food> getDairyList (){

        return dairyList;
    }


    public ArrayList<Food> getVegetableList (){

        return vegetableList;
    }
    public ArrayList<Food> getFruitList (){

        return fruitList;
    }
    public ArrayList<Food> getMeatList (){

        return meatList;
    }
    public ArrayList<Food> getLegumesList (){

        return legumesList;
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
    public int getNumOfLegumes( ){
        return legumesList.size();
    }
    public int getNumOfMeat( ){
        return meatList.size();
    }
    public int getNumOfDairy( ){
        return dairyList.size();
    }
    public int getNumOfVegetables( ){
        return vegetableList.size();
    }
    public int getNumOfFruit( ){
        return fruitList.size();
    }
    public int getNumOfDrinks( ){
        return drinkList.size();
    }

}
