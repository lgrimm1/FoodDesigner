package lgrimm.fooddesigner.source.query.listsources;

import lgrimm.fooddesigner.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Service
public class ListSourcesService {
	private final SourceRepository repository;
	private final SourceListSourcesMapper mapper;

	@Autowired
	public ListSourcesService(SourceRepository repository, SourceListSourcesMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public ListSourcesDTO listSources() {
		return mapper.toListSourcesDTO(repository.findAll(), "");
	}
}
