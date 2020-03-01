import java.util.*;

public class Parens
{
	public static void main(String[] args)
	{
		Set<String> set = helper(6);
		int i = 1;
		/*for(String s : set)
		{
			System.out.println(i+ ": " + s);
			i++;
		}*/
	}

	private static Set<String> helper(int num) 
	{
		Set<String> set = new HashSet();
		if(num == 0)
		{
			set.add("");
		}
		else 
		{
			Set<String> prev = helper(num-1);
			System.out.println(num + ": " + prev.size());
			for(String s: prev)
			{
				for(int i = 0; i < s.length(); i++)
				{
					char c = s.charAt(i);
					if(c == '(')
					{
						String newString = insertParen(s, i);
						set.add(newString);
					}
				}
				set.add("()"+s);
			}
		}
		return set;
	}

	private static String insertParen(String str, int index)
	{
		String start = str.substring(0, index+1);
		String end = str.substring(index+1);
		return start + "()" + end;
	}
}
