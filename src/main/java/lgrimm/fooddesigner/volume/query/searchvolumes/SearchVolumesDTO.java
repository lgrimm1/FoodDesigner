package lgrimm.fooddesigner.volume.query.searchvolumes;

import java.util.*;

public class SearchVolumesDTO {
	private final List<SearchVolumesElement> volumes;
	private final String searchText;
	private final String message;

	public SearchVolumesDTO(
			List<SearchVolumesElement> volumes,
			String searchText,
			String message) {
		this.volumes = volumes;
		this.searchText = searchText;
		this.message = message;
	}

	public List<SearchVolumesElement> getVolumes() {
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
		if (!(o instanceof SearchVolumesDTO that)) return false;
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
		return "SearchVolumesDTO{" +
				"volumes=" + volumes +
				", searchText='" + searchText + '\'' +
				", message='" + message + '\'' +
				'}';
	}
}
