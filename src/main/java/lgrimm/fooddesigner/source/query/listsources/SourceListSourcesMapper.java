package lgrimm.fooddesigner.source.query.listsources;

import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

import lgrimm.fooddesigner.domain.*;

@Component
public class SourceListSourcesMapper {

	private ListSourcesElement toSourceEntityDTO(SourceEntity sourceEntity) {
		if (sourceEntity == null) {
			throw new IllegalArgumentException();
		}
		return new ListSourcesElement(sourceEntity.getId(), sourceEntity.getName());
	}

	public ListSourcesDTO toListSourcesDTO(List<SourceEntity> sourceEntities, String message) {
		if (sourceEntities == null || message == null) {
			throw new IllegalArgumentException();
		}
		List<ListSourcesElement> rootEntities = sourceEntities.stream()
				.map(this::toSourceEntityDTO)
				.collect(Collectors.toList());
		return new ListSourcesDTO(rootEntities, message);
	}
}
