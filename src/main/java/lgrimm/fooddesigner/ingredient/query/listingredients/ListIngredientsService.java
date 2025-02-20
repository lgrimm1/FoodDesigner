package lgrimm.fooddesigner.ingredient.query.listingredients;

import lgrimm.fooddesigner.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class ListIngredientsService {
	private final IngredientRepository repository;
	private final ListIngredientsMapper mapper;

	@Autowired
	public ListIngredientsService(IngredientRepository repository, ListIngredientsMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public ListIngredientsDTO listIngredients() {
		return mapper.toListIngredientsDTO(repository.findAll());
	}
}
