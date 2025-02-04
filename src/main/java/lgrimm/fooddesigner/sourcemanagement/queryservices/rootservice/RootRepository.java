package lgrimm.fooddesigner.sourcemanagement.queryservices.rootservice;

import lgrimm.fooddesigner.domains.*;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface RootRepository extends ListCrudRepository<Source, Long> {
}
