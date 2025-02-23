package lgrimm.fooddesigner.subingredient.query.findsubingredient;

import lgrimm.fooddesigner.domain.*;

import java.util.*;

public class FindSubIngredientDTO {
	private final SubIngredientEntity subIngredient;
	private final String message;

	public FindSubIngredientDTO(SubIngredientEntity subIngredient, String message) {
		this.subIngredient = subIngredient;
		this.message = message;
	}

	public SubIngredientEntity getSubIngredient() {
		return subIngredient;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof FindSubIngredientDTO that)) return false;
		return
				Objects.equals(subIngredient, that.subIngredient) &&
						Objects.equals(message, that.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(subIngredient, message);
	}

	@Override
	public String toString() {
		return "FindSubIngredientDTO{" +
				"subIngredient=" + subIngredient +
				", message='" + message + '\'' +
				'}';
	}
}
