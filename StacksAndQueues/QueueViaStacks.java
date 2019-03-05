import java.util.*;

public class QueueViaStacks
{
	Stack<Integer> old = new Stack<>();
	Stack<Integer> new = new Stack<>();

	public static void add(int data)
	{
		new.push(node);
	}

	public static int remove()
	{
		if(old.isEmpty())
		{
			while(!new.isEmpty())
			{
				int value = new.pop();
				old.push(value);
			}
		}
		return old.pop();
	}

	public static int peek()
	{
		if(old.isEmpty())
		{
			while(!new.isEmpty())
			{
				int value = new.pop();
				old.push(value);
			}
		}
		return old.peek();
		
	}
}
