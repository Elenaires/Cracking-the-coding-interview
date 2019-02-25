import java.util.*;

public class ZeroMatrix
{
	public static void main(String[] args)
	{
	}

	public static void setZeros(int[][] matrix)
	{
		boolean[] row = new boolean[matrix.length];
		boolean[] col = new boolean[matrix[0].length];

		// step through matrix and store rows and cols with 0
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[0].length; j++)
			{
				if(matrix[i][j] == 0)
				{
					row[i] = true;
					col[j] = true;
				} 
			}
		}

		// step through row array and nullify row
		for(int i = 0; i < row.length; i++)
		{
			if(row[i])
			{
				nullifyRow(matrix, i);
			}
		}

		// step through col array and nullify col
		for(int i = 0; i < col.length; i++)
		{
			if(col[i])
			{
				nullifyCol(matrix, i);
			}
		}
	}

	public static void nullifyRow(int[][] matrix, int row)
	{
		for(int i = 0; i < matrix[0].length; i++)
		{
			matrix[row][i] = 0;
		}
	}

	public static void nullifyCol(int[][] matrix, int col)
	{
		for(int i = 0; i < matrix.length; i++)
		{
			matrix[i][col] = 0;
		}
	}
}
