import java.util.*;

public class Intersection
{
	public static void main(String[] args)
	{
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);

		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		ListNode n9 = new ListNode(9);
		ListNode n10 = new ListNode(10);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;

		n5.next = n8;

		ListNode intersectNode = intersectionNode(n1, n6);
		if(intersectNode != null)
		{
			System.out.println(intersectNode.data);
		}
		else
		{
			System.out.println("NO intersect");
		}
	}

	public static ListNode intersectionNode(ListNode l1, ListNode l2)
	{
		if(l1 == null || l2 == null)
		{
			return null;
		}

		int lengthL1 = 0;	
		int lengthL2 = 0;

		ListNode l1temp = l1;
		ListNode l2temp = l2;
		ListNode l1tail = null;
		ListNode l2tail = null;

		while(l1temp != null || l2temp != null)
		{
			if(l1temp != null)
			{
				lengthL1++;
				if(l1temp.next == null)
				{
					l1tail = l1temp;
				}
				l1temp = l1temp.next;
			}
			if(l2temp != null)
			{
				lengthL2++;
				if(l2temp.next == null)
				{
					l2tail = l2temp;
				}
				l2temp = l2temp.next;
			}
		}

		// if both list do not share the same tail
		// they do not intersect
		if(l1tail != l2tail)
		{
			return null;
		}
			
		// check difference in lenght and move the pointer of the longer one
		// to match the lenght of shorter one
	
		
		int diffLength = Math.abs(lengthL1 - lengthL2);
	
		l1temp = l1;
		l2temp = l2;

		if(lengthL1 > lengthL2)
		{
			l1temp = traverseNNodes(l1, diffLength);
		}
		else if (lengthL1 < lengthL2)
		{
			l2temp = traverseNNodes(l2, diffLength);
		}

		// traverse both list in tandem
		// compare next node
		while(l1temp != null)
		{
			if(l1temp.next == l2temp.next)
			{
				return l1temp.next;
			}
			l1temp = l1temp.next;
			l2temp = l2temp.next;
		}

		return null;		
	}

	public static ListNode traverseNNodes(ListNode list, int n)
	{
		ListNode curr = list;
		for(int i = 0; i < n; i++)
		{
			curr = curr.next;
		}

		return curr;
	}
}
