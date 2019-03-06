import java.util.*;

public class SortStack
{
	public void sort(Stack<Integer> original)
	{
		Stack<Integer> sorted = new Stack<>();

		while(!original.isEmpty())
		{
			int temp = original.pop();
			while(!sorted.isEmpty() && sorted.peek() > temp)
			{
				original.push(sorted.pop());			
			}
			sorted.push(temp);
		}

		while(!sorted.isEmpty())
		{
			original.push(sorted.pop());
		}
	}
}
