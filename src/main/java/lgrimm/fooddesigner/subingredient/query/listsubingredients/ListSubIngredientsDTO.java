package lgrimm.fooddesigner.subingredient.query.listsubingredients;

import java.util.*;

public class ListSubIngredientsDTO {
	private final List<ListSubIngredientsElement> subIngredients;
	private final String searchText;
	private final String message;

	public ListSubIngredientsDTO(
			List<ListSubIngredientsElement> subIngredients,
			String searchText,
			String message) {
		this.subIngredients = subIngredients;
		this.searchText = searchText;
		this.message = message;
	}

	public List<ListSubIngredientsElement> getSubIngredients() {
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
		if (!(o instanceof ListSubIngredientsDTO that)) return false;
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
		return "ListSubIngredientsDTO{" +
				"subIngredients=" + subIngredients +
				", searchText='" + searchText + '\'' +
				", message='" + message + '\'' +
				'}';
	}
}
