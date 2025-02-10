package lgrimm.fooddesigner.source.query.listsources;

import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

import lgrimm.fooddesigner.domain.*;

@Component
public class ListSourcesMapper {

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
		List<ListSourcesElement> listSourcesElements = sourceEntities.stream()
				.map(this::toListSourcesElement)
				.collect(Collectors.toList());
		return new ListSourcesDTO(listSourcesElements, message);
	}
}
