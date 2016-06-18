package com.sqa.av.helpers;

import org.testng.*;
import org.testng.annotations.*;

import com.sqa.av.helpers.data.*;

public class DataHelperDivTest {

	// @DataProvider(name = "textIsDivisible")
	// public Object[][] getData() {
	// Object[][] data;
	// data = DataHelper.getTextFileData("src/main/resources/", "dataDiv.csv",
	// TextFormat.CSV, true);
	// DisplayHelper.multArray(data);
	// return data;
	// }

	@DataProvider(name = "textIsDivisibleTyped")
	public Object[][] getDataTyped() {
		Object[][] data;
		data = DataHelper.getTextFileData("src/main/resources/", "dataDiv.csv", TextFormat.CSV, true, Integer.TYPE,
				Integer.TYPE, Boolean.TYPE);
		DisplayHelper.multArray(data);
		return data;
	}

	// @Test(dataProvider = "textIsDivisible")
	// public void testReadingFile(String dividend, String divisor, String
	// isDivisible) {
	// System.out.println("==============================");
	// System.out.println("Actual Result:");
	// System.out.println("==============================");
	// try {
	// System.out.println("Is the number " + dividend + ", divisible by " +
	// divisor + "?: " + isDivisible);
	// boolean actualResult = isDivisible(Integer.parseInt(dividend),
	// Integer.parseInt(divisor));
	// Assert.assertEquals(actualResult, Boolean.parseBoolean(isDivisible),
	// "The Number " + dividend + "is not divisible by " + divisor);
	// } catch (NumberFormatException e) {
	// e.printStackTrace();
	// }
	// }

	@Test(dataProvider = "textIsDivisibleTyped")
	public void testReadingFileTyped(int dividend, int divisor, boolean Div) {
		try {
			System.out
					.println("Is the number " + dividend + ", divisible by " + divisor + "? Actual Result --> " + Div);
			boolean actualResult = isDivisible(dividend, divisor);

			Assert.assertEquals(Div, actualResult,
					"Expected Result --> The Number " + dividend + " is infact not divisible by " + divisor + ".");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}

	private boolean isDivisible(int dividend, int divisor) {
		boolean isDiv = true;
		if ((dividend % divisor) == 0)
			return isDiv = true;
		else
			return isDiv = false;
	}
}
