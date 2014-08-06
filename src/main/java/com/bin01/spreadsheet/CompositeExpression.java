package com.bin01.spreadsheet;

public class CompositeExpression implements Expression
{
	private final Expression left;
	private final Operator operator;
	private final Expression right;

	public CompositeExpression(Expression left, Operator operator, Expression right)
	{
		this.left = left;
		this.operator = operator;
		this.right = right;
	}

	public Expression getLeft()
	{
		return left;
	}

	public Operator getOperator()
	{
		return operator;
	}

	public Expression getRight()
	{
		return right;
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor)
	{
		return visitor.visit(this);
	}
	
	@Override
	public String toString()
	{
		return "(" + left.toString() + " " + operator.getSymbol() + " " + right.toString() + ")";
	}
}
