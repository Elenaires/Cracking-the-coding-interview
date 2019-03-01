import java.util.*;

public class Palindrome
{
	public static void main(String[] args)
	{
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(3);
		ListNode n6 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(1);

		n1.next = n2;
		n2.next = n3;
		n3.next = n6;
		n6.next = n4;
		n4.next = n5;

		System.out.println(palindrome(n1));
	}

	public static boolean palindrome(ListNode head)
	{
		Stack<Integer> stack = new Stack<>();

		ListNode slow = head;
		ListNode fast = head;

		// find mid point
		while(fast != null && fast.next != null)
		{
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}

		if(fast != null)
		{
			stack.push(slow.data);
			slow = slow.next;
		}

		// to cover case where list length is odd
		if(stack.peek() != slow.data)
		{
			stack.pop();
		}

		while(slow != null)
		{
			if(slow.data != stack.pop())
			{
				return false;
			}
			slow = slow.next;
		}

		return true;
	}
}
