package lgrimm.fooddesigner.domain;

import org.springframework.data.repository.*;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends ListCrudRepository<RecipeEntity, Long> {
}
