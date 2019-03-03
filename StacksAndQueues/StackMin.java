// or use a stack - for space efficiency

public class StackMin
{
	ListNode top;
	int min = Integer.MAX_VALUE;

	public void push(int data)
	{
		ListNode node = new ListNode(data);
		node.next = top;
		top = node;

		if(data < min)
		{
			min = data;
		}

		node.min = min;
	}

	public int min()
	{
		if(isEmpty())
		{
			return new EmptyStackException();
		}
		return top.min();	
	}
}
