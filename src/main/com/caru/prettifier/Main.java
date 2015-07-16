package com.caru.prettifier;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Main {

	final private static char[] millionChar = { 'M', 'B', 'T' };

	/**
	 * Prettifier of the number. Truncate the number and return a prittier
	 * string with the number.
	 * 
	 * @param number
	 *            The number to prettifie represented as a String.
	 * 
	 */
	static public String prettifieNumber(String number) {
		int count = 0;
		String stringResult;
		Double doubleNumber = Double.valueOf(number);
		Double temp = doubleNumber;
		while ((temp >= 1000 || temp <= -1000)&& count <= 3) {
			temp /= 1000;
			count++;
		}
		if (count >= 2) {
			doubleNumber /= Math.pow(1000, count);
		}
		DecimalFormat df = new DecimalFormat("#.#",
				DecimalFormatSymbols.getInstance(Locale.US));
		df.setRoundingMode(RoundingMode.DOWN);
		stringResult = (count >= 2) ? df.format(doubleNumber)
				+ millionChar[count - 2] : df.format(doubleNumber);
		return stringResult;
	}

}
