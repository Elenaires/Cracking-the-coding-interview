import java.util.*;

public class URLify 
{
	public static void main(String[] args)
	{
		char[] arr = new char[]{'m','r',' ','j','o','h','n',' ','s','m','i','t','h',' ',' ',' ',' '};
		int length = 13;
		replaceSpaces(arr, length);

		for(char c : arr)
		{
			System.out.print(c);
		}
		System.out.println();
	}

	public static void replaceSpaces(char[] arr, int length)
	{
		final int URL = 2;

		int whitespace = 0;
	
		for(int i =0; i < length; i++)
		{
			if(arr[i] == ' ')
			{
				whitespace++;
			}
		}
		
		int shuffle = URL * whitespace;

		for(int i = length - 1; i >= 0; i--)
		{
			if(arr[i] != ' ')
			{
				arr[i+shuffle] = arr[i];
			}
			else 
			{
				arr[i+shuffle] = '0';
				arr[i+shuffle-1] ='2';
				arr[i+shuffle-2] = '%';
				shuffle -= 2;
			}
		}
	}
}
