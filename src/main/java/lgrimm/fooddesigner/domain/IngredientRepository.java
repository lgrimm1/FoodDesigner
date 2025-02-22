package lgrimm.fooddesigner.domain;

import org.springframework.data.repository.*;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface IngredientRepository extends ListCrudRepository<IngredientEntity, Long> {

	List<IngredientEntity> findAllByName(String name);
}
