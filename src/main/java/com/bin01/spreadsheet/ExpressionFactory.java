package com.bin01.spreadsheet;

import java.util.Arrays;
import java.util.LinkedList;

public class ExpressionFactory
{

	public static Expression create(String value)
	{
		LinkedList<String> symbols = new LinkedList<String>(Arrays.asList(value.split("\\s+")));
		LinkedList<Expression> stack = new LinkedList<>();
		while (!symbols.isEmpty())
		{
			String symbol = symbols.pop();
			char first = symbol.charAt(0);
			if (Character.isAlphabetic(first))
			{
				stack.push(CellValue.from(symbol));
			} else if (Character.isDigit(first))
			{
				stack.push(new Value(Integer.parseInt(symbol)));
			} else if (symbol.length() == 1)
			{
				Operator op = Operator.from(first);
				Expression right = stack.pop();
				Expression left = stack.pop();
				stack.push(new CompositeExpression(left, op, right));
			} else
			{
				throw new IllegalStateException("Invalid symbol " + symbol);
			}
		}

		if (stack.size() > 1)
		{
			throw new IllegalStateException("Invalid expression " + value);
		}

		return stack.pop();
	}

}
