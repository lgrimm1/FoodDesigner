package lgrimm.fooddesigner.domains;

import jakarta.persistence.*;

import java.io.*;
import java.util.*;

@Entity
@Table(name = "volume")
public class Volume implements Serializable {
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "volume_id_generator", sequenceName = "volume_id_generator", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "volume_id_generator")
	private long id;
	@Column(name = "name", nullable = false, unique = true, columnDefinition = "TEXT")
	private String name;
	@Column(name = "value", nullable = false, unique = false)
	private double value;

	public Volume() {
	}

	public Volume(String name, double value) {
		if (name == null) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.value = value;
	}

	public Volume(long id, String name, double value) {
		if (name == null) {
			throw new IllegalArgumentException();
		}
		this.id = id;
		this.name = name;
		this.value = value;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getValue() {
		return value;
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

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Volume that)) return false;
		return id == that.id &&
				Double.compare(value, that.value) == 0 &&
				Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, value);
	}

	@Override
	public String toString() {
		return "VolumeDomain{" +
				"id=" + id +
				", name='" + name + '\'' +
				", value=" + value +
				'}';
	}
}
