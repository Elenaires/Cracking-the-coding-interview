import java.util.*;

public class DeleteMiddleNode
{
	public static void main(String[] args)
	{
	}

	public static void deleteMiddle(ListNode delete)
	{
		if(delete != null && delete.next != null)
		{
			delete.data = delete.next.data;
			delete.next = delete.next.next;
		}
	}
}
