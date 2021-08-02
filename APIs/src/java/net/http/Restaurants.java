/*
 * Restaurants class
 * @author Emre
 * @version 1.0
 * 02/08/2021
 */


package APIs.src.java.net.http;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Restaurants {

	/**
	 * Gets the Location id by the city name
	 *
	 * @param apiKey API key to connect to API
	 * @param cityName City user wants to search in
	 * @return Location ID
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static String getLocation( String apiKey, String cityName ) throws IOException, InterruptedException{

		// Connects to API and sends request
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create( "https://worldwide-restaurants.p.rapidapi.com/typeahead" ) )
				.header( "content-type", "application/x-www-form-urlencoded" )
				.header( "x-rapidapi-key", apiKey )
				.header( "x-rapidapi-host", "worldwide-restaurants.p.rapidapi.com" )
				.method( "POST", HttpRequest.BodyPublishers.ofString("q=" + cityName + "&language=en_US" ) )
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		JSONObject object = new JSONObject( response.body() );

		// Gets data from JSON file
		JSONObject object2 = object.getJSONObject( "results" );
		JSONArray array = object2.getJSONArray( "data" );
		JSONObject object3 = (JSONObject) array.get(0);

		JSONObject object4 = object3.getJSONObject( "result_object" );

		/*
		To use in debugging

		object4.getString("name" );
		System.out.println( object4 );
		System.out.println( str.substring( index + 14, str.indexOf( "," , index) - 1 ) );
		JSONArray array = new JSONArray( response.body() );
		JSONObject item = array.getJSONObject( 5 );
		System.out.println(  item.getInt( "location_id" ) );
		 */
		
		String str = response.body();
		int index = str.indexOf( "location_id" );
		String locId = str.substring( index + 14, str.indexOf( "," , index) - 1 );

		//object4.getString("name" )
		return locId;
	}

	/**
	 * @param apiKey API key to connect to API
	 * @param locId Location ID
	 * @return JSONArray containing the restaurants
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static JSONArray getRestaurants( String apiKey, String locId ) throws IOException, InterruptedException{

		// Connects to API and sends request
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create( "https://worldwide-restaurants.p.rapidapi.com/search" ) )
				.header( "content-type", "application/x-www-form-urlencoded" )
				.header( "x-rapidapi-key", apiKey )
				.header( "x-rapidapi-host", "worldwide-restaurants.p.rapidapi.com" )
				.method( "POST", HttpRequest.BodyPublishers.ofString("language=en_US&limit=200&location_id="
								+ locId + "&currency=USD" ) )
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

		// Gets data from JSON file
		JSONObject object = new JSONObject( response.body() );
		JSONObject object2 = object.getJSONObject( "results" );
		JSONArray array = object2.getJSONArray( "data" );

		/*
		To use in debugging

		for ( int count = 0; count< array.length(); count++){
			JSONObject object3 = (JSONObject) array.get(count);
			object3.getString("description" );
			object3.getString("email" );
			object3.getString("website" );
			object3.getString("address" );
			object3.getString("name" );

			System.out.println( object3.getString("name" ) );
			System.out.println( object3.getString("description" ) );
			System.out.println( object3.getString("ranking" ) );
			if (  ( (String) object3.toString()).contains( "email" ) )
				System.out.println( object3.getString("email" ) );

			if (  ( (String) object3.toString()).contains( "price_level" ) ) {
				System.out.println(object3.getString("price_level"));
			}
			else if (  ( (String) object3.toString()).contains( "price" ) ) {
				System.out.println(object3.getString("price"));
			}
			System.out.println( object3.getString("website" ) );
			System.out.println( object3.getString("address" ) );

			JSONArray arrayCuisine = object3.getJSONArray( "cuisine" );
			for ( int index = 0; index< arrayCuisine.length(); index++) {
				JSONObject objectCuisine = (JSONObject) arrayCuisine.get(index);
				System.out.println( objectCuisine.getString("name" ) );
			}
		}
		*/
		return array;
	}

	/**
	 * Main method to test the API
	 *
	 * @param args Command line arguments
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main( String[] args) throws IOException, InterruptedException
	{
		
		String api = "2b1ad64154msh266681e9461a336p1bfd1bjsndcdef3e10f2a";
		String api2 = "609871132cmshf0661655cd3fa40p1266fbjsn0a5ce850b254";

		String ankaraId = ""+ 298656;
		getRestaurants( api, ankaraId );

		/*
		To use in debugging

		JSONArray array = new JSONArray( response.body() );

		for ( int i = 0; i < array.length(); i++ ) {
			JSONObject item = array.getJSONObject( i );
			item.getInt( "location_id" )
			System.out.println( item.getInt( "id" ) );
			System.out.println( item.getString( "image" ) );
		 */
		}

}

