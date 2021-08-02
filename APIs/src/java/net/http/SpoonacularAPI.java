package APIs.src.java.net.http;

import java.io.IOException;
import java.net.http.*;
import java.net.*;
import java.util.ArrayList;

import Logic.Food;
import Logic.Recipe;
import org.json.JSONArray;
import org.json.JSONObject;

public class SpoonacularAPI {

    private String apiKey;
    private String apiKey2 = "609871132cmshf0661655cd3fa40p1266fbjsn0a5ce850b254";
    private String apiKey3 = "da73587c8emsh6ca56b7d9f2a385p1699dcjsnf6a7ee99f8e3";
    private String apiKey4 = "2b1ad64154msh266681e9461a336p1bfd1bjsndcdef3e10f2a";
    private String apiKey5 = "faacc421edmsh15a90bfe13716c2p1c26f3jsnb71ff1a1e797";

    public SpoonacularAPI(){
        apiKey = apiKey5;;
    }

    public String sendRequest(String url) throws IOException, InterruptedException{
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create( url ))
                .header("x-rapidapi-key", apiKey)
                .header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public ArrayList<Recipe> searchRecipesByIngredients( ArrayList<String> ingredientList ) throws IOException, InterruptedException {

        StringBuilder ingredients = new StringBuilder();
        ArrayList<Recipe> recipes = new ArrayList<>();

        for ( int i = 0; i < ingredientList.size(); i++ ) {
            String ingredient = ingredientList.get( i );
            ingredient = ingredient.replaceAll( "[^a-zA-Z]", "" );
            System.out.println( ingredient );
            ingredients.append( ingredient );
            if ( i != ingredientList.size() - 1 ) {
                ingredients.append( "%2C" );
            }
        }
        String url = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/" +
                "findByIngredients?ingredients=" + ingredients + "&ranking=2&ignorePantry=true&number=5";

        JSONArray array = new JSONArray( sendRequest( url )  );

        for ( int i = 0; i < array.length(); i++ ) {
            JSONObject item = array.getJSONObject( i );
            recipes.add( new Recipe( item.getInt( "id" ), item.getString( "title" ), item.getString( "image" ) ) );
        }

        return recipes;
    }

    public ArrayList<String> getRecipeInformation( int recipeID ) throws IOException, InterruptedException {
        ArrayList<String> information = new ArrayList<>();

        String url = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/" + recipeID + "/information";

        JSONObject object = new JSONObject( sendRequest( url ) );
        try {
            information.add(object.getString("instructions"));
        }
        catch ( Exception JSONException ) {
            information.add( "There were no instructions for the selected recipe.");
        }
        information.add( "" + object.getInt( "spoonacularScore" ) );

        JSONArray array = object.getJSONArray( "extendedIngredients" );

        for ( int i = 0; i < array.length(); i++ ) {
            JSONObject item = array.getJSONObject( i );
            information.add( String.valueOf( item.getString( "name" ) ) );
        }

        return information;
    }

    public Recipe getRandomRecipe() throws IOException, InterruptedException {
        ArrayList<String> information = new ArrayList<>();

        String url = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/random?tags=&number=1";

        JSONObject object = new JSONObject( sendRequest( url ) );
        JSONArray array = object.getJSONArray( "recipes" );
        JSONObject item = array.getJSONObject( 0 );

        return new Recipe( item.getInt( "id" ), item.getString( "title" ), item.getString( "image" ) );
    }


    public String searchFoodVideos( String foodName ) throws IOException, InterruptedException {
        String[] words = foodName.split( " " );
        StringBuilder name = new StringBuilder();

        for ( int i = 0; i < words.length; i++ ) {
            name.append( words[i] );
            if ( i != words.length - 1 ) {
                name.append( "%20" );
            }
        }

        String url = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/food/videos/" +
                "search?offset=0&number=10&" +
                "maxLength=999&minLength=0&query=" + name;

        JSONObject object = new JSONObject( sendRequest( url ) );
        JSONArray videos = new JSONArray( object.getJSONArray( "videos" ) );

        int maxViews =0;
        int indexOfMax = 0;
        for ( int i = 0; i < videos.length(); i++ ) {
            int views = videos.getJSONObject( i ).getInt( "views" );
            if ( views > maxViews ) {
                maxViews = views;
                indexOfMax = i;
            }
        }

        String id;

        try {
            id = videos.getJSONObject(indexOfMax).getString("youTubeId");
        }
        catch ( Exception e ) {
            id = "NpEaa2P7qZI";
        }

        return "https://www.youtube.com/embed/" + id;
    }

