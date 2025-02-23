package lgrimm.fooddesigner.subingredient.query.findsubingredient;

import java.util.*;

public class ListSubIngredientsDTO {
	private final List<ListSubIngredientsElement> subIngredients;
	private final String message;

	public ListSubIngredientsDTO(List<ListSubIngredientsElement> subIngredients, String message) {
		this.subIngredients = subIngredients;
		this.message = message;
	}

	public List<ListSubIngredientsElement> getSubIngredients() {
		return subIngredients;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ListSubIngredientsDTO rootDTO)) return false;
		return Objects.equals(subIngredients, rootDTO.subIngredients) &&
				Objects.equals(message, rootDTO.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(subIngredients, message);
	}

	@Override
	public String toString() {
		return "ListSubIngredientsDTO{" +
				"subIngredients=" + subIngredients +
				", message='" + message + '\'' +
				'}';
	}
}
