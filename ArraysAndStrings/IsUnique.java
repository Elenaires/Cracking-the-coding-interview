import java.util.*;

public class IsUnique
{
	public static void main(String[] args)
	{
		String word = "hello";
		System.out.println(isUnique(word));
		System.out.println(isUniqueChars(word));
	}

	public static boolean isUnique(String word)
	{
		word = word.toLowerCase();
		char[] wordArray = word.toCharArray();
		Arrays.sort(wordArray);
		boolean unique = true;

		int i = 0;
		while(unique && i < wordArray.length-1)
		{	
			if(wordArray[i] == wordArray[i+1])
			{
				unique = false;		
			}
			i++;
		}

		return unique;
	}

	public static boolean isUniqueChars(String str)
	{
		boolean[] array = new boolean[128];
		for(int i = 0; i < str.length(); i++)
		{
			int val = str.charAt(i);
			System.out.println(val);
			if(array[val])
			{
				return false;
			}
			array[val] = true;
		}

		return true;
	}
}
