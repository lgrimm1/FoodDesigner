package lgrimm.fooddesigner.domains;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class VolumeTest {

	@Test
	void contructors() {
		Volume volume = new Volume();
		assertEquals(0, volume.getId());
		assertNull(volume.getName());
		assertEquals(0D, volume.getValue());

		assertThrows(Exception.class, () -> new Volume(null, 12.3D));

		volume = new Volume("name", 12.3D);
		assertEquals(0, volume.getId());
		assertEquals("name", volume.getName());
		assertEquals(12.3D, volume.getValue());

		assertThrows(Exception.class, () -> new Volume(12L, null, 123.4D));

		volume = new Volume(12L, "name", 123.4D);
		assertEquals(12L, volume.getId());
		assertEquals("name", volume.getName());
		assertEquals(123.4D, volume.getValue());
	}

	@Test
	void setters() {
		Volume volume = new Volume(12L, "name", 123.4D);

		assertThrows(Exception.class, () -> volume.setName(null));

		volume.setId(555L);
		volume.setName("aaa");
		volume.setValue(987.6D);
		assertEquals(555L, volume.getId());
		assertEquals("aaa", volume.getName());
		assertEquals(987.6D, volume.getValue());
	}
}