    public String[] getFoodId( String foodName ) throws IOException, InterruptedException {
        String[] foodList = new String[8];

        String url = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/food/ingredients/autocomplete?query=" +
                foodName + "&number=4&metaInformation=true";

        JSONArray array = new JSONArray( sendRequest( url ) );

        for ( int i = 0; i < array.length(); i++ ) {
            JSONObject item = array.getJSONObject( i );

            //System.out.println(  item.getInt("id") + " : " + item.getString("name" ) );
            foodList[i] = item.getString("name" );
            // System.out.println(  item.getString("name" ) + "Will be added to :" + ( i + array.length() - 1 ) );
            foodList[ i + array.length() ] = item.getInt("id") + "";
        }

        return foodList;
    }

    public Food getFoodInformation( int foodID ) throws IOException, InterruptedException {
        Food food = null;

        String url = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/food/ingredients/" + foodID +
                "/information?unit=gram&amount=100";

        JSONObject object = new JSONObject(  sendRequest( url ) );

        Number item = 0;
        JSONArray array = object.getJSONObject( "nutrition" ).getJSONArray( "nutrients" );
        for ( int i = 0; i < array.length(); i++ ) {
            if ( array.getJSONObject( i ).get( "title" ).equals( "Calories" ) ){
                item = array.getJSONObject( i ).getNumber("amount" );
            }
        }
        food = new Food( object.getInt( "id" ), object.getString( "name" ), object.getString( "aisle" ),
                item);

        return food;
    }

    public String getJoke() throws IOException, InterruptedException {
        String url = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/food/jokes/random";
        JSONObject object = new JSONObject(  sendRequest( url ) );

        return object.getString( "text" );
    }

    public String getTrivia() throws IOException, InterruptedException {
        String url = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/food/trivia/random";
        JSONObject object = new JSONObject(  sendRequest( url ) );

        return object.getString( "text" );
    }

    public static void main( String[] args ) throws IOException, InterruptedException {
        String apiKey = "2b1ad64154msh266681e9461a336p1bfd1bjsndcdef3e10f2a";
        String apiKey2 = "609871132cmshf0661655cd3fa40p1266fbjsn0a5ce850b254";
        String apiKey3 = "da73587c8emsh6ca56b7d9f2a385p1699dcjsnf6a7ee99f8e3";

        SpoonacularAPI foodApi = new SpoonacularAPI();
        System.out.println( foodApi.searchFoodVideos( "chicken soup" ));
        /*
        System.out.println();
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add( "chicken" );

        try {
            // foodApi.getJoke();
            // System.out.println(  foodApi.getJoke() );
            // System.out.println( foodApi.searchFoodVideos( "potato") );
            Recipe recipe = foodApi.searchRecipesByIngredients( ingredients ).get(0);
            ArrayList<String> foodDetails = foodApi.getRecipeInformation( recipe.getID() );
            String instructions = foodDetails.get(0);
            String healthBar = foodDetails.get(1);
            System.out.println( recipe.getID() );
            System.out.println( instructions );
            System.out.println( healthBar );

            for( int count = 2; count< foodDetails.size(); count++){
                System.out.println(foodDetails.get(count));
            }

//            ArrayList<Recipe> recipes = foodApi.searchRecipesByIngredients( ingredients );
//
//            for ( int count = 0; count < recipes.size(); count++){
//                Recipe recipe = recipes.get(count);
//                ArrayList<String> foodDetails = foodApi.getFoodInformation( recipe.getID() );
//                String instructions = foodDetails.get(0);
//                String healthBar = foodDetails.get(1);
//                System.out.println( instructions );
//                System.out.println( healthBar );
//            }

            System.out.println( recipe.getImageURL() );

            //System.out.println( foodApi.getRecipeInformation( foodApi.getRandomRecipe().getID() ) );
        } catch ( IOException | InterruptedException e ) {
            e.printStackTrace();
        }

         */
    }
}