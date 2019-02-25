import java.util.*;

public class StringCompression
{
	public static void main(String[] args)
	{
		String str = "  ";
		System.out.println(compression(str));
	}
	
	public static String compression(String str)
	{
		if(str.length() == 0 || str.length() == 1)
		{
			return str;
		}

		int duplicate = 1;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); i++)
		{
			if(i+1 == str.length() || str.charAt(i) != str.charAt(i+1))
			{
				sb.append(str.charAt(i)).append(duplicate);
				duplicate = 1;
			}
		
			else if(str.charAt(i) == str.charAt(i+1))
			{
				duplicate++;
			}
		}

		String compressed = sb.toString();

		return compressed.length() > str.length() ? str : compressed;
	}
}
