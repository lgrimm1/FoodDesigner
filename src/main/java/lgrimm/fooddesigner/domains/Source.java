package lgrimm.fooddesigner.domains;

import jakarta.persistence.*;

import java.io.*;
import java.util.*;

@Entity
@Table(name = "source")
public class Source implements Serializable {
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "source_id_generator", sequenceName = "source_id_generator", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "source_id_generator")
	private long id;
	@Column(name = "name", nullable = false, unique = true, columnDefinition = "TEXT")
	private String name;
	@Column(name = "webshop", nullable = false, unique = false, columnDefinition = "TEXT")
	private String webShop;
	@Column(name = "open", nullable = false, unique = false, columnDefinition = "TEXT")
	private String openHours;

	public Source() {
	}

	public Source(
			String name,
			String webShop,
			String openHours) {
		if (name == null || webShop == null || openHours == null) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.webShop = webShop;
		this.openHours = openHours;
	}

	public Source(
			long id,
			String name,
			String webShop,
			String openHours) {
		if (name == null || webShop == null || openHours == null) {
			throw new IllegalArgumentException();
		}
		this.id = id;
		this.name = name;
		this.webShop = webShop;
		this.openHours = openHours;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getWebShop() {
		return webShop;
	}

	public String getOpenHours() {
		return openHours;
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

	public void setWebShop(String webShop) {
		if (webShop == null) {
			throw new IllegalArgumentException();
		}
		this.webShop = webShop;
	}

	public void setOpenHours(String openHours) {
		if (openHours == null) {
			throw new IllegalArgumentException();
		}
		this.openHours = openHours;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Source that)) return false;
		return id == that.id && Objects.equals(name, that.name) && Objects.equals(webShop, that.webShop) && Objects.equals(openHours, that.openHours);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, webShop, openHours);
	}

	@Override
	public String toString() {
		return "SourceDomain{" +
				"id=" + id +
				", name='" + name + '\'' +
				", webshop='" + webShop + '\'' +
				", open='" + openHours + '\'' +
				'}';
	}
}
