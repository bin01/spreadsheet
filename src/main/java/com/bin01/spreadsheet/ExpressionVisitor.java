package com.bin01.spreadsheet;

public interface ExpressionVisitor<T>
{

	T visit(Value value);

	T visit(CellValue cellValue);

	T visit(CompositeExpression compositeExpression);

}
