package API.src.java.net.http;

import java.io.IOException;
import java.net.http.*;
import java.net.*;
import java.util.ArrayList;


public class API {
		
 	public void searchRecipesByIngredients( ArrayList<String> ingredientList ) throws IOException, InterruptedException {
 		StringBuilder ingredients = new StringBuilder();

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
	    System.out.println(response.body());
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

	public void getFoodInformation( int foodID ) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/food/ingredients/" + foodID + "/information?unit=gram&amount=100"))
				.header("x-rapidapi-key", "609871132cmshf0661655cd3fa40p1266fbjsn0a5ce850b254")
				.header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
	}
}


