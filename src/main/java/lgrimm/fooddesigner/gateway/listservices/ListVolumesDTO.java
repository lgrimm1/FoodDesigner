package lgrimm.fooddesigner.gateway.listservices;

import java.util.*;

public class ListVolumesDTO {
	private final List<ListVolumesElement> volumes;
	private final String searchText;
	private final String message;

	public ListVolumesDTO(List<ListVolumesElement> volumes, String searchText, String message) {
		this.volumes = volumes;
		this.searchText = searchText;
		this.message = message;
	}

	public List<ListVolumesElement> getVolumes() {
		return volumes;
	}

	public String getSearchText() {
		return searchText;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ListVolumesDTO that)) return false;
		return Objects.equals(volumes, that.volumes) &&
				Objects.equals(searchText, that.searchText) &&
				Objects.equals(message, that.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(volumes, searchText, message);
	}

	@Override
	public String toString() {
		return "ListVolumesDTO{" +
				"volumes=" + volumes +
				", searchText='" + searchText + '\'' +
				", message='" + message + '\'' +
				'}';
	}
}
