package lgrimm.fooddesigner.domain;

import jakarta.persistence.*;

import java.io.*;
import java.util.*;

@Entity
@Table(name = "sub_ingredient")
public class SubIngredientEntity implements Serializable {
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "subingredient_id_generator", sequenceName = "subingredient_id_generator", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subingredient_id_generator")
	private long id;
	@Column(name = "name", nullable = false, unique = true, columnDefinition = "TEXT")
	private String name;
	@Column(name = "allergen", nullable = false, unique = false, columnDefinition = "TEXT")
	private String allergen;

	public SubIngredientEntity() {
	}

	public SubIngredientEntity(
			String name,
			String allergen) {
		if (name == null || allergen == null) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.allergen = allergen;
	}

	public SubIngredientEntity(
			long id,
			String name,
			String allergen) {
		if (name == null || allergen == null) {
			throw new IllegalArgumentException();
		}
		this.id = id;
		this.name = name;
		this.allergen = allergen;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAllergen() {
		return allergen;
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

	public void setAllergen(String allergen) {
		if (allergen == null) {
			throw new IllegalArgumentException();
		}
		this.allergen = allergen;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof SubIngredientEntity that)) return false;
		return
				id == that.id &&
				Objects.equals(name, that.name) &&
				Objects.equals(allergen, that.allergen);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, allergen);
	}

	@Override
	public String toString() {
		return "SubIngredientEntity{" +
				"id=" + id +
				", name='" + name + '\'' +
				", allergen='" + allergen + '\'' +
				'}';
	}
}
