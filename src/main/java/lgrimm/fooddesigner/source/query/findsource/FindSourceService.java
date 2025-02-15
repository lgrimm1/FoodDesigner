package lgrimm.fooddesigner.source.query.findsource;

import lgrimm.fooddesigner.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class FindSourceService {
	private final SourceRepository repository;
	private final FindSourceMapper mapper;

	@Autowired
	public FindSourceService(SourceRepository repository, FindSourceMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public FindSourceDTO findSource(long id) {
		Optional<SourceEntity> entity = repository.findById(id);
		if (entity.isPresent()) {
			return mapper.toFindSourcesDTO(entity.get(), "");
		}
		return mapper.toFindSourcesDTO(new SourceEntity(), "No such source was found.");
	}

	public ListSourcesDTO listSources(String message) {
		return mapper.toListSourcesDTO(repository.findAll(), message);
	}
}
