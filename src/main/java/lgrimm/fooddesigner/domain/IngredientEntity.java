package lgrimm.fooddesigner.domain;

import jakarta.persistence.*;

import java.io.*;
import java.util.*;

@Entity
@Table(name = "ingredient")
public class IngredientEntity implements Serializable {
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "ingredient_id_generator", sequenceName = "ingredient_id_generator", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_id_generator")
	private long id;
	@Column(name = "name", nullable = false, unique = true, columnDefinition = "TEXT")
	private String name;
	@Column(name = "subingredient_ids", nullable = false, unique = false)
	private List<Long> subIngredientIds;
	@Column(name = "extra_allergens", nullable = false, unique = false, columnDefinition = "TEXT")
	private String extraAllergens;
	@Column(name = "density", nullable = false, unique = false)
	private double density;
	@Column(name = "energy_kj", nullable = false, unique = false)
	private int energyKj;
	@Column(name = "energy_kcal", nullable = false, unique = false)
	private int energyKcal;
	@Column(name = "total_fats", nullable = false, unique = false)
	private double totalFats;
	@Column(name = "saturated_fats", nullable = false, unique = false)
	private double saturatedFats;
	@Column(name = "total_carbohydrates", nullable = false, unique = false)
	private double totalCarbohydrates;
	@Column(name = "sugars", nullable = false, unique = false)
	private double sugars;
	@Column(name = "fiber", nullable = false, unique = false)
	private double fiber;
	@Column(name = "proteins", nullable = false, unique = false)
	private double proteins;
	@Column(name = "salt", nullable = false, unique = false)
	private double salt;
	@Column(name = "p_source_id", nullable = false, unique = false)
	private long productSourceId;
	@Column(name = "p_name", nullable = false, unique = true, columnDefinition = "TEXT")
	private String productName;
	@Column(name = "p_manufacturer", nullable = false, unique = false, columnDefinition = "TEXT")
	private String productManufacturer;
	@Column(name = "p_description", nullable = false, unique = false, columnDefinition = "TEXT")
	private String productDescription;
	@Column(name = "p_weight", nullable = false, unique = false)
	private int productWeight;
	@Column(name = "p_gross_price", nullable = false, unique = false)
	private double productGrossPrice;
	@Column(name = "p_vat", nullable = false, unique = false)
	private double productVatPercent;

	public IngredientEntity() {
	}

	public IngredientEntity(
			String name,
			List<Long> subIngredientIds,
			String extraAllergens,
			double density,
			int energyKj,
			int energyKcal,
			double totalFats,
			double saturatedFats,
			double totalCarbohydrates,
			double sugars,
			double fiber,
			double proteins,
			double salt,
			long productSourceId,
			String productName,
			String productManufacturer,
			String productDescription,
			int productWeight,
			double productGrossPrice,
			double productVatPercent) {
		if (name == null ||
				subIngredientIds == null ||
				extraAllergens == null ||
				productName == null ||
				productManufacturer == null ||
				productDescription == null) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.subIngredientIds = subIngredientIds;
		this.extraAllergens = extraAllergens;
		this.density = density;
		this.energyKj = energyKj;
		this.energyKcal = energyKcal;
		this.totalFats = totalFats;
		this.saturatedFats = saturatedFats;
		this.totalCarbohydrates = totalCarbohydrates;
		this.sugars = sugars;
		this.fiber = fiber;
		this.proteins = proteins;
		this.salt = salt;
		this.productSourceId = productSourceId;
		this.productName = productName;
		this.productManufacturer = productManufacturer;
		this.productDescription = productDescription;
		this.productWeight = productWeight;
		this.productGrossPrice = productGrossPrice;
		this.productVatPercent = productVatPercent;
	}

