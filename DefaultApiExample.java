import Api.src.java.net.http.API;

import java.io.IOException;

public class DefaultApiExample {

    public static void main( String[] args ) throws IOException, InterruptedException {
        API api = new API();
        api.searchRecipesByIngredients();
        api.searchFoodVideos();
    }


}