import java.util.*;

public class StackOfPlates
{
	public static void main(String[] args)
	{
	}

	public static class SetOfStacks
	{
		List<Stack> stacks = new ArrayList<>();

		public static class Stack
		{
			ListNode top;
			int size = 0;
			int capacity;

			public Stack(int capacity)
			{
				this.capacity = capacity;
			}

			public static int pop()
			{
				if(isEmpty())
				{
					return new EmptyStackException();
				}
				int data = top.data;
				top = top.next;
				size--;
				return data;
			}

			public static void push(int data)
			{
				ListNode node = new ListNode(data);
				top.next = node;
				top = node;
				size++;
			}

			public static boolean isEmpty()
			{
				return top == null;
			}

			public static boolean isFull()
			{
				return size >= capacity;
			}

			public static int peek()
			{
				if(isEmpty())
				{
					return new EmptyStackException();
				}
				return top.data;
			}
		}

		public static int pop()
		{
			Stack lastStack = getLastStack();
			int data;
			if(lastStack == null)
			{
				return new EmptyStackException();
			}
			data = lastStack.pop();
			
			if (lastStack.isEmpty())
			{
				stacks.remove(stacks.size()-1);
			}
			return data;
		}

		public static void push(int data)
		{
			Stack lastStack = getLastStack();
			if(lastStack == null || lastStack.isFull())
			{
				Stack s = new Stack();
				s.push(data);
				stacks.add(s);
			}
			else
			{
				lastStack.push(data);
			}
		}

		public static Stack getLastStack()	
		{
			if(stacks.size() == 0)
			{
				return null;
			}
			return stacks.get(stacks.size()-1);
		}
	}
}
