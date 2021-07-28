package Logic;

import java.net.URL;
import java.util.*;

public class Recipe {
	
	protected ArrayList< Recipe > recipeList;
	private ArrayList< String > ingredients;
	private String recipeName;
	private URL link;
	
	public Recipe() {
		recipeList = new ArrayList< Recipe >();
		ingredients = new ArrayList< String >();
	}
	
	public String getRecipeName() { return recipeName; }
	
	public URL getLink() { return link; }
	
	public ArrayList< String > getIngredients() { return ingredients; }
}
