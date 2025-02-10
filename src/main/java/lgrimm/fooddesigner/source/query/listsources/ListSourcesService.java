package lgrimm.fooddesigner.source.query.listsources;

import lgrimm.fooddesigner.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class ListSourcesService {
	private final SourceRepository repository;
	private final ListSourcesMapper mapper;

	@Autowired
	public ListSourcesService(SourceRepository repository, ListSourcesMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public ListSourcesDTO listSources() {
		return mapper.toListSourcesDTO(repository.findAll(), "");
	}
}
