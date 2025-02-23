package lgrimm.fooddesigner.subingredient.query.findsubingredient;

import lgrimm.fooddesigner.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class FindSubIngredientService {
	private final SubIngredientRepository repository;
	private final FindSubIngredientMapper mapper;

	@Autowired
	public FindSubIngredientService(SubIngredientRepository repository, FindSubIngredientMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public FindSubIngredientDTO findSubIngredient(long id) {
		Optional<SubIngredientEntity> entity = repository.findById(id);
		if (entity.isPresent()) {
			return mapper.toFindSubIngredientDTO(entity.get(), "");
		}
		return mapper.toFindSubIngredientDTO(new SubIngredientEntity(), "No such subIngredient was found.");
	}

	public ListSubIngredientsDTO listSubIngredients(String message) {
		return mapper.toListSubIngredientsDTO(repository.findAll(), message);
	}
}
