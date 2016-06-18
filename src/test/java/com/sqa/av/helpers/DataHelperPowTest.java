package com.sqa.av.helpers;

import org.testng.*;
import org.testng.annotations.*;

import com.sqa.av.helpers.data.*;

public class DataHelperPowTest {

	@DataProvider(name = "textPowTyped")
	public Object[][] getDataTyped() {
		Object[][] data;
		data = DataHelper.getTextFileData("src/main/resources/", "dataPow.csv", TextFormat.CSV, true, Integer.TYPE,
				Integer.TYPE, Integer.TYPE);
		DisplayHelper.multArray(data);
		return data;
	}

	@Test(dataProvider = "textPowTyped")
	public void testReadingFileTyped(int num, int toPower, int result) {
		try {
			System.out.println("The value of " + num + " to the power of " + toPower + " is: " + result);
			int actualResult = toPowerCalc(num, toPower);
			Assert.assertEquals(result, actualResult,
					"The value of " + num + " to the power of " + toPower + " is not " + result);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	private int toPowerCalc(int base, int exp) {
		{
			if (exp == 1)
				return base;
			else {
				return base * toPowerCalc(base, exp - 1);
			}
		}
	}
}