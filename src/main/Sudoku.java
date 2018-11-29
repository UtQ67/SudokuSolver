package main;

public class Sudoku
{
	private int[][] values;
	boolean[][] writeable;
	
	public Sudoku(int[][] values)
	{
		this.values = values;
		
		writeable = new boolean[values.length][values[1].length];
		for (int x = 0; x < writeable.length; x++)
		{
			for (int y = 0; y < writeable[x].length; y++)
			{
				writeable[x][y] = values[x][y] == 0;
			}
		}
	}
	
	public void setValue(int x, int y, int value)
	{
		if(isWriteable(x, y))
			values[x][y] = value;
	}
	public int getValue(int x, int y)
	{
		return values[x][y];
	}
	public boolean isWriteable(int x, int y)
	{
		return writeable[x][y];
	}
	
	public String toString()
	{
		String ret = "";
		
		for (int x = 0; x < 9; x++)
		{
			if(x%3 == 0)
			{
				ret += "-------------\n";
			}
			for (int y = 0; y < 10; y++)
			{
				if(y == -1 || y == 9)
				{
					ret +="|";
					continue;
				}

				if( y%3 == 0)
				{
					ret += "|";
				}
				
				ret += values[x][y];
			}
			ret += "\n";
		}
		ret += "-------------\n";
		return ret;
	}
}
