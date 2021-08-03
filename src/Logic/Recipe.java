/*
 * Recipe class
 * @author Eren
 * @version 1.0
 * 31/07/2021
 */

package Logic;

import java.util.*;

/**
 * Blueprint for a Recipe
 * @author Eren
 * @date 31.07.2021
 */
public class Recipe {

	// Properties
	private ArrayList< String > ingredients;
	private int id;
	private String recipeName;
	private String imageURL;
	private String instructions;

	/**
	 * Constructs the recipe by the given parameters and creates empty ArrayList for ingredients
	 *
	 * @param id Recipe ID
	 * @param name Recipe name
	 * @param image Image to represent the recipe
	 */
	public Recipe( int id, String name, String image ) {
		ingredients = new ArrayList<>();
		this.id = id;
		recipeName = name;
		imageURL = image;
	}

	/**
	 * @return ID of the recipe
	 */
	public int getID() {
		return id;
	}

	/**
	 * @return Recipe name
	 */
	public String getRecipeName() {
		return recipeName; }

	/**
	 * @return Image to represent the recipe
	 */
	public String getImageURL() {
		return imageURL; }

	/**
	 * @return ArrayList that contains Recipe's ingredients
	 */
	public ArrayList<String> getIngredients() {
		return ingredients; }

	/**
	 * @return Instructions for the recipe
	 */
	public String getInstructions() {
		return instructions;
	}

	/**
	 * Sets the recipe's ingredients
	 *
	 * @param ingredients Ingredients for the recipe
	 */
	public void setIngredients( ArrayList<String> ingredients ) {
		this.ingredients = ingredients;
	}

	/**
	 * Sets the recipe's instructions
	 *
	 * @param instructions Instruction for the recipe
	 */
	public void setInstructions( String instructions ) {
		this.instructions = instructions;
	}
}
