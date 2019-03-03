// 0 - stack no. 1
// 1 - stack no. 2
// 2 - stack no. 3
// arr = s1,s2,s3 | s1,s2,s3 | s1,s2,s3 | ...

import java.util.*

public class ThreeInOne
{
	// initial array size
	int[] arr = new int[3];

	int[] count = new int[3];
	//count[0] == stack 1 count
	//count[1] == stack 2 count
	//count[2] == stack 3 count

	int[] index = new int[3];
	//index[0] == stack 1 index
	//index[1] == stack 2 index
	//index[2] == stack 3 index

	public int pop(int stack)
	{
		int value = peek(stack);
		
		count[stack] -= 1;
		index[stack] -= 3;

		return value; 
	}

	public boolean isEmpty(int stack)
	{
		if(count[stack] == 0)
		{
			return true;
		}
		return false;
	}

	public boolean isFull(int stack)
	{
		if(count[stack] > arr.length / 3)
		{
			return true;
		}
		return false;
	}

	public void resizeArray()
	{
		int[] temp = new int[arr.length * 2];
		for(int i = 0; i < arr.length; i++)
		{
			temp[i] = arr[i];
		}
		arr = temp;
	}

	public void push(int stack, int data)
	{
		if(isFull(stack))
		{
			resizeArray();
		}
		
		arr[index[stack]] = data;
		index[stack] += 3;
		count[stack] += 1;
	}		

	public int peek(int stack)
	{
		if(isEmpty(stack))
		{
			throw new EmptyStackException();
		}
		
		return arr[index[stack]-3]; 
	}
}
