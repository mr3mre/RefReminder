package Api.src.java.net.http;

import java.io.IOException;
import java.net.http.*;
import java.net.*;


public class API {
		
 	public void searchRecipesByIngredients() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/findByIngredients?ingredients=apples%2Cflour%2Csugar&ranking=1&ignorePantry=true&number=5"))
				.header("x-rapidapi-key", "609871132cmshf0661655cd3fa40p1266fbjsn0a5ce850b254")
				.header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
	    System.out.println(response.body());
	}

	public void searchFoodVideos() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/food/videos/search?offset=0&excludeingredients=mustard&includeingredients=chicken&number=10&maxLength=999&minLength=0&query=chicken%20soup"))
				.header("x-rapidapi-key", "609871132cmshf0661655cd3fa40p1266fbjsn0a5ce850b254")
				.header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
	}
}


