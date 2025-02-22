package lgrimm.fooddesigner.volume.query.listvolumes;

import lgrimm.fooddesigner.domain.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Component
public class ListVolumesMapper {

	private ListVolumesElement toListVolumentsElement(VolumeEntity volumeEntity) {
		if (volumeEntity == null) {
			throw new IllegalArgumentException();
		}
		return new ListVolumesElement(volumeEntity.getId(), volumeEntity.getName());
	}

	public ListVolumesDTO toListVolumesDTO(List<VolumeEntity> volumeEntities) {
		if (volumeEntities == null) {
			throw new IllegalArgumentException();
		}
		List<ListVolumesElement> listVolumesElements = volumeEntities.stream()
				.map(this::toListVolumentsElement)
				.collect(Collectors.toList());
		return new ListVolumesDTO(listVolumesElements, "", "");
	}
}
