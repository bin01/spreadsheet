package com.bin01.spreadsheet;

public class CellValue implements Expression
{
	private final Coordinate coordinate;

	public CellValue(Coordinate coordinate)
	{
		this.coordinate = coordinate;
	}

	public Coordinate getCoordinate()
	{
		return coordinate;
	}

	public static CellValue from(String coordinate)
	{
		return new CellValue(Coordinate.from(coordinate));
	}

	@Override
  public <T> T accept(ExpressionVisitor<T> visitor)
  {
	  return visitor.visit(this);
  }

	@Override
  public String toString()
  {
		return coordinate.toString();
  }
}
