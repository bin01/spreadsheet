package com.bin01.spreadsheet;

public enum Operator
{
	ADD('+')
	{
		@Override
		public double evaluate(double a, double b)
		{
			return a + b;
		}
	},

	SUB('-')
	{
		@Override
		public double evaluate(double a, double b)
		{
			return a - b;
		}
	},

	MULT('*')
	{
		@Override
		public double evaluate(double a, double b)
		{
			return a * b;
		}
	},

	DIV('/')
	{
		@Override
		public double evaluate(double a, double b)
		{
			return a / b;
		}
	};

	private final char symbol;

	private Operator(char symbol)
	{
		this.symbol = symbol;
	}

	public abstract double evaluate(double a, double b);

	public static Operator from(char ch)
	{
		switch (ch)
		{
		case '+':
			return ADD;
		case '-':
			return SUB;
		case '*':
			return MULT;
		case '/':
			return DIV;
		}
		throw new IllegalArgumentException("Invalid operator " + ch);
	}

	public char getSymbol()
	{
		return symbol;
	}
}
