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

        ArrayList<Recipe> recipes = api.searchRecipesByIngredients( ingredients );

        for ( Recipe recipe : recipes ) {
            ArrayList<String> ids = new ArrayList<>();
            ArrayList<String> info = api.getRecipeInformation( recipe.getID() );

            recipe.setInstructions( info.get( 0 ) );
            for ( int i = 1; i < info.size(); i++ ) {
                ids.add( info.get( i ) );
            }
            recipe.setIngredients( ids );
            System.out.println( recipe.getInstructions() );
            System.out.println( recipe.getIngredients() );
        }

        //api.searchFoodVideos( "chicken soup" );
        //Food food = api.getFoodInformation( 9266 );
    }
}