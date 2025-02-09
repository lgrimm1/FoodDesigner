package lgrimm.fooddesigner.root;

import lgrimm.fooddesigner.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Service
public class RootService {

	private final SourceRepository repository;
	private final SourceRootMapper mapper;

	@Autowired
	public RootService(SourceRepository repository, SourceRootMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public RootDTO getRoot() {
		return mapper.toRootDTO(repository.findAll(), "");
	}
}
