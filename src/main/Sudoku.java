package main;

import java.util.Iterator;

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
	public Iterator<Integer> rowIterator(int x, int y)
	{
		return new SameRowIterator(x, y);
	}
	public Iterator<Integer> columnIterator(int x, int y)
	{
		return new SameColumnIterator(x, y);
	}
	public Iterator<Integer> squareIterator(int x, int y)
	{
		return new SameSquareIterator(x,y);
	}
	private class SameRowIterator implements Iterator<Integer>
	{
		private int x;
		private int y;
		
		public SameRowIterator(int x, int y)
		{
			y = 0;
			this.x = x;
		}
		
		@Override
		public boolean hasNext()
		{
			return  x < 9 && y < 9;
		}
		
		@Override
		public Integer next()
		{
			y++;
			return values[x][y - 1];
		}
	}
	private class SameColumnIterator  implements Iterator<Integer>
	{
		private int x;
		private int y;
		
		public SameColumnIterator(int x, int y)
		{
			x = 0;
			this.y = y;
		}
		
		@Override
		public boolean hasNext()
		{
			return  x < 9 && y < 9;
		}
		
		@Override
		public Integer next()
		{
			x++;
			return values[x - 1][y];
		}
	}
	
	private class SameSquareIterator  implements Iterator<Integer>
	{
		private int boxX;
		private int boxY;
		
		private int yOffset = 0;
		private int xOffset = 0;
		
		public SameSquareIterator(int x, int y)
		{
			boxX = x - x%3;
			boxY = y - y%3;
		}
		
		@Override
		public boolean hasNext()
		{
			return !(yOffset == 2 && xOffset == 2);
		}
		
		@Override
		public Integer next()
		{
			int ret = values[boxX + xOffset] [boxY + yOffset];
			
			
			yOffset ++;
			if(yOffset == 3)
			{
				yOffset = 0;
				xOffset++;
			}
			
			return ret;
		}
	}
	
}
