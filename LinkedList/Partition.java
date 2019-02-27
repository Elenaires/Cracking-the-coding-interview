import java.util.*;

public class Partition
{
	public static void main(String[] args)
	{
		ListNode node1 = new ListNode(6);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(8);
		ListNode node4 = new ListNode(10);
		ListNode node5 = new ListNode(2);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		ListNode newHead = partition(node1, 5);

		ListNode curr = newHead;
		while(curr != null)
		{
			System.out.print(curr.data + "->");
			curr = curr.next;
		}
		System.out.println();
	}

	public static ListNode partition(ListNode node, int pivot)
	{
		ListNode head = node;
		ListNode tail = node;
		ListNode curr = node.next;

		while(curr != null)
		{
			ListNode next = curr.next;
			if(curr.data < pivot)
			{				
				curr.next = head;
				head = curr;
			}
			else
			{
				tail.next = curr;
				tail = tail.next;
			}
			curr = next;
		}
		tail.next = null;

		return head;
	}
}
