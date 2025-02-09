package lgrimm.fooddesigner.source.query.listsources;

import java.util.*;

public class ListSourcesDTO {
	private final List<ListSourcesElement> sources;
	private final String message;

	public ListSourcesDTO(List<ListSourcesElement> sources, String message) {
		this.sources = sources;
		this.message = message;
	}

	public List<ListSourcesElement> getSources() {
		return sources;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ListSourcesDTO rootDTO)) return false;
		return Objects.equals(sources, rootDTO.sources) &&
				Objects.equals(message, rootDTO.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(sources, message);
	}

	@Override
	public String toString() {
		return "ListSourcesDTO{" +
				"sources=" + sources +
				", message='" + message + '\'' +
				'}';
	}
}
