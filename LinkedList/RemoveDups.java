import java.util.*;

public class RemoveDups
{
	public static void main(String[] args)
	{
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(1);
		ListNode node5 = new ListNode(3);
		ListNode node6 = new ListNode(4);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		removeDuplicates2(node1);

		ListNode curr = node1;

		while(curr != null)
		{
			System.out.print(curr.data + "->");
			curr = curr.next;
		}
		System.out.println();
	}

	// additional space allowed
	public static void removeDuplicates(ListNode head)
	{
		HashSet<Integer> set = new HashSet<>();
		ListNode curr = head;
		ListNode prev = null;

		while(curr != null)
		{
			if(!set.contains(curr.data))
			{
				set.add(curr.data);
				prev = curr;
			}
			else
			{
				prev.next = curr.next;
			}
			curr = curr.next;
		}
	}

	// additional space not allowed
	public static void removeDuplicates2(ListNode head)
	{
		ListNode p = head;
		ListNode q = null;
		ListNode preQ = p;

		while(p.next != null)
		{
			q = p.next;
			while(q != null)
			{
				if(p.data != q.data)
				{
					preQ = q;
				}
				else
				{
					preQ.next = q.next;
				}
				q = q.next;
			}
			p = p.next;
			preQ = p;
		}
	}					
}

