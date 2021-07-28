package Logic;

import java.util.*;

public class Recipe {

	private ArrayList< String > ingredients;
	private int id;
	private String recipeName;
	private String imageURL;
	
	public Recipe( int id, String name, String image ) {
		ingredients = new ArrayList< String >();
		this.id = id;
		recipeName = name;
		imageURL = image;
	}
	
	public String getRecipeName() { return recipeName; }
	
	public String getImageURL() { return imageURL; }
	
	public ArrayList< String > getIngredients() { return ingredients; }
}
