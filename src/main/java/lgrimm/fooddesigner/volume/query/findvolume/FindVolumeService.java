package lgrimm.fooddesigner.volume.query.findvolume;

import lgrimm.fooddesigner.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class FindVolumeService {
	private final VolumeRepository repository;
	private final FindVolumeMapper mapper;

	@Autowired
	public FindVolumeService(VolumeRepository repository, FindVolumeMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public FindVolumeDTO findVolume(long id) {
		Optional<VolumeEntity> entity = repository.findById(id);
		if (entity.isPresent()) {
			return mapper.toFindVolumeDTO(entity.get(), "");
		}
		return mapper.toFindVolumeDTO(new VolumeEntity(), "No such volume was found.");
	}

	public ListVolumesDTO listVolumes(String message) {
		return mapper.toListVolumesDTO(repository.findAll(), message);
	}
}
