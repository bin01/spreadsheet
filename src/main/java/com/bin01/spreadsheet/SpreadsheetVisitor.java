package com.bin01.spreadsheet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SpreadsheetVisitor implements ExpressionVisitor<Double>
{
	private final Spreadsheet spreadsheet;
	private final Set<Coordinate> visited;
	private final Map<Coordinate, Double> cache;

	public SpreadsheetVisitor(Spreadsheet spreadsheet)
	{
		this.spreadsheet = spreadsheet;
		this.visited = new HashSet<>();
		this.cache = new HashMap<>();
	}

	@Override
	public Double visit(Value value)
	{
		return value.getValue();
	}

	@Override
	public Double visit(CellValue cellValue)
	{
		Coordinate coordinate = cellValue.getCoordinate();
		if(cache.containsKey(coordinate)) {
			return cache.get(coordinate);
		}
		if (visited.contains(coordinate))
		{
			throw new IllegalStateException("Cyclic depedency found");
		}
		visited.add(coordinate);
		Expression expression = spreadsheet.getExpression(coordinate);
		Double value = expression.accept(this);
		visited.remove(coordinate);
		cache.put(coordinate, value);
		return value;
	}

	@Override
	public Double visit(CompositeExpression compositeExpression)
	{
		Double left = compositeExpression.getLeft().accept(this);
		Double right = compositeExpression.getRight().accept(this);
		return compositeExpression.getOperator().evaluate(left, right);
	}
}
