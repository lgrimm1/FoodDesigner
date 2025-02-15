package lgrimm.fooddesigner.source.query.searchsources;

import lgrimm.fooddesigner.domain.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Component
public class SearchSourcesMapper {

	private SearchSourcesElement toSearchSourcesElement(SourceEntity sourceEntity) {
		if (sourceEntity == null) {
			throw new IllegalArgumentException();
		}
		return new SearchSourcesElement(sourceEntity.getId(), sourceEntity.getName());
	}

	public SearchSourcesDTO toSearchSourcesDTO(List<SourceEntity> sourceEntities, String message) {
		if (sourceEntities == null || message == null) {
			throw new IllegalArgumentException();
		}
		List<SearchSourcesElement> searchSourcesElements = sourceEntities.stream()
				.map(this::toSearchSourcesElement)
				.collect(Collectors.toList());
		return new SearchSourcesDTO(searchSourcesElements, "", message);
	}
}
