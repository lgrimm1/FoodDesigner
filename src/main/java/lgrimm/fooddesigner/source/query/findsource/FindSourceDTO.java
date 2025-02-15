package lgrimm.fooddesigner.source.query.findsource;

import lgrimm.fooddesigner.domain.*;

import java.util.*;

public class FindSourceDTO {
	private final SourceEntity source;
	private final String message;

	public FindSourceDTO(SourceEntity source, String message) {
		this.source = source;
		this.message = message;
	}

	public SourceEntity getSource() {
		return source;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof FindSourceDTO that)) return false;
		return
				Objects.equals(source, that.source) &&
				Objects.equals(message, that.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(source, message);
	}

	@Override
	public String toString() {
		return "FindSourceDTO{" +
				"source=" + source +
				", message='" + message + '\'' +
				'}';
	}
}
