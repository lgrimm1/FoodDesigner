package lgrimm.fooddesigner.domains;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SourceTest {

	@Test
	void constructors() {
		Source source = new Source();
		assertEquals(0, source.getId());
		assertNull(source.getName());
		assertNull(source.getWebShop());
		assertNull(source.getOpenHours());

		assertThrows(Exception.class, () -> new Source(null, "webshop", "open"));
		assertThrows(Exception.class, () -> new Source("name", null, "open"));
		assertThrows(Exception.class, () -> new Source("name", "webshop", null));

		source = new Source("name", "webshop", "open");
		assertEquals(0, source.getId());
		assertEquals("name", source.getName());
		assertEquals("webshop", source.getWebShop());
		assertEquals("open", source.getOpenHours());

		assertThrows(Exception.class, () -> new Source(12L, null, "webshop", "open"));
		assertThrows(Exception.class, () -> new Source(12L, "name", null, "open"));
		assertThrows(Exception.class, () -> new Source(12L, "name", "webshop", null));

		source = new Source(12L, "name", "webshop", "open");
		assertEquals(12L, source.getId());
		assertEquals("name", source.getName());
		assertEquals("webshop", source.getWebShop());
		assertEquals("open", source.getOpenHours());
	}

	@Test
	void setters() {
		Source source = new Source(12L, "name", "webshop", "open");

		assertThrows(Exception.class, () -> source.setName(null));
		assertThrows(Exception.class, () -> source.setWebShop(null));
		assertThrows(Exception.class, () -> source.setOpenHours(null));

		source.setId(-36L);
		source.setName("xxx");
		source.setWebShop("yyy");
		source.setOpenHours("zzz");

		assertEquals(-36L, source.getId());
		assertEquals("xxx", source.getName());
		assertEquals("yyy", source.getWebShop());
		assertEquals("zzz", source.getOpenHours());
	}
}