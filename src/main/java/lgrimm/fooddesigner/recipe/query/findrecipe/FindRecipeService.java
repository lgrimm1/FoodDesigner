package lgrimm.fooddesigner.recipe.query.findrecipe;

import lgrimm.fooddesigner.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class FindRecipeService {
	private final RecipeRepository repository;
	private final FindRecipeMapper mapper;

	@Autowired
	public FindRecipeService(RecipeRepository repository, FindRecipeMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public FindRecipeDTO findRecipe(long id) {
		Optional<RecipeEntity> entity = repository.findById(id);
		if (entity.isPresent()) {
			return mapper.toFindRecipeDTO(entity.get(), "");
		}
		return mapper.toFindRecipeDTO(new RecipeEntity(), "No such recipe was found.");
	}

	public ListRecipesDTO listRecipes(String message) {
		return mapper.toListRecipesDTO(repository.findAll(), message);
	}
}
