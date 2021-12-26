package test;

import java.sql.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class DateTest {

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		String brith = "2022-12-01";
		Date date = Date.valueOf(brith);
		System.out.println(date);
	}

}
