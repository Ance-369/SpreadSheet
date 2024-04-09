package com.matterbay;

import java.util.HashMap;
import java.util.Map;

public class SpreadSheet {
	private Map<String, Object> cells; // A variable of Map is created with key as 'String' and value as 'Object'. We
										// use value data type as 'Object' since values can be of
										// Integer(A(key),13(value)) or Strings(A3(key),=A1+A2(value)).

	public SpreadSheet() {
		this.cells = new HashMap<>(); // A new map is created whenever an object of class SpreadSheet is created.
	}

	public void setCellValue(String cellId, Object value) {
		cells.put(cellId, value); // We can store the key value pair inside the map.
	}

	public int getCellValue(String cellId) {
		Object value = cells.get(cellId); // Retrieving value of the map with the key
		if (value instanceof Integer) {
			return (int) value; // If the retrieved value is of integer data type,type convert it to int and
								// return the value.
		} else if (value instanceof String) {
			String expression = (String) value;
			return evaluateExpression(expression); // If the retrieved value is of String("=A1+A2") then pass the string
													// to evaluateExpression() method.
		} else {
			throw new IllegalArgumentException("Invalid cell value"); // If the value if of neither String or Integer ,
																		// throw an exception.
		}
	}

	private int evaluateExpression(String expression) {
		String[] parts = expression.split("\\+"); // The passed String value("=A1+A2") is split and stored in an array
													// where '+' occurs
		int sum = 0;
		for (String part : parts) { // The array looks like {=A1,A2} or {=13,14}
			if (part.startsWith("=")) { // If the first element of the array starts with '=' such as =A or =13
				part = part.substring(1); // then retrieve the A or 13 and remove '='.
			}
			if (part.matches("\\d+")) { // If the part that we get is of integers
				sum += Integer.parseInt(part); // then parse it to Integer data type and sum it. example: sum = 0+13
			} else {
				sum += getCellValue(part.trim()); // If the part that we get is of character , then trim if for spaces
													// and sum = 0+getCellValue(A).
			}
		}
		return sum; // return the sum of the loop.
	}

	public static void main(String[] args) {
		SpreadSheet spreadsheet = new SpreadSheet();
		spreadsheet.setCellValue("A1", 13);
		spreadsheet.setCellValue("A2", 14);
		System.out.println("A1: " + spreadsheet.getCellValue("A1")); // Output: 13
		System.out.println("A2: " + spreadsheet.getCellValue("A2")); // Output: 14
		spreadsheet.setCellValue("A3", "=A1+A2");
		System.out.println("A3: " + spreadsheet.getCellValue("A3")); // Output: 27
		spreadsheet.setCellValue("A4", "=A1+A2+A3");
		System.out.println("A4: " + spreadsheet.getCellValue("A4")); // Output: 54
	}

}
