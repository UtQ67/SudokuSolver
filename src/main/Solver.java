package main;

import java.util.Iterator;

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
	
	private boolean iteratorConflict(Iterator<Integer> iterator, int value)
	{
		while (iterator.hasNext())
			if(iterator.next() == value)
				return true;
		return false;
	}
	
	private boolean conflictAt(Sudoku sudoku, int x, int y, int value)
	{
		Iterator<Integer> iterator = sudoku.rowIterator(x, y);
		if(iteratorConflict(iterator, value)) return true;
		
		iterator = sudoku.columnIterator(x, y);
		if(iteratorConflict(iterator, value)) return true;
		
		iterator=sudoku.squareIterator(x, y);
		if(iteratorConflict(iterator, value)) return true;
		
		return false;

	}
}
