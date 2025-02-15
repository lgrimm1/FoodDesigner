package lgrimm.fooddesigner.source.query.searchsources;

import lgrimm.fooddesigner.domain.*;
import lgrimm.fooddesigner.source.query.listsources.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Service
public class SearchSourcesService {
	private final SourceRepository repository;
	private final SearchSourcesMapper mapper;

	@Autowired
	public SearchSourcesService(SourceRepository repository, SearchSourcesMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	private String[] splitToWords(String text) {
		while (text.contains("  ")) {
			text = text.replace("  ", " ");
		}
		return text.split(" ");
	}

	public SearchSourcesDTO searchSources(String text) {
		if (text == null) {
			throw new IllegalArgumentException();
		}
		if (text.isBlank()) {
			return new SearchSourcesDTO(new ArrayList<SearchSourcesElement>(), "", "No text were given.");
		}
		Set<Long> sourceEntityIds = repository.findAllByName(text.trim()).stream()
				.map(SourceEntity::getId)
				.collect(Collectors.toSet());
		for (String word : splitToWords(text)) {
			repository.findAllByName(word).stream()
					.map(SourceEntity::getId)
					.forEach(sourceEntityIds::add);
		}
		List<SourceEntity> finalSourceEntities = repository.findAllById(sourceEntityIds);
		return mapper.toSearchSourcesDTO(finalSourceEntities, "Found " + finalSourceEntities.size() + " occurrence(s).");
	}

	public SearchSourcesDTO listSources() {
		return mapper.toSearchSourcesDTO(repository.findAll(), "Something went wrong, returned full list.");
	}
}
