package lgrimm.fooddesigner.ingredient.query.searchingredients;

import java.util.*;

public class SearchIngredientsDTO {
	private final List<SearchIngredientsElement> ingredients;
	private final String searchText;
	private final String message;

	public SearchIngredientsDTO(List<SearchIngredientsElement> ingredients, String searchText, String message) {
		this.ingredients = ingredients;
		this.searchText = searchText;
		this.message = message;
	}

	public List<SearchIngredientsElement> getIngredients() {
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
		if (!(o instanceof SearchIngredientsDTO that)) return false;
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
		return "SearchIngredientsDTO{" +
				"ingredients=" + ingredients +
				", searchText='" + searchText + '\'' +
				", message='" + message + '\'' +
				'}';
	}
}
