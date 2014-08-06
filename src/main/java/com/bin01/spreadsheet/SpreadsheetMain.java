package com.bin01.spreadsheet;

import java.util.Scanner;

public class SpreadsheetMain
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		DefaultSpreadsheet spreadsheet = new DefaultSpreadsheet();
		int columns = scanner.nextInt();
		int rows = scanner.nextInt();
		scanner.nextLine();
		for (int i = 1; i <= rows; ++i)
		{
			for (int j = 1; j <= columns; ++j)
			{
				Expression expression = ExpressionFactory.create(scanner.nextLine());
				spreadsheet.putExpression(new Coordinate(i, j), expression);
			}
		}
		scanner.close();
		
		SpreadsheetVisitor visitor = new SpreadsheetVisitor(spreadsheet);
		System.out.println(columns + " " + rows);
		for (int i = 1; i <= rows; ++i)
		{
			for (int j = 1; j <= columns; ++j)
			{
				Expression expression = spreadsheet.getExpression(new Coordinate(i, j));
				System.out.println(expression.accept(visitor));
			}
		}
	}
	
}
