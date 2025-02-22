package lgrimm.fooddesigner.ingredient.query.searchingredients;

import lgrimm.fooddesigner.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Service
public class SearchIngredientsService {
	private final IngredientRepository repository;
	private final SearchIngredientsMapper mapper;

	@Autowired
	public SearchIngredientsService(IngredientRepository repository, SearchIngredientsMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	private String[] splitToWords(String text) {
		while (text.contains("  ")) {
			text = text.replace("  ", " ");
		}
		return text.split(" ");
	}

	public SearchIngredientsDTO searchIngredients(String text) {
		if (text == null) {
			throw new IllegalArgumentException();
		}
		if (text.isBlank()) {
			return new SearchIngredientsDTO(new ArrayList<SearchIngredientsElement>(), "", "No text were given.");
		}
		Set<Long> ingredientEntityIds = repository.findAllByName(text.trim()).stream()
				.map(IngredientEntity::getId)
				.collect(Collectors.toSet());
		for (String word : splitToWords(text)) {
			repository.findAllByName(word).stream()
					.map(IngredientEntity::getId)
					.forEach(ingredientEntityIds::add);
		}
		List<IngredientEntity> finalIngredientEntities = repository.findAllById(ingredientEntityIds);
		return mapper.toSearchIngredientsDTO(finalIngredientEntities, "Found " + finalIngredientEntities.size() + " occurrence(s).");
	}

	public SearchIngredientsDTO listIngredients() {
		return mapper.toSearchIngredientsDTO(repository.findAll(), "Something went wrong, returned full list.");
	}
}
