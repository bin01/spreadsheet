package com.bin01.spreadsheet;

public class Value implements Expression
{
	private final double value;

	public Value(double value)
	{
		this.value = value;
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor)
	{
		return visitor.visit(this);
	}

	public double getValue()
	{
		return value;
	}
	
	@Override
	public String toString()
	{
	  return Double.toString(value);
	}
}
