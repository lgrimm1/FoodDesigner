package lgrimm.fooddesigner.domain;

import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceRepository extends ListCrudRepository<SourceEntity, Long> {
}