	public IngredientEntity(
			long id,
			String name,
			List<Long> subIngredientIds,
			String extraAllergens,
			double density,
			int energyKj,
			int energyKcal,
			double totalFats,
			double saturatedFats,
			double totalCarbohydrates,
			double sugars,
			double fiber,
			double proteins,
			double salt,
			long productSourceId,
			String productName,
			String productManufacturer,
			String productDescription,
			int productWeight,
			double productGrossPrice,
			double productVatPercent) {
		if (name == null ||
				subIngredientIds == null ||
				extraAllergens == null ||
				productName == null ||
				productManufacturer == null ||
				productDescription == null) {
			throw new IllegalArgumentException();
		}
		this.id = id;
		this.name = name;
		this.subIngredientIds = subIngredientIds;
		this.extraAllergens = extraAllergens;
		this.density = density;
		this.energyKj = energyKj;
		this.energyKcal = energyKcal;
		this.totalFats = totalFats;
		this.saturatedFats = saturatedFats;
		this.totalCarbohydrates = totalCarbohydrates;
		this.sugars = sugars;
		this.fiber = fiber;
		this.proteins = proteins;
		this.salt = salt;
		this.productSourceId = productSourceId;
		this.productName = productName;
		this.productManufacturer = productManufacturer;
		this.productDescription = productDescription;
		this.productWeight = productWeight;
		this.productGrossPrice = productGrossPrice;
		this.productVatPercent = productVatPercent;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Long> getSubIngredientIds() {
		return subIngredientIds;
	}

	public String getExtraAllergens() {
		return extraAllergens;
	}

	public double getDensity() {
		return density;
	}

	public int getEnergyKj() {
		return energyKj;
	}

	public int getEnergyKcal() {
		return energyKcal;
	}

	public double getTotalFats() {
		return totalFats;
	}

	public double getSaturatedFats() {
		return saturatedFats;
	}

	public double getTotalCarbohydrates() {
		return totalCarbohydrates;
	}

	public double getSugars() {
		return sugars;
	}

	public double getFiber() {
		return fiber;
	}

	public double getProteins() {
		return proteins;
	}

	public double getSalt() {
		return salt;
	}

	public long getProductSourceId() {
		return productSourceId;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductManufacturer() {
		return productManufacturer;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public int getProductWeight() {
		return productWeight;
	}

	public double getProductGrossPrice() {
		return productGrossPrice;
	}

	public double getProductVatPercent() {
		return productVatPercent;
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

	public void setSubIngredientIds(List<Long> subIngredientIds) {
		if (subIngredientIds == null) {
			throw new IllegalArgumentException();
		}
		this.subIngredientIds = subIngredientIds;
	}

	public void setExtraAllergens(String extraAllergens) {
		if (extraAllergens == null) {
			throw new IllegalArgumentException();
		}
		this.extraAllergens = extraAllergens;
	}

	public void setDensity(double density) {
		this.density = density;
	}

	public void setEnergyKj(int energyKj) {
		this.energyKj = energyKj;
	}

	public void setEnergyKcal(int energyKcal) {
		this.energyKcal = energyKcal;
	}

	public void setTotalFats(double totalFats) {
		this.totalFats = totalFats;
	}

	public void setSaturatedFats(double saturatedFats) {
		this.saturatedFats = saturatedFats;
	}

	public void setTotalCarbohydrates(double totalCarbohydrates) {
		this.totalCarbohydrates = totalCarbohydrates;
	}

	public void setSugars(double sugars) {
		this.sugars = sugars;
	}

	public void setFiber(double fiber) {
		this.fiber = fiber;
	}

	public void setProteins(double proteins) {
		this.proteins = proteins;
	}

	public void setSalt(double salt) {
		this.salt = salt;
	}

	public void setProductSourceId(long productSourceId) {
		this.productSourceId = productSourceId;
	}

	public void setProductName(String productName) {
		if (productName == null) {
			throw new IllegalArgumentException();
		}
		this.productName = productName;
	}

	public void setProductManufacturer(String productManufacturer) {
		if (productManufacturer == null) {
			throw new IllegalArgumentException();
		}
		this.productManufacturer = productManufacturer;
	}

	public void setProductDescription(String productDescription) {
		if (productDescription == null) {
			throw new IllegalArgumentException();
		}
		this.productDescription = productDescription;
	}

	public void setProductWeight(int productWeight) {
		this.productWeight = productWeight;
	}

	public void setProductGrossPrice(double productGrossPrice) {
		this.productGrossPrice = productGrossPrice;
	}

	public void setProductVatPercent(double productVatPercent) {
		this.productVatPercent = productVatPercent;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof IngredientEntity that)) return false;
		return
				id == that.id &&
				Double.compare(density, that.density) == 0 &&
				energyKj == that.energyKj &&
				energyKcal == that.energyKcal &&
				Double.compare(totalFats, that.totalFats) == 0 &&
				Double.compare(saturatedFats, that.saturatedFats) == 0 &&
				Double.compare(totalCarbohydrates, that.totalCarbohydrates) == 0 &&
				Double.compare(sugars, that.sugars) == 0 &&
				Double.compare(fiber, that.fiber) == 0 &&
				Double.compare(proteins, that.proteins) == 0 &&
				Double.compare(salt, that.salt) == 0 &&
				productSourceId == that.productSourceId &&
				productWeight == that.productWeight &&
				Double.compare(productGrossPrice, that.productGrossPrice) == 0 &&
				Double.compare(productVatPercent, that.productVatPercent) == 0 &&
				Objects.equals(name, that.name) &&
				Objects.equals(subIngredientIds, that.subIngredientIds) &&
				Objects.equals(extraAllergens, that.extraAllergens) &&
				Objects.equals(productName, that.productName) &&
				Objects.equals(productManufacturer, that.productManufacturer) &&
				Objects.equals(productDescription, that.productDescription);
	}

	@Override
	public int hashCode() {
		return Objects.hash(
				id,
				name,
				subIngredientIds,
				extraAllergens,
				density,
				energyKj,
				energyKcal,
				totalFats,
				saturatedFats,
				totalCarbohydrates,
				sugars,
				fiber,
				proteins,
				salt,
				productSourceId,
				productName,
				productManufacturer,
				productDescription,
				productWeight,
				productGrossPrice,
				productVatPercent);
	}

	@Override
	public String toString() {
		return "IngredientEntity{" +
				"id=" + id +
				", name='" + name + '\'' +
				", subIngredientIds=" + subIngredientIds +
				", extraAllergens='" + extraAllergens + '\'' +
				", density=" + density +
				", energyKj=" + energyKj +
				", energyKcal=" + energyKcal +
				", totalFats=" + totalFats +
				", saturatedFats=" + saturatedFats +
				", totalCarbohydrates=" + totalCarbohydrates +
				", sugars=" + sugars +
				", fiber=" + fiber +
				", proteins=" + proteins +
				", salt=" + salt +
				", productSourceId=" + productSourceId +
				", productName='" + productName + '\'' +
				", productManufacturer='" + productManufacturer + '\'' +
				", productDescription='" + productDescription + '\'' +
				", productWeight=" + productWeight +
				", productGrossPrice=" + productGrossPrice +
				", productVat=" + productVatPercent +
				'}';
	}
}
