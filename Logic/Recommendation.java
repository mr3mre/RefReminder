package Logic;

import java.net.URL;
import java.util.ArrayList;

public class Recommendation extends Recipe{

	private ArrayList< Recipe > recommendationList;
//	private ArrayList< String > ingredients;
	private String recipeName;
	private URL link;
	private Storage storage;
	
	//public Logic.Recommendation() {
	//	recommendationList = new ArrayList< Logic.Recipe >();
		
	//	for ( Logic.Recipe recipe : recipeList ) {
	//		if ( isRecipeMakeable( recipe ) )
	//			recommendationList.add( recipe );
	//	}
	//}
	
	public void removeRecommendation( Recipe recipe ) {
		recommendationList.remove( recommendationList.indexOf( recipe ) );
	}
	
	public Recipe getRandomRecipe() { 
		int random = (int) ( Math.random() * recommendationList.size() );
		return recommendationList.get( random ); 
	}
	
	//private static boolean isRecipeMakeable( Logic.Recipe recipe ) {
		
	//	for ( String ingredient : recipe.getIngredients() ) {
	//		if ( storage.contain( ingredient ) ) {
	//			return true;
	//		}
	//	}
	//
	//	return false;
	//}
	
	public Recipe recommendRecipe( String main ) {
		
		return null;
	}
	
}
