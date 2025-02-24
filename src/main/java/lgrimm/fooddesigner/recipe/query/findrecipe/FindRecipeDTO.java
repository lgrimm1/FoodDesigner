package lgrimm.fooddesigner.recipe.query.findrecipe;

import lgrimm.fooddesigner.domain.*;

import java.util.*;

public class FindRecipeDTO {
	private final RecipeEntity recipe;
	private final String message;

	public FindRecipeDTO(RecipeEntity recipe, String message) {
		this.recipe = recipe;
		this.message = message;
	}

	public RecipeEntity getRecipe() {
		return recipe;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof FindRecipeDTO that)) return false;
		return
				Objects.equals(recipe, that.recipe) &&
						Objects.equals(message, that.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(recipe, message);
	}

	@Override
	public String toString() {
		return "FindRecipeDTO{" +
				"recipe=" + recipe +
				", message='" + message + '\'' +
				'}';
	}
}
