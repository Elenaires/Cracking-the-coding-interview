import java.util.*;

public class OneAway 
{
	public static void main(String[] args)
	{
		String str1 = "abc";
		String str2 = "abcr";

		System.out.println(oneAway(str1, str2));
	}

	public static boolean oneAway(String str1, String str2)
	{
		if(Math.abs(str1.length() - str2.length()) > 1)
		{
			return false;
		}

		else if(str1.length() > str2.length())
		{
			return insert(str1, str2);
		}
		else if(str1.length() < str2.length())
		{
			return insert(str2, str1);
		}
		else
		{
			return replace(str1, str2);
		}
		
	}

	public static boolean insert(String str1, String str2)
	{
		int edit = 0;
		int i = 0, j = 0;
		while(i < str1.length() && j < str2.length())
		{
			if(str1.charAt(i) == str2.charAt(j))
			{
				i++;
				j++;
			}
			else
			{
				i++;
				edit++;
			}
		}
		if(edit > 1)
		{
			return false;
		}
	
		return true;
		
	}
	

	public static boolean replace(String str1, String str2)
	{
		int j = 0;
		int edit = 0;
		for(int i = 0; i < str1.length(); i++)
		{
			if(str1.charAt(i) != str2.charAt(j))
			{
				edit++;
			}
			j++;
		}
		if(edit > 1)
		{
			return false;
		}
		return true;
	}
	
}
