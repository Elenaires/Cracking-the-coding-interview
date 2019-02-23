import java.util.*;

public class CheckPermutation
{
	public static void main(String[] args)
	{
		String str1 = "happy";
		String str2 = "appyp";

		System.out.println(checkPermutation(str1, str2));
	}

	public static boolean checkPermutation(String str1, String str2)
	{
		if(str1.length() != str2.length())
		{
			return false;
		}

		char[] str1Arr = str1.toCharArray();
		char[] str2Arr = str2.toCharArray();

		Arrays.sort(str1Arr);
		Arrays.sort(str2Arr);

		for(int i = 0; i < str1Arr.length; i++)
		{
			if(str1Arr[i] != str2Arr[i])
			{
				return false;
			}
		}
		
		// or String newStr1 = new String(str1Arr);
		// String newStr2 = new String(str2Arr);
		// return newStr1.equals(newStr2);
		return true;
	}
}
