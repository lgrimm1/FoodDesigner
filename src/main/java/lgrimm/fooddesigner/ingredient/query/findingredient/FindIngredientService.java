package lgrimm.fooddesigner.ingredient.query.findingredient;

import lgrimm.fooddesigner.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class FindIngredientService {
	private final IngredientRepository repository;
	private final FindIngredientMapper mapper;

	@Autowired
	public FindIngredientService(IngredientRepository repository, FindIngredientMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public FindIngredientDTO findIngredient(long id) {
		Optional<IngredientEntity> entity = repository.findById(id);
		if (entity.isPresent()) {
			return mapper.toFindIngredientDTO(entity.get(), "");
		}
		return mapper.toFindIngredientDTO(new IngredientEntity(), "No such ingredient was found.");
	}

	public ListIngredientsDTO listIngredients(String message) {
		return mapper.toListIngredientsDTO(repository.findAll(), message);
	}
}
