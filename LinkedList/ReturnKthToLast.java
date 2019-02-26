import java.util.*;

public class ReturnKthToLast
{
	public static void main(String[] args)
	{
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(2);
		ListNode node6 = new ListNode(4);
		ListNode node7 = new ListNode(6);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;

		ListNode kthNode = kNode(node1, 1);

		System.out.println(kthNode.data);	
	}

	public static ListNode kNode(ListNode head, int k)
	{
		ListNode p = head;
		ListNode q = head;

		while(k > 0)
		{
			// out of bounds
			if(q == null)
			{
				return null;
			}
			q = q.next;
			k--;
		}

		while(q != null)
		{
			p = p.next;
			q = q.next;
		}

		return p;
	}
}
