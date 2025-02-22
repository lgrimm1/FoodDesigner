package lgrimm.fooddesigner.domain;

import org.springframework.data.repository.*;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface SubIngredientRepository extends ListCrudRepository<SubIngredientEntity, Long> {

	List<SubIngredientEntity> findAllByName(String name);
}
