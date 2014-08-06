package com.bin01.spreadsheet;

import java.util.HashMap;
import java.util.Map;

public class DefaultSpreadsheet implements Spreadsheet
{
	private Map<Coordinate, Expression> cells;

	public DefaultSpreadsheet()
	{
		this.cells = new HashMap<>();
	}

	@Override
	public Expression getExpression(Coordinate coordinate)
	{
		return cells.get(coordinate);
	}

	public void putExpression(Coordinate coordinate, Expression expression)
	{
		cells.put(coordinate, expression);
	}
}
