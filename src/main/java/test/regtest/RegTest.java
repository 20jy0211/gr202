package test.regtest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class RegTest {
	String patternNum = "^[0-9]*$";
	String patternEmail = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
	String patternSpace = "\\s";
	String patternString = "^[A-Za-z0-9]{0,50}$";
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		System.out.println("111".matches(patternNum));
		System.out.println("111".matches(patternEmail));
		System.out.println("111 ".matches(patternSpace));
		System.out.println("1dd11".matches(patternString));
	}

}
