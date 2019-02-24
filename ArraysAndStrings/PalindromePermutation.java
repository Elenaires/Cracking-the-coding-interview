import java.util.*;

public class PalindromePermutation
{
	public static void main(String[] args)
	{
		String word = "onanahhi";
		System.out.println(checkPP(word));
	}
	
	public static boolean checkPP(String word)
	{
		HashMap<Character, Integer> map = new HashMap<>();

		for(int i = 0; i < word.length(); i++)
		{
			char c = word.charAt(i);
			if(map.containsKey(c))
			{
				map.put(c, map.get(c)+1);
			}
			else
			{
				map.put(c, 1);
			}
		}

		int oddCount = 0;
		for(char c : map.keySet())
		{
			if(map.get(c) % 2 != 0)
			{
				oddCount++;
			}
		}

		boolean isPP = true;

		// even length string will have at least 2 oddCount if not palindrome
		// odd length string will only have 1 oddCount if palindrome
		if(oddCount > 1)
		{
			isPP = false;
		}

		return isPP;
	}
}
