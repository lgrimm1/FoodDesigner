package lgrimm.fooddesigner.volume.query.findvolume;

import java.util.*;

public class ListVolumesDTO {
	private final List<ListVolumesElement> volumes;
	private final String message;

	public ListVolumesDTO(List<ListVolumesElement> volumes, String message) {
		this.volumes = volumes;
		this.message = message;
	}

	public List<ListVolumesElement> getVolumes() {
		return volumes;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof lgrimm.fooddesigner.volume.query.findvolume.ListVolumesDTO rootDTO)) return false;
		return Objects.equals(volumes, rootDTO.volumes) &&
				Objects.equals(message, rootDTO.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(volumes, message);
	}

	@Override
	public String toString() {
		return "ListVolumesDTO{" +
				"volumes=" + volumes +
				", message='" + message + '\'' +
				'}';
	}
}
