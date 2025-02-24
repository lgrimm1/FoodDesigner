package lgrimm.fooddesigner.recipe.query.findrecipe;

import java.util.*;

public class ListRecipesDTO {
	private final List<ListRecipesElement> recipes;
	private final String message;

	public ListRecipesDTO(List<ListRecipesElement> recipes, String message) {
		this.recipes = recipes;
		this.message = message;
	}

	public List<ListRecipesElement> getRecipes() {
		return recipes;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ListRecipesDTO rootDTO)) return false;
		return Objects.equals(recipes, rootDTO.recipes) &&
				Objects.equals(message, rootDTO.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(recipes, message);
	}

	@Override
	public String toString() {
		return "ListRecipesDTO{" +
				"recipes=" + recipes +
				", message='" + message + '\'' +
				'}';
	}
}
