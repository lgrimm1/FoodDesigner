package lgrimm.fooddesigner.root;

import java.util.*;

public class RootDTO {
	private final List<RootElement> sources;
	private final String message;

	public RootDTO(List<RootElement> sources, String message) {
		this.sources = sources;
		this.message = message;
	}

	public List<RootElement> getSources() {
		return sources;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof RootDTO rootDTO)) return false;
		return Objects.equals(sources, rootDTO.sources) &&
				Objects.equals(message, rootDTO.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(sources, message);
	}

	@Override
	public String toString() {
		return "RootDTO{" +
				"sources=" + sources +
				", message='" + message + '\'' +
				'}';
	}
}
