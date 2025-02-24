package lgrimm.fooddesigner.volume.query.findvolume;

import lgrimm.fooddesigner.domain.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Component
public class FindVolumeMapper {
	public FindVolumeDTO toFindVolumeDTO(VolumeEntity volumeEntity, String message) {
		if (volumeEntity == null || message == null) {
			throw new IllegalArgumentException();
		}
		return new FindVolumeDTO(volumeEntity, message);
	}

	private ListVolumesElement toListVolumesElement(VolumeEntity volumeEntity) {
		if (volumeEntity == null) {
			throw new IllegalArgumentException();
		}
		return new ListVolumesElement(volumeEntity.getId(), volumeEntity.getName());
	}

	public ListVolumesDTO toListVolumesDTO(List<VolumeEntity> volumeEntities, String message) {
		if (volumeEntities == null || message == null) {
			throw new IllegalArgumentException();
		}
		List<ListVolumesElement> listRecipesElements = volumeEntities.stream()
				.map(this::toListVolumesElement)
				.collect(Collectors.toList());
		return new ListVolumesDTO(listRecipesElements, message);
	}
}
