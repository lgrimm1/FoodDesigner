package lgrimm.fooddesigner.domain;

import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface SourceRepository extends ListCrudRepository<SourceEntity, Long> {

	List<SourceEntity> findAllByName(String name);
}
