package lgrimm.fooddesigner.volume.query.searchvolumes;

import lgrimm.fooddesigner.domain.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Component
public class SearchVolumesMapper {

	private SearchVolumesElement toSearchVolumesElement(VolumeEntity volumeEntity) {
		if (volumeEntity == null) {
			throw new IllegalArgumentException();
		}
		return new SearchVolumesElement(volumeEntity.getId(), volumeEntity.getName());
	}

	public SearchVolumesDTO toSearchVolumesDTO(List<VolumeEntity> volumeEntities, String message) {
		if (volumeEntities == null || message == null) {
			throw new IllegalArgumentException();
		}
		List<SearchVolumesElement> searchVolumesElements = volumeEntities.stream()
				.map(this::toSearchVolumesElement)
				.collect(Collectors.toList());
		return new SearchVolumesDTO(searchVolumesElements, "", message);
	}
}
