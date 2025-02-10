package lgrimm.fooddesigner.domain;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class VolumeEntityTest {

	@Test
	void contructors() {
		VolumeEntity volumeEntity = new VolumeEntity();
		assertEquals(0, volumeEntity.getId());
		assertNull(volumeEntity.getName());
		assertEquals(0D, volumeEntity.getValue());

		assertThrows(Exception.class, () -> new VolumeEntity(null, 12.3D));

		volumeEntity = new VolumeEntity("name", 12.3D);
		assertEquals(0, volumeEntity.getId());
		assertEquals("name", volumeEntity.getName());
		assertEquals(12.3D, volumeEntity.getValue());

		assertThrows(Exception.class, () -> new VolumeEntity(12L, null, 123.4D));

		volumeEntity = new VolumeEntity(12L, "name", 123.4D);
		assertEquals(12L, volumeEntity.getId());
		assertEquals("name", volumeEntity.getName());
		assertEquals(123.4D, volumeEntity.getValue());
	}

	@Test
	void setters() {
		VolumeEntity volumeEntity = new VolumeEntity(12L, "name", 123.4D);

		assertThrows(Exception.class, () -> volumeEntity.setName(null));

		volumeEntity.setId(555L);
		volumeEntity.setName("aaa");
		volumeEntity.setValue(987.6D);
		assertEquals(555L, volumeEntity.getId());
		assertEquals("aaa", volumeEntity.getName());
		assertEquals(987.6D, volumeEntity.getValue());
	}
}