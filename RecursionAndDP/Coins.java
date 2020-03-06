import java.util.*;

public class Coins 
{
	private static class Count
	{
		int value = 0;
	}

	static int[] change = new int[]{1,5,10,25};
	public static void main(String[] args)
	{
		Count count = new Count();
		int num = 10;
		helper(num, count, 0);
		System.out.println(count.value);
	}
	
	private static void helper(int num, Count count, int index)
	{
		if(num < 0) return;
		if(num == 0) 
		{
			count.value++;
			return;
		}
		for(int i = index; i < change.length; i++)
		{
			int coin = change[i];
			helper(num-coin, count, i);
		}
	}
}
