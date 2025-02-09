package lgrimm.fooddesigner.root;

import lgrimm.fooddesigner.domain.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Component
public class SourceRootMapper {

	private RootElement toSourceEntityDTO(SourceEntity sourceEntity) {
		if (sourceEntity == null) {
			throw new IllegalArgumentException();
		}
		return new RootElement(sourceEntity.getId(), sourceEntity.getName());
	}

	private SourceEntity toSourceEntity(RootElement rootElement) {
		if (rootElement == null) {
			throw new IllegalArgumentException();
		}
		return new SourceEntity(rootElement.sourceId(), rootElement.sourceName(), "", "");
	}

	public RootDTO toRootDTO(List<SourceEntity> sourceEntities, String message) {
		if (sourceEntities == null || message == null) {
			throw new IllegalArgumentException();
		}
		List<RootElement> rootEntities = sourceEntities.stream()
				.map(this::toSourceEntityDTO)
				.collect(Collectors.toList());
		return new RootDTO(rootEntities, message);
	}
}
