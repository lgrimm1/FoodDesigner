package lgrimm.fooddesigner.recipe.query.searchrecipes;

import lgrimm.fooddesigner.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Service
public class SearchRecipesService {
	private final RecipeRepository repository;
	private final SearchRecipesMapper mapper;

	@Autowired
	public SearchRecipesService(RecipeRepository repository, SearchRecipesMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	private String[] splitToWords(String text) {
		while (text.contains("  ")) {
			text = text.replace("  ", " ");
		}
		return text.split(" ");
	}

	public SearchRecipesDTO searchRecipes(String text) {
		if (text == null) {
			throw new IllegalArgumentException();
		}
		if (text.isBlank()) {
			return new SearchRecipesDTO(new ArrayList<SearchRecipesElement>(), "", "No text were given.");
		}
		Set<Long> recipeEntityIds = repository.findAllByName(text.trim()).stream()
				.map(RecipeEntity::getId)
				.collect(Collectors.toSet());
		for (String word : splitToWords(text)) {
			repository.findAllByName(word).stream()
					.map(RecipeEntity::getId)
					.forEach(recipeEntityIds::add);
		}
		List<RecipeEntity> finalRecipeEntities = repository.findAllById(recipeEntityIds);
		return mapper.toSearchRecipesDTO(finalRecipeEntities, "Found " + finalRecipeEntities.size() + " occurrence(s).");
	}

	public SearchRecipesDTO listRecipes() {
		return mapper.toSearchRecipesDTO(repository.findAll(), "Something went wrong, returned full list.");
	}
}
