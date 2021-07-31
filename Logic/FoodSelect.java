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
        foodList = getFoodFromSQL("food");
        vegetableList = getFoodFromSQL("vegetable");
        fruitList = getFoodFromSQL("fruit");
        meatList = getFoodFromSQL("meat");
        legumesList = getFoodFromSQL("legumes");
        dairyList = getFoodFromSQL("dairy");
        drinkList = getFoodFromSQL("drinks");
        FoodSelected = null;
    }

    public Food selectFood(ArrayList<Food> list, int index){
        return list.get(index);
    }


    public ArrayList<Food> getFoodFromSQL(String name) {

        try {
            if ( name.equals("food") ) {
                String name1 = "food";

                Food food;
                ArrayList<Food> list = new ArrayList<Food>();
                java.sql.Connection connect = DriverManager.getConnection(
                        "jdbc:mysql://34.141.44.144:3306/" + username, "root", "root");

                Statement statement = ((java.sql.Connection) connect).createStatement();
                String sql1 = "SELECT main FROM food";
                ResultSet resultset = statement.executeQuery(sql1);


                while (resultset.next()) {
                    food = new Food(resultset.getInt("id"), resultset.getString("foodname"), resultset.getString("main"), (Number)resultset.getDouble("calorie"));
                    list.add(food);
                    System.out.println(list);
                }
                connect.close();
                return list;
            }

            else{
                Food food;
                ArrayList<Food> list = new ArrayList<Food>();
                java.sql.Connection connect = DriverManager.getConnection(
                        "jdbc:mysql://34.141.44.144:3306/" + username, "root", "root");

                Statement statement = ((java.sql.Connection) connect).createStatement();
                String sql1 = "SELECT * FROM food WHERE main = '" + name + "'";
                ResultSet resultset = statement.executeQuery(sql1);


                while (resultset.next()) {
                    food = new Food(resultset.getInt("id"), resultset.getString("foodname"), resultset.getString("main"), (Number)resultset.getDouble("calorie"));
                    list.add(food);
                    System.out.println(list);
                }
                connect.close();
                return list;
            }

        }catch(Exception e){
            System.out.println(e);
            return null;
        }

    }

    public static String textReader() throws FileNotFoundException
    {
        File file = new File( "filename.txt" );
        Scanner scan = new Scanner( file );
        String name = scan.next();
        scan.close();
        return name;
    }
}