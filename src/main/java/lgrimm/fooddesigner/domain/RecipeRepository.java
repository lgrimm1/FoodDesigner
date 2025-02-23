package lgrimm.fooddesigner.domain;

import org.springframework.data.repository.*;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface RecipeRepository extends ListCrudRepository<RecipeEntity, Long> {

	List<RecipeEntity> findAllByName(String name);
}
