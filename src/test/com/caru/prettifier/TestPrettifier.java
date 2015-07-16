package com.caru.prettifier;

import static org.junit.Assert.*;

import org.junit.Test;

import com.caru.prettifier.Main;

public class TestPrettifier {

	@Test
	// Number lower than a million
	public void testLowerThanMillion() {
		assertEquals("123456", Main.prettifieNumber("123456"));
	}

	@Test
	// Truncate decimal of number lower than a million
	public void testLowerThanMillion_Decimal() {
		assertEquals("123456.1", Main.prettifieNumber("123456.123"));
	}

	@Test
	// One million
	public void testMillion() {
		assertEquals("1M", Main.prettifieNumber("1000000"));
	}

	@Test
	// One Billion
	public void testBilion() {
		assertEquals("1B", Main.prettifieNumber("1000000000"));
	}

	@Test
	// One Trillion
	public void testTrilion() {
		assertEquals("1T", Main.prettifieNumber("1000000000000"));
	}
	
	@Test
	// Truncate million decimal
	public void testMillion_() {
		assertEquals("1.2M", Main.prettifieNumber("1234500"));
	}
	
	@Test
	// 123 Trillions
	public void testTrilion_() {
		assertEquals("123T", Main.prettifieNumber("123000000000000"));
	}

	@Test
	// 123 Billions and decimal
	public void testBilion_Decimal() {
		assertEquals("123B", Main.prettifieNumber("123000000000.12"));
	}

	@Test
	// Number with 16 digits
	public void testBiggerTrillion() {
		assertEquals("1234T", Main.prettifieNumber("1234000000000000"));
	}

	@Test
	// Negative number
	public void testNegativeNumber() {
		assertEquals("-1M", Main.prettifieNumber("-1000000"));
	}

}
