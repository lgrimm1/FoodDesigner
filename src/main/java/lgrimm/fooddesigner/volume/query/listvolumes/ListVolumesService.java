package lgrimm.fooddesigner.volume.query.listvolumes;

import lgrimm.fooddesigner.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class ListVolumesService {
	private final VolumeRepository repository;
	private final ListVolumesMapper mapper;

	@Autowired
	public ListVolumesService(VolumeRepository repository, ListVolumesMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public ListVolumesDTO listVolumes() {
		return mapper.toListVolumesDTO(repository.findAll());
	}
}
