package main;

import java.awt.desktop.SystemSleepEvent;

public class Main
{
	public static void main(String[] args)
	{
		int[][][] values = { { 	{ 0, 0, 0, 8, 5, 9, 3, 0, 0 },
				{ 5, 0, 4, 3, 2, 0, 8, 0, 0 },
				{ 0, 0, 3, 0, 0, 7, 0, 9, 0 },
				{ 0, 4, 5, 1, 0, 0, 0, 0, 0 },
				{ 2, 7, 8, 0, 0, 0, 9, 1, 6 },
				{ 0, 0, 0, 0, 0, 8, 4, 2, 0 },
				{ 0, 3, 0, 6, 0, 0, 2, 0, 0 },
				{ 0, 0, 1, 0, 9, 3, 6, 0, 7 },
				{ 0, 0, 2, 7, 8, 5, 0, 0, 0 } },
				
				{ 	{ 9, 0, 0, 5, 0, 0, 0, 3, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 6, 0 },
						{ 0, 0, 4, 0, 0, 0, 0, 8, 0 },
						{ 0, 8, 0, 0, 0, 0, 3, 5, 0 },
						{ 0, 4, 0, 0, 5, 1, 0, 0, 0 },
						{ 0, 0, 6, 8, 0, 0, 0, 0, 1 },
						{ 0, 0, 1, 0, 0, 6, 5, 2, 0 },
						{ 0, 0, 0, 0, 8, 0, 0, 9, 6 },
						{ 2, 0, 9, 4, 0, 0, 0, 1, 0 } },
				
				{ 	{ 0, 0, 0, 2, 0, 0, 0, 0, 4 },
						{ 0, 0, 0, 3, 8, 0, 0, 5, 0 },
						{ 0, 0, 2, 0, 7, 5, 0, 0, 9 },
						{ 5, 1, 0, 0, 0, 0, 2, 0, 0 },
						{ 3, 0, 0, 0, 0, 0, 0, 0, 5 },
						{ 0, 0, 9, 0, 0, 0, 0, 7, 6 },
						{ 8, 0, 0, 7, 5, 0, 4, 0, 0 },
						{ 0, 2, 0, 0, 4, 8, 0, 0, 0 },
						{ 7, 0, 0, 0, 0, 9, 0, 0, 0 } } };
		
		Sudoku sudoku1 = new Sudoku(values[0]);
		Sudoku sudoku2 = new Sudoku(values[1]);
		Sudoku sudoku3 = new Sudoku(values[2]);
		
		Solver solver = new Solver();
		
		System.out.println(solver.solve(sudoku1));
		System.out.println(solver.solve(sudoku2));
		System.out.println(solver.solve(sudoku3));
		
		System.out.println(sudoku1.toString());
		System.out.println(sudoku2.toString());
		System.out.println(sudoku3.toString());
	}
}
