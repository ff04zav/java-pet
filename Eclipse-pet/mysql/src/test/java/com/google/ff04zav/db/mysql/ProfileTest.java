package com.google.ff04zav.db.mysql;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ProfileTest {

	@Test
	public void testLoadDbConfig() {
		var props = new Profile().getProperties("db");
		assertNotNull("cannot load properties", props);
		
		var dbName = props.getProperty("database");
		assertEquals("dbName incorrect", "peopletest", dbName);
	}
}
