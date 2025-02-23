package lgrimm.fooddesigner.volume.query.searchvolumes;

import lgrimm.fooddesigner.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Service
public class SearchVolumesService {
	private final VolumeRepository repository;
	private final SearchVolumesMapper mapper;

	@Autowired
	public SearchVolumesService(VolumeRepository repository, SearchVolumesMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	private String[] splitToWords(String text) {
		while (text.contains("  ")) {
			text = text.replace("  ", " ");
		}
		return text.split(" ");
	}

	public SearchVolumesDTO searchVolumes(String text) {
		if (text == null) {
			throw new IllegalArgumentException();
		}
		if (text.isBlank()) {
			return new SearchVolumesDTO(new ArrayList<SearchVolumesElement>(), "", "No text were given.");
		}
		Set<Long> volumeEntityIds = repository.findAllByName(text.trim()).stream()
				.map(VolumeEntity::getId)
				.collect(Collectors.toSet());
		for (String word : splitToWords(text)) {
			repository.findAllByName(word).stream()
					.map(VolumeEntity::getId)
					.forEach(volumeEntityIds::add);
		}
		List<VolumeEntity> finalVolumeEntities = repository.findAllById(volumeEntityIds);
		return mapper.toSearchVolumesDTO(finalVolumeEntities, "Found " + finalVolumeEntities.size() + " occurrence(s).");
	}

	public SearchVolumesDTO listVolumes() {
		return mapper.toSearchVolumesDTO(repository.findAll(), "Something went wrong, returned full list.");
	}
}
