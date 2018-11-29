package main;

public class Solver
{
	
	public boolean solve(Sudoku sudoku)
	{
		return solve(sudoku, 0, 0);
	}
	private boolean solve(Sudoku sudoku, int x, int y)
	{
		if(y == 9)
			return true;
		
		int nextX = x == 8? 0 : x+1;
		int nextY = x == 0? y +1: y;
		
		if(sudoku.isWriteable(x, y))
		{
			for (int i = 1; i <= 9; i++)
			{
				if(conflictAt(sudoku, x, y, i))
					continue;
				
				sudoku.setValue(x, y, i);
				
				if(solve(sudoku, nextX, nextY))
					return true;
				
				sudoku.setValue(x, y, 0);
			}
			return false;
		}
		return solve(sudoku, nextX, nextY);
	}
	
	private boolean conflictAt(Sudoku sudoku, int x, int y, int value)
	{
		for (int xCheck = 0; xCheck < 9; xCheck++)
			if(sudoku.getValue(xCheck, y) == value)
				return true;
		
		for (int yCheck = 0; yCheck < 9; yCheck++)
			if(sudoku.getValue(x, yCheck) == value)
				return true;
		
			
		int boxX = x - x%3;
		int boxY = y - y%3;
		for (int boxOffsetX = 0; boxOffsetX < 3; boxOffsetX++)
			for (int boxOffsetY = 0; boxOffsetY < 3; boxOffsetY++)
				if(sudoku.getValue(boxX + boxOffsetX, boxY + boxOffsetY) == value)
					return true;
				
				
		return false;
	}
}
