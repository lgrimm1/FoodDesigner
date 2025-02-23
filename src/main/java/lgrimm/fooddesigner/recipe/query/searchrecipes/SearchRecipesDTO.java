package lgrimm.fooddesigner.recipe.query.searchrecipes;

import java.util.*;

public class SearchRecipesDTO {
	private final List<SearchRecipesElement> recipes;
	private final String searchText;
	private final String message;

	public SearchRecipesDTO(List<SearchRecipesElement> recipes, String searchText, String message) {
		this.recipes = recipes;
		this.searchText = searchText;
		this.message = message;
	}

	public List<SearchRecipesElement> getRecipes() {
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
		if (!(o instanceof SearchRecipesDTO that)) return false;
		return Objects.equals(recipes, that.recipes) &&
				Objects.equals(searchText, that.searchText) &&
				Objects.equals(message, that.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(recipes, searchText, message);
	}

	@Override
	public String toString() {
		return "SearchRecipesDTO{" +
				"recipes=" + recipes +
				", searchText='" + searchText + '\'' +
				", message='" + message + '\'' +
				'}';
	}
}
