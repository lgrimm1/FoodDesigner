package lgrimm.fooddesigner.source.query.searchsources;

import java.util.*;

public class SearchSourcesDTO {
	private final List<SearchSourcesElement> sources;
	private final String message;

	public SearchSourcesDTO(List<SearchSourcesElement> sources, String message) {
		this.sources = sources;
		this.message = message;
	}

	public List<SearchSourcesElement> getSources() {
		return sources;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof SearchSourcesDTO that)) return false;
		return
				Objects.equals(sources, that.sources) &&
				Objects.equals(message, that.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(sources, message);
	}

	@Override
	public String toString() {
		return "SearchSourcesDTO{" +
				"sources=" + sources +
				", message='" + message + '\'' +
				'}';
	}
}
