package lgrimm.fooddesigner.subingredient.query.searchsubingredients;

import java.util.*;

public class SearchSubIngredientsDTO {
	private final List<SearchSubIngredientsElement> subIngredients;
	private final String searchText;
	private final String message;

	public SearchSubIngredientsDTO(List<SearchSubIngredientsElement> subIngredients, String searchText, String message) {
		this.subIngredients = subIngredients;
		this.searchText = searchText;
		this.message = message;
	}

	public List<SearchSubIngredientsElement> getSubIngredients() {
		return subIngredients;
	}

	public String getSearchText() {
		return searchText;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof SearchSubIngredientsDTO that)) return false;
		return Objects.equals(subIngredients, that.subIngredients) &&
				Objects.equals(searchText, that.searchText) &&
				Objects.equals(message, that.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(subIngredients, searchText, message);
	}

	@Override
	public String toString() {
		return "SearchSubIngredientsDTO{" +
				"subIngredients=" + subIngredients +
				", searchText='" + searchText + '\'' +
				", message='" + message + '\'' +
				'}';
	}
}
