package lgrimm.fooddesigner.domain;

import org.springframework.data.repository.*;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface VolumeRepository extends ListCrudRepository<VolumeEntity, Long> {

	List<VolumeEntity> findAllByName(String name);
}
