package lgrimm.fooddesigner.gateway.listservices;

import java.util.*;

public class ListSourcesDTO {
	private final List<ListSourcesElement> sources;
	private final String searchText;
	private final String message;

	public ListSourcesDTO(
			List<ListSourcesElement> sources,
			String searchText,
			String message) {
		this.sources = sources;
		this.searchText = searchText;
		this.message = message;
	}

	public List<ListSourcesElement> getSources() {
		return sources;
	}

	public String getSearchText() {
		return searchText;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ListSourcesDTO that)) return false;
		return Objects.equals(sources, that.sources) &&
				Objects.equals(searchText, that.searchText) &&
				Objects.equals(message, that.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(sources, searchText, message);
	}

	@Override
	public String toString() {
		return "ListSourcesDTO{" +
				"sources=" + sources +
				", searchText='" + searchText + '\'' +
				", message='" + message + '\'' +
				'}';
	}
}
