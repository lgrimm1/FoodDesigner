package lgrimm.fooddesigner.domain;

import jakarta.persistence.*;

import java.io.*;
import java.util.*;

@Entity
@Table(name = "recipe")
public class Recipe implements Serializable {
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "recipe_id_generator", sequenceName = "recipe_id_generator", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_id_generator")
	private long id;
	@Column(name = "name", nullable = false, unique = true, columnDefinition = "TEXT")
	private String name;
	@Column(name = "ingredient_ids", nullable = false, unique = false)
	private List<Long> ingredientIds;
	@Column(name = "ingredient_weights", nullable = false, unique = false)
	private List<Integer> ingredientWeights;
	@Column(name = "notes", nullable = false, unique = false, columnDefinition = "TEXT")
	private String notes;
	@Column(name = "steps", nullable = false, unique = false, columnDefinition = "TEXT")
	private String steps;
	@Column(name = "cooling_limit", nullable = false, unique = false)
	private int coolingLimit;
	@Column(name = "freezing_limit", nullable = false, unique = false)
	private int freezingLimit;
	@Transient
	private Map<Long, Integer> ingredientsAndWeightsMap;

	public Recipe() {
	}

	public Recipe(
			String name,
			List<Long> ingredientIds,
			List<Integer> ingredientWeights,
			String notes,
			String steps,
			int coolingLimit,
			int freezingLimit) {
		if (name == null ||
				ingredientIds == null ||
				ingredientWeights == null ||
				ingredientIds.size() != ingredientWeights.size() ||
				notes == null ||
				steps == null) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.ingredientIds = ingredientIds;
		this.ingredientWeights = ingredientWeights;
		this.notes = notes;
		this.steps = steps;
		this.coolingLimit = coolingLimit;
		this.freezingLimit = freezingLimit;
	}

	public Recipe(
			long id,
			String name,
			List<Long> ingredientIds,
			List<Integer> ingredientWeights,
			String notes,
			String steps,
			int coolingLimit,
			int freezingLimit) {
		if (name == null ||
				ingredientIds == null ||
				ingredientWeights == null ||
				ingredientIds.size() != ingredientWeights.size() ||
				notes == null ||
				steps == null) {
			throw new IllegalArgumentException();
		}
		this.id = id;
		this.name = name;
		this.ingredientIds = ingredientIds;
		this.ingredientWeights = ingredientWeights;
		this.notes = notes;
		this.steps = steps;
		this.coolingLimit = coolingLimit;
		this.freezingLimit = freezingLimit;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Long> getIngredientIds() {
		return ingredientIds;
	}

	public List<Integer> getIngredientWeights() {
		return ingredientWeights;
	}

	public String getNotes() {
		return notes;
	}

	public String getSteps() {
		return steps;
	}

	public int getCoolingLimit() {
		return coolingLimit;
	}

	public int getFreezingLimit() {
		return freezingLimit;
	}

	public Map<Long, Integer> getIngredientsAndWeightsMap() {
		Map<Long, Integer> ingredientsAndWeightsMap = new HashMap<>();
		for (int i = 0, size = this.ingredientIds.size(); i < size; i++) {
			ingredientsAndWeightsMap.put(this.ingredientIds.get(i), this.ingredientWeights.get(i));
		}
		return ingredientsAndWeightsMap;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

	public void setIngredientIds(List<Long> ingredientIds) {
		if (ingredientIds == null) {
			throw new IllegalArgumentException();
		}
		this.ingredientIds = ingredientIds;
	}

	public void setIngredientWeights(List<Integer> ingredientWeights) {
		if (ingredientWeights == null) {
			throw new IllegalArgumentException();
		}
		this.ingredientWeights = ingredientWeights;
	}

	public void setNotes(String notes) {
		if (notes == null) {
			throw new IllegalArgumentException();
		}
		this.notes = notes;
	}

	public void setSteps(String steps) {
		if (steps == null) {
			throw new IllegalArgumentException();
		}
		this.steps = steps;
	}

	public void setCoolingLimit(int coolingLimit) {
		this.coolingLimit = coolingLimit;
	}

	public void setFreezingLimit(int freezingLimit) {
		this.freezingLimit = freezingLimit;
	}

	public void setIngredientsAndWeightsMap(Map<Long, Integer> ingredientAndWeightMap) {
		if (ingredientAndWeightMap == null) {
			throw new IllegalArgumentException();
		}
		this.ingredientIds = new ArrayList<>();
		this.ingredientWeights = new ArrayList<>();
		for (Map.Entry<Long, Integer> entry : ingredientAndWeightMap.entrySet()) {
			this.ingredientIds.add(entry.getKey());
			this.ingredientWeights.add(entry.getValue());
		}
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Recipe that)) return false;
		return id == that.id &&
				coolingLimit == that.coolingLimit &&
				freezingLimit == that.freezingLimit &&
				Objects.equals(name, that.name) &&
				Objects.equals(ingredientIds, that.ingredientIds) &&
				Objects.equals(ingredientWeights, that.ingredientWeights) &&
				Objects.equals(notes, that.notes) &&
				Objects.equals(steps, that.steps) &&
				Objects.equals(ingredientsAndWeightsMap, that.ingredientsAndWeightsMap);
	}

	@Override
	public int hashCode() {
		return Objects.hash(
				id,
				name,
				ingredientIds,
				ingredientWeights,
				notes,
				steps,
				coolingLimit,
				freezingLimit,
				ingredientsAndWeightsMap);
	}

	@Override
	public String toString() {
		return "RecipeDomain{" +
				"id=" + id +
				", name='" + name + '\'' +
				", ingredientIds=" + ingredientIds +
				", ingredientWeights=" + ingredientWeights +
				", notes='" + notes + '\'' +
				", steps='" + steps + '\'' +
				", coolingLimit=" + coolingLimit +
				", freezingLimit=" + freezingLimit +
				", ingredientsAndWeightsMap=" + ingredientsAndWeightsMap +
				'}';
	}
}
