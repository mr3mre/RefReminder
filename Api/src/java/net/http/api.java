package java.net.http;

//import jdk.incubator.http.*;
//import java.net.http.HttpResponse;
import java.net.http.*;
import java.io.IOException;
import java.net.*;


public class api {
	
	public static void main( String[] args) throws IOException, InterruptedException
	{
		HttpRequest request = HttpRequest.newBuilder()
				.uri( URI.create( "https://api.spoonacular.com/recipes/716429/information?apiKey=e07e28bafceb4a4ba3505b0b64a3496e&includeNutrition=true." ))
				.header("", "")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build(); 
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());

		
//		HttpResponse <String> httpResponse = Unirest.get( "<some_url>/<endpoint>?param1=value1&param2=value2" )
//			       .header("header1", header1)
//			       .header("header2", header2);
//			       .asString();
//			System.out.println( httpResponse.getHeaders().get("Content-Type"));
	}
}


