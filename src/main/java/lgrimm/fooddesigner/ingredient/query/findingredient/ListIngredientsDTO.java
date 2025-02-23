package lgrimm.fooddesigner.ingredient.query.findingredient;

import java.util.*;

public class ListIngredientsDTO {
	private final List<ListIngredientsElement> ingredients;
	private final String message;

	public ListIngredientsDTO(List<ListIngredientsElement> ingredients, String message) {
		this.ingredients = ingredients;
		this.message = message;
	}

	public List<ListIngredientsElement> getIngredients() {
		return ingredients;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ListIngredientsDTO rootDTO)) return false;
		return Objects.equals(ingredients, rootDTO.ingredients) &&
				Objects.equals(message, rootDTO.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ingredients, message);
	}

	@Override
	public String toString() {
		return "ListIngredientsDTO{" +
				"ingredients=" + ingredients +
				", message='" + message + '\'' +
				'}';
	}
}
