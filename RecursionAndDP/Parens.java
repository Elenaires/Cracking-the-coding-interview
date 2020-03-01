import java.util.*;

public class Parens
{
	public static void main(String[] args)
	{
		//Set<String> set = helper(6);
		//int i = 1;
		/*for(String s : set)
		{
			System.out.println(i+ ": " + s);
			i++;
		}*/

		List<String> list = new ArrayList();
		int number =  2;
		char[] array = new char[number*2];
		helper(list, number, number, array, 0);

		int i = 1;
		for(String s : list)
		{
			System.out.println(i+ ": " + s);
			i++;
		}

	}

	/*private static Set<String> helper(int num) 
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
	}*/

	private static void helper(List<String> list, int left, int right, char[] array, int index)
	{
		if(left < 0 || right < 0)
		{
			return;
		}

		// we have found a valid string
		if(left == 0 && right == 0)
		{
			list.add(String.copyValueOf(array));		
		}
		else
		{
			array[index] = '(';
			helper(list, left-1, right, array, index+1);

			if(left < right) // make sure there are more left than right before adding right 
			{
				array[index] = ')';
				helper(list, left, right-1, array, index+1);
			}
		}
	}
}
