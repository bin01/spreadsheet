package com.bin01.spreadsheet;

public class Coordinate
{
	private final int row;
	private final int column;
	
	public Coordinate(int row, int column)
  {
	  this.row = row;
	  this.column = column;
  }

	public int getRow()
  {
	  return row;
  }

	public int getColumn()
  {
	  return column;
  }

	public static Coordinate from(String coordinate)
	{
		int row = coordinate.charAt(0) - 'A' + 1;
		int col = Integer.parseInt(coordinate.substring(1));
		return new Coordinate(row, col);
	}
	
	@Override
  public int hashCode()
  {
	  final int prime = 31;
	  int result = 1;
	  result = prime * result + column;
	  result = prime * result + row;
	  return result;
  }

	@Override
  public boolean equals(Object obj)
  {
	  if (this == obj)
		  return true;
	  if (obj == null)
		  return false;
	  if (getClass() != obj.getClass())
		  return false;
	  Coordinate other = (Coordinate) obj;
	  if (column != other.column)
		  return false;
	  if (row != other.row)
		  return false;
	  return true;
  }
	
	@Override
	public String toString()
	{
	  return "" + ((char)('A' + row - 1)) + column;
	}
}
