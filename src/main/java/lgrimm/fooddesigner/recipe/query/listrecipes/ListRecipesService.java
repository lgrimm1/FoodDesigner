package lgrimm.fooddesigner.recipe.query.listrecipes;

import lgrimm.fooddesigner.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class ListRecipesService {
	private final RecipeRepository repository;
	private final ListRecipesMapper mapper;

	@Autowired
	public ListRecipesService(RecipeRepository repository, ListRecipesMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public ListRecipesDTO listRecipes() {
		return mapper.toListRecipesDTO(repository.findAll());
	}
}
