package com.matterbaytest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.matterbay.SpreadSheet;

public class SpreadSheetTest {
	@Test
	public void testSpreadsheet() {
		SpreadSheet spreadsheet = new SpreadSheet();

		// Set individual cell values
		spreadsheet.setCellValue("A1", 13);
		spreadsheet.setCellValue("A2", 14);

		// Check individual cell values
		assertEquals(13, spreadsheet.getCellValue("A1"));
		assertEquals(14, spreadsheet.getCellValue("A2"));

		// Set expression in a cell and check its value
		spreadsheet.setCellValue("A3", "=A1+A2");
		assertEquals(27, spreadsheet.getCellValue("A3"));

		// Set expression in another cell referencing previous cells and check its value
		spreadsheet.setCellValue("A4", "=A1+A2+A3");
		assertEquals(54, spreadsheet.getCellValue("A4"));
	}

}
