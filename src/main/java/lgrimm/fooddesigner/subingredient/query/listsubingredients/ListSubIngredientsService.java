package lgrimm.fooddesigner.subingredient.query.listsubingredients;

import lgrimm.fooddesigner.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class ListSubIngredientsService {
	private final SubIngredientRepository repository;
	private final ListSubIngredientsMapper mapper;

	@Autowired
	public ListSubIngredientsService(SubIngredientRepository repository, ListSubIngredientsMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public ListSubIngredientsDTO listSubIngredients() {
		return mapper.toListSubIngredientsDTO(repository.findAll());
	}
}
