package lgrimm.fooddesigner.subingredient.query.searchsubingredients;

import lgrimm.fooddesigner.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Service
public class SearchSubIngredientsService {
	private final SubIngredientRepository repository;
	private final SearchSubIngredientsMapper mapper;

	@Autowired
	public SearchSubIngredientsService(SubIngredientRepository repository, SearchSubIngredientsMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	private String[] splitToWords(String text) {
		while (text.contains("  ")) {
			text = text.replace("  ", " ");
		}
		return text.split(" ");
	}

	public SearchSubIngredientsDTO searchSubIngredients(String text) {
		if (text == null) {
			throw new IllegalArgumentException();
		}
		if (text.isBlank()) {
			return new SearchSubIngredientsDTO(new ArrayList<>(), "", "No text were given.");
		}
		Set<Long> subIngredientEntityIds = repository.findAllByName(text.trim()).stream()
				.map(SubIngredientEntity::getId)
				.collect(Collectors.toSet());
		for (String word : splitToWords(text)) {
			repository.findAllByName(word).stream()
					.map(SubIngredientEntity::getId)
					.forEach(subIngredientEntityIds::add);
		}
		List<SubIngredientEntity> finalSubIngredientEntities = repository.findAllById(subIngredientEntityIds);
		return mapper.toSearchSubIngredientsDTO(finalSubIngredientEntities, "Found " + finalSubIngredientEntities.size() + " occurrence(s).");
	}
	
	public SearchSubIngredientsDTO listSubIngredients() {
		return mapper.toSearchSubIngredientsDTO(repository.findAll(), "Something went wrong, returned full list.");
	}
}
