import java.util.*;

public class SumLists
{
	public static void main(String[] args)
	{
		ListNode node1 = new ListNode(7);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(6);

		node1.next = node2;
		node2.next = node3;

		ListNode node4 = new ListNode(1);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(9);
		ListNode node7 = new ListNode(9);

		node4.next = node5;
		node5.next = node6;
		node6.next = node7;

		ListNode newHead = sumList(node1, node4);
		
		ListNode curr = newHead;

		while(curr!= null)
		{
			System.out.print(curr.data + "->");
			curr = curr.next;
		}
		System.out.println();

	}

	public static ListNode sumList(ListNode l1, ListNode l2)
	{
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;

		int carryOver = 0;

		int value = 0;
		while(l1 != null || l2 != null)
		{
			if(l1!= null && l2 != null)
			{
				value = l1.data + l2.data + carryOver;
				l1 = l1.next;
				l2 = l2.next;
			}
			else if (l1 == null)
			{
				value = l2.data + carryOver;
				l2 = l2.next;
			}
			else
			{
				value = l1.data + carryOver;
				l1 = l1.next;
			}
			
			if(value > 9)
			{
				value = value % 10;
				carryOver = 1;
			}
			else
			{
				carryOver = 0;
			}

			ListNode node = new ListNode(value);
			curr.next = node;
			curr = curr.next;
		}

		if(carryOver > 0)
		{
			ListNode node = new ListNode(carryOver);
			curr.next = node;
		}

		return dummy.next;
	}
}
