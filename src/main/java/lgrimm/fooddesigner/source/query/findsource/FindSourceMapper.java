package lgrimm.fooddesigner.source.query.findsource;

import lgrimm.fooddesigner.domain.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Component
public class FindSourceMapper {
	public FindSourceDTO toFindSourceDTO(SourceEntity sourceEntity, String message) {
		if (sourceEntity == null || message == null) {
			throw new IllegalArgumentException();
		}
		return new FindSourceDTO(sourceEntity, message);
	}

	private ListSourcesElement toListSourcesElement(SourceEntity sourceEntity) {
		if (sourceEntity == null) {
			throw new IllegalArgumentException();
		}
		return new ListSourcesElement(sourceEntity.getId(), sourceEntity.getName());
	}

	public ListSourcesDTO toListSourcesDTO(List<SourceEntity> sourceEntities, String message) {
		if (sourceEntities == null || message == null) {
			throw new IllegalArgumentException();
		}
		List<ListSourcesElement> listRecipesElements = sourceEntities.stream()
				.map(this::toListSourcesElement)
				.collect(Collectors.toList());
		return new ListSourcesDTO(listRecipesElements, message);
	}
}
