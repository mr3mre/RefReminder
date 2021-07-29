package java.net.http;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;

//import org.json.JSONArray;


//import java.net.http.*;

public class Restaurants {
	
	public static String getLocation( String apiKey, String cityName ) throws IOException, InterruptedException{
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://worldwide-restaurants.p.rapidapi.com/typeahead"))
				.header("content-type", "application/x-www-form-urlencoded")
				.header("x-rapidapi-key", apiKey )
				.header("x-rapidapi-host", "worldwide-restaurants.p.rapidapi.com")
				.method("POST", HttpRequest.BodyPublishers.ofString("q=" + cityName + "&language=en_US"))
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//		System.out.println( response.body() );
		
//		System.out.println( str.substring( index + 14, str.indexOf( "," , index) - 1 ) );
		
//		JSONArray array = new JSONArray( response.body() );
//		JSONObject item = array.getJSONObject( 5 );
//		System.out.println(  item.getInt( "location_id" ) );
		
		String str = response.body();
		int index = str.indexOf( "location_id" );
		String locId = str.substring( index + 14, str.indexOf( "," , index) - 1 );

		return locId;
	}
	
	public static void getRestaurants( String apiKey, String locId ) throws IOException, InterruptedException{
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://worldwide-restaurants.p.rapidapi.com/search"))
				.header("content-type", "application/x-www-form-urlencoded")
				.header("x-rapidapi-key", apiKey )
				.header("x-rapidapi-host", "worldwide-restaurants.p.rapidapi.com")
				.method("POST", HttpRequest.BodyPublishers.ofString("language=en_US&limit=30&location_id=" + locId + "&currency=USD"))
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		
//		File file = new File("/Users/emre/A.txt");
//	    FileWriter writer;
//	    try {
//	        writer = new FileWriter(file, true);
//	        PrintWriter printer = new PrintWriter(writer);
//	        printer.append( response.body() );
//	        printer.close();
//	    } catch (IOException e) {
//	        // TODO Auto-generated catch block
//	        e.printStackTrace();
//	    }
		
	}
	
	public static void main( String[] args) throws IOException, InterruptedException
	{
		
		String api = "2b1ad64154msh266681e9461a336p1bfd1bjsndcdef3e10f2a";
		String api2 = "609871132cmshf0661655cd3fa40p1266fbjsn0a5ce850b254";
		
		getRestaurants( api2, getLocation( api, "Anka" ) );
		
//		JSONArray array = new JSONArray( response.body() );
//
//		for ( int i = 0; i < array.length(); i++ ) {
//			JSONObject item = array.getJSONObject( i );
//			item.getInt( "location_id" )
//			System.out.println( item.getInt( "id" ) );
//			System.out.println( item.getString( "title" ) );
//			System.out.println( item.getString( "image" ) );
//	
		}

}

