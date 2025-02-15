package lgrimm.fooddesigner.root;

import lgrimm.fooddesigner.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class RootService {

	private final RecipeRepository repository;
	private final RootMapper mapper;

	@Autowired
	public RootService(RecipeRepository repository, RootMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public RootDTO getRoot() {
		return mapper.toRootDTO(repository.findAll());
	}
}
