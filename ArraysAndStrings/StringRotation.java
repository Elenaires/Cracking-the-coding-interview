import java.util.*;

public class StringRotation
{
	public static void main(String[] args)
	{
		String s1 = "heartburnheart";
		String s2 = "burnheartheart";

		System.out.println(stringRotation2(s1,s2));
	}

	public static boolean stringRotation(String s1, String s2)
	{
		if(s1.length() != s2.length() || s1.equals(s2))
		{
			return false;
		}
		int i = 0, j = 0, start = 0;

		while(j < s2.length())
		{
			if(s1.charAt(i) == s2.charAt(j))
			{
				start = j; 
				i++; 
				j++;
				while(j < s2.length() && s1.charAt(i) == s2.charAt(j))
				{
					i++;
					j++;
				}
				if(j != s2.length())
				{
					i = 0; 
					start = 0;
				}
			}
			else 	
			{
				j++;
			}
		}
		if(start != 0)
		{
			return isSubString(s1, s2.substring(0, start));
		}
		return false;
	}
	
	public static boolean stringRotation2(String s1, String s2)
	{
		if(s1.length() != s2.length() || s1.equals(s2))
		{
			return false;
		}

		String newS2 = s2 + s2;
	
		return isSubString(newS2, s1);
		
	}

	public static boolean isSubString(String s1, String s2)
	{
		return s1.contains(s2);
	}
}
