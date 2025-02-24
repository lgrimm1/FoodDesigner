package lgrimm.fooddesigner.volume.query.findvolume;

import lgrimm.fooddesigner.domain.*;

import java.util.*;

public class FindVolumeDTO {
	private final VolumeEntity volume;
	private final String message;

	public FindVolumeDTO(VolumeEntity volume, String message) {
		this.volume = volume;
		this.message = message;
	}

	public VolumeEntity getVolume() {
		return volume;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof lgrimm.fooddesigner.volume.query.findvolume.FindVolumeDTO that)) return false;
		return
				Objects.equals(volume, that.volume) &&
						Objects.equals(message, that.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(volume, message);
	}

	@Override
	public String toString() {
		return "FindVolumeDTO{" +
				"volume=" + volume +
				", message='" + message + '\'' +
				'}';
	}
}
