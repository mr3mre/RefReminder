package Logic;

import java.sql.*;
import java.util.ArrayList;


public class FoodSelect {

	 ArrayList<Food> 	foodList;
	 ArrayList<Food>  	vegetableList;
	 ArrayList<Food> 	fruitList;
	 ArrayList<Food> 	meatList;
	 ArrayList<Food>  	legumesList;
	 ArrayList<Food> 	dairyList;
	 Food FoodSelected;
	 
	public FoodSelect(){
		foodList = getFoodFromSQL("food");
		vegetableList = getFoodFromSQL("vegetable");
		fruitList = getFoodFromSQL("fruit");
		meatList = getFoodFromSQL("meat");
		legumesList = getFoodFromSQL("legumes");
		dairyList = getFoodFromSQL("dairy");
		FoodSelected = null;
	}

	public Food selectFood(ArrayList<Food> list, int index){
        return list.get(index);
    }   
	
	
public ArrayList<Food> getFoodFromSQL(String name){
        try{

            Food food; 
            ArrayList<Food> list = new ArrayList<Food>();
            java.sql.Connection connect = DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/food" , "root", "root");  
            
            Statement statement = ((java.sql.Connection) connect).createStatement();  
            
            ResultSet resultset = statement.executeQuery("select * from foodlist"); 
            
            while(resultset.next()){
                food = new Food(resultset.getString("fd_name"), resultset.getString("fd_exp"), resultset.getString("fd_main"), resultset.getDouble("fd_qt"), resultset.getDouble("fd_cal"));
                list.add(food);
                System.out.println(list);
            }
            connect.close(); 
            return list; 
        }catch(Exception e){ 
            System.out.println(e);
            return null;
        }
          
    }

	// DO
}
