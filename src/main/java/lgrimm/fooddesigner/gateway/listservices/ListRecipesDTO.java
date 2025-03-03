package lgrimm.fooddesigner.gateway.listservices;

import java.util.*;

public class ListRecipesDTO {
	private final List<ListRecipesElement> recipes;
	private final String searchText;
	private final String message;

	public ListRecipesDTO(
			List<ListRecipesElement> recipes,
			String searchText,
			String message) {
		this.recipes = recipes;
		this.searchText = searchText;
		this.message = message;
	}

	public List<ListRecipesElement> getRecipes() {
		return recipes;
	}

	public String getSearchText() {
		return searchText;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ListRecipesDTO that)) return false;
		return
				Objects.equals(recipes, that.recipes) &&
				Objects.equals(searchText, that.searchText) &&
				Objects.equals(message, that.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(recipes, searchText, message);
	}

	@Override
	public String toString() {
		return "ListRecipesDTO{" +
				"recipes=" + recipes +
				", searchText='" + searchText + '\'' +
				", message='" + message + '\'' +
				'}';
	}
}
