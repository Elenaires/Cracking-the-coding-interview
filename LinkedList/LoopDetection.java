public class LoopDetection 
{
	public ListNode findLoopHead(ListNode head)
	{
		ListNode slow = head;
		ListNode fast = head;

		while(fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast)
			{
				break;
			}
		}

		// no loop
		if(fast == null || fast.next == null)
		{
			return null;
		}

		// look for head of loop
		slow = head;
		while(slow != fast)
		{
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}
}

