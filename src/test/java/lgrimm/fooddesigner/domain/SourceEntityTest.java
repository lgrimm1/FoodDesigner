package lgrimm.fooddesigner.domain;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SourceEntityTest {

	@Test
	void constructors() {
		SourceEntity sourceEntity = new SourceEntity();
		assertEquals(0, sourceEntity.getId());
		assertNull(sourceEntity.getName());
		assertNull(sourceEntity.getWebShop());
		assertNull(sourceEntity.getOpenHours());

		assertThrows(Exception.class, () -> new SourceEntity(null, "webshop", "open"));
		assertThrows(Exception.class, () -> new SourceEntity("name", null, "open"));
		assertThrows(Exception.class, () -> new SourceEntity("name", "webshop", null));

		sourceEntity = new SourceEntity("name", "webshop", "open");
		assertEquals(0, sourceEntity.getId());
		assertEquals("name", sourceEntity.getName());
		assertEquals("webshop", sourceEntity.getWebShop());
		assertEquals("open", sourceEntity.getOpenHours());

		assertThrows(Exception.class, () -> new SourceEntity(12L, null, "webshop", "open"));
		assertThrows(Exception.class, () -> new SourceEntity(12L, "name", null, "open"));
		assertThrows(Exception.class, () -> new SourceEntity(12L, "name", "webshop", null));

		sourceEntity = new SourceEntity(12L, "name", "webshop", "open");
		assertEquals(12L, sourceEntity.getId());
		assertEquals("name", sourceEntity.getName());
		assertEquals("webshop", sourceEntity.getWebShop());
		assertEquals("open", sourceEntity.getOpenHours());
	}

	@Test
	void setters() {
		SourceEntity sourceEntity = new SourceEntity(12L, "name", "webshop", "open");

		assertThrows(Exception.class, () -> sourceEntity.setName(null));
		assertThrows(Exception.class, () -> sourceEntity.setWebShop(null));
		assertThrows(Exception.class, () -> sourceEntity.setOpenHours(null));

		sourceEntity.setId(-36L);
		sourceEntity.setName("xxx");
		sourceEntity.setWebShop("yyy");
		sourceEntity.setOpenHours("zzz");

		assertEquals(-36L, sourceEntity.getId());
		assertEquals("xxx", sourceEntity.getName());
		assertEquals("yyy", sourceEntity.getWebShop());
		assertEquals("zzz", sourceEntity.getOpenHours());
	}
}