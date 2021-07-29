package Logic;

import java.util.*;

public class Recipe {

	private ArrayList< String > ingredients;
	private int id;
	private String recipeName;
	private String imageURL;
	private String instructions;
	
	public Recipe( int id, String name, String image ) {
		ingredients = new ArrayList< String >();
		this.id = id;
		recipeName = name;
		imageURL = image;
	}

	public int getID() {
		return id;
	}
	
	public String getRecipeName() {
		return recipeName; }
	
	public String getImageURL() {
		return imageURL; }
	
	public ArrayList< String > getIngredients() {
		return ingredients; }

	public String getInstructions() {
		return instructions;
	}

	public void setIngredients( ArrayList<String> ingredients ) {
		this.ingredients = ingredients;
	}

	public void setInstructions( String instructions ) {
		this.instructions = instructions;
	}
}
