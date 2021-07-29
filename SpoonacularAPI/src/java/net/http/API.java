package SpoonacularAPI.src.java.net.http;

import java.io.IOException;
import java.net.http.*;
import java.net.*;
import java.util.ArrayList;

import Logic.Food;
import Logic.Recipe;
import org.json.JSONArray;
import org.json.JSONObject;


public class API {
		
 	public ArrayList<Recipe> searchRecipesByIngredients( ArrayList<String> ingredientList ) throws IOException, InterruptedException {
 		StringBuilder ingredients = new StringBuilder();
 		ArrayList<Recipe> recipes = new ArrayList<>();

 		for ( int i = 0; i < ingredientList.size(); i++ ) {
			ingredients.append( ingredientList.get( i ) );
 			if ( i != ingredientList.size() - 1 ) {
 				ingredients.append( "%2C" );
			}
		}

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/" +
								"findByIngredients?ingredients=" + ingredients + "&ranking=1&ignorePantry=true&number=5"))
				.header("x-rapidapi-key", "609871132cmshf0661655cd3fa40p1266fbjsn0a5ce850b254")
				.header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		JSONArray array = new JSONArray( response.body() );

		for ( int i = 0; i < array.length(); i++ ) {
			JSONObject item = array.getJSONObject( i );
			recipes.add( new Recipe( item.getInt( "id" ), item.getString( "title" ), item.getString( "image" ) ) );
		}

		return recipes;
	}

	public ArrayList<String> getRecipeInformation( int recipeID ) throws IOException, InterruptedException {
 		ArrayList<String> information = new ArrayList<>();

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/" + recipeID + "/information"))
				.header("x-rapidapi-key", "609871132cmshf0661655cd3fa40p1266fbjsn0a5ce850b254")
				.header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		JSONObject object = new JSONObject( response.body() );

		information.add( object.getString( "instructions" ) );
		JSONArray array = object.getJSONArray( "extendedIngredients" );

		for ( int i = 0; i < array.length(); i++ ) {
			JSONObject item = array.getJSONObject( i );
			information.add( String.valueOf( item.getInt( "id" ) ) );
		}

		return information;
	}

	//todo Recipe cekemedim
	public Recipe getRandomRecipe() throws IOException, InterruptedException {
		ArrayList<String> information = new ArrayList<>();

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/random?tags=meal&number=1"))
				.header("x-rapidapi-key", "609871132cmshf0661655cd3fa40p1266fbjsn0a5ce850b254")
				.header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		JSONObject object = new JSONObject( response.body() );
		JSONArray array = object.getJSONArray( "recipes" );
		JSONObject item = array.getJSONObject( 0 );

		Recipe recipe = new Recipe( item.getInt( "id" ), item.getString( "title" ), item.getString( "image" ) );
		return recipe;
	}

	public void searchFoodVideos( String foodName ) throws IOException, InterruptedException {
 		String[] words = foodName.split( " " );
 		StringBuilder name = new StringBuilder();

 		for ( int i = 0; i < words.length; i++ ) {
			name.append( words[i] );
 			if ( i != words.length - 1 ) {
				name.append( "%20" );
			}
		}

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/food/videos/" +
								"search?offset=0&excludeingredients=mustard&includeingredients=chicken&number=10&" +
								"maxLength=999&minLength=0&query=" + name ) )
				.header("x-rapidapi-key", "609871132cmshf0661655cd3fa40p1266fbjsn0a5ce850b254")
				.header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
	}

	//todo Kalori yanlis
	public Food getFoodInformation( int foodID ) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/food/ingredients/" + foodID +
								"/information?unit=gram&amount=100"))
				.header("x-rapidapi-key", "609871132cmshf0661655cd3fa40p1266fbjsn0a5ce850b254")
				.header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		JSONObject object = new JSONObject( response.body() );

		Food food = new Food( object.getInt( "id" ), object.getString( "name" ), object.getString( "aisle" ),
							  object.getJSONObject( "nutrition" ).getJSONArray( "nutrients" ).getJSONObject( 0 )
							  .getNumber( "amount" ) );

		return food;
	}
}


