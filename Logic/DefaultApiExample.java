package Logic;

import SpoonacularAPI.src.java.net.http.API;

import java.io.IOException;
import java.util.ArrayList;

public class DefaultApiExample {

    public static void main( String[] args ) throws IOException, InterruptedException {
        API api = new API();

        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add( "chicken" );
        ingredients.add( "milk" );
        ingredients.add( "meat" );

        //System.out.println( api.searchRecipesByIngredients( ingredients ) );
        //api.searchFoodVideos( "chicken soup" );
        Food food = api.getFoodInformation( 9266 );
        System.out.println( food.getFoodName() );
        System.out.println( food.getMain() );
        System.out.println( food.getCaloriePerPortion() );
    }
}