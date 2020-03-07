import java.util.*;

public class Coins 
{
	// Count class for method 1
	/*private static class Count
	{
		int value = 0;
	}*/

	static int[] coins = new int[]{1,5,10,25};
	public static void main(String[] args)
	{
		// METHOD 1
		//Count count = new Count();
		//int amount = 10;
		//helper(amount, count, 0);
		//System.out.println(count.value);

		// METHOD 2 - DP
		int amount = 10;
		int[][]dp = new int[coins.length+1][amount+1];
		helper(amount,dp);
		System.out.println(dp[dp.length-1][dp[0].length-1]);
	}
	
	// METHOD 1 - backtracking
	/*private static void helper(int amount, Count count, int index)
	{
		if(amount < 0) return;
		if(amount == 0) 
		{
			count.value++;
			return;
		}

		for(int i = index; i < coins.length; i++)
		{
			int coin = coins[i];
			helper(amount-coin, count, i, dp);
		}
	}*/

	// METHOD 2 - DP
	private static void helper(int amount, int[][] dp) {

		// prefil first column --> 0 amount, 1 way to make change regardless of number of coins
		for(int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}

		// All elements of first row (except first element) are 0 because without any coins, there is no way to make change
		// since array default value is 0, no need to do anything.

		for(int i = 1; i < dp.length; i++) { // represents the coins available, first row means no coins, 2nd means first coin
			int coin = coins[i-1]; 
			for(int j = 1; j < dp[0].length; j++) { // represents the amount starting from 0
				if(j >= coin) { // we can use the coin, and we either choose to use the coin or not
					// example amount = 2, coin = 2, use the coin --> we get a singe coin 2 (1 way), dont use the coin --> 1 + 1 (1 way)
					dp[i][j] = dp[i-1][j] + dp[i][j-coin];
				}
				else { // if we cant use the coin, the only way is whatever achievable via the current possible coins
					dp[i][j] = dp[i-1][j];
				}
			}
		}
	}
}
