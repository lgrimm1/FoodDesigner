package lgrimm.fooddesigner.gateway.listservices;

import java.util.*;

public class RootDTO {
	private final List<RootElement> recipes;
	private final String searchText;
	private final String message;

	public RootDTO(List<RootElement> recipes, String searchText, String message) {
		this.recipes = recipes;
		this.searchText = searchText;
		this.message = message;
	}

	public List<RootElement> getRecipes() {
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
		if (!(o instanceof RootDTO rootDTO)) return false;
		return Objects.equals(recipes, rootDTO.recipes) &&
				Objects.equals(searchText, rootDTO.searchText) &&
				Objects.equals(message, rootDTO.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(recipes, searchText, message);
	}

	@Override
	public String toString() {
		return "RootDTO{" +
				"recipes=" + recipes +
				", searchText='" + searchText + '\'' +
				", message='" + message + '\'' +
				'}';
	}
}
