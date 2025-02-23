package lgrimm.fooddesigner.ingredient.query.findingredient;

import lgrimm.fooddesigner.domain.*;

import java.util.*;

public class FindIngredientDTO {
	private final IngredientEntity ingredient;
	private final String message;

	public FindIngredientDTO(IngredientEntity ingredient, String message) {
		this.ingredient = ingredient;
		this.message = message;
	}

	public IngredientEntity getIngredient() {
		return ingredient;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof FindIngredientDTO that)) return false;
		return
				Objects.equals(ingredient, that.ingredient) &&
						Objects.equals(message, that.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ingredient, message);
	}

	@Override
	public String toString() {
		return "FindIngredientDTO{" +
				"ingredient=" + ingredient +
				", message='" + message + '\'' +
				'}';
	}
}
