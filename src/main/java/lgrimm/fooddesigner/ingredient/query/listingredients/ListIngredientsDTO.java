package lgrimm.fooddesigner.ingredient.query.listingredients;

import java.util.*;

public class ListIngredientsDTO {
	private final List<ListIngredientsElement> ingredients;
	private final String searchText;
	private final String message;

	public ListIngredientsDTO(
			List<ListIngredientsElement> ingredients,
			String searchText,
			String message) {
		this.ingredients = ingredients;
		this.searchText = searchText;
		this.message = message;
	}

	public List<ListIngredientsElement> getIngredients() {
		return ingredients;
	}

	public String getSearchText() {
		return searchText;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ListIngredientsDTO that)) return false;
		return Objects.equals(ingredients, that.ingredients) &&
				Objects.equals(searchText, that.searchText) &&
				Objects.equals(message, that.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ingredients, searchText, message);
	}

	@Override
	public String toString() {
		return "ListIngredientsDTO{" +
				"ingredients=" + ingredients +
				", searchText='" + searchText + '\'' +
				", message='" + message + '\'' +
				'}';
	}
}
