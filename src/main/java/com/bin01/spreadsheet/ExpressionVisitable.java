package com.bin01.spreadsheet;

public interface ExpressionVisitable
{

	<T> T accept(ExpressionVisitor<T> visitor);
	
}
