package algorithm;
import java.util.List;
import java.util.ArrayList;

public abstract class Sort
{
	public static <T extends Comparable<? super T>> T max(ArrayList<T> input)
	{
		T max = input.get(0);
		for(int i=0; i<input.size(); i++)
			if(input.get(i).compareTo(max)>0)
				max = input.get(i);
		return max;
	}
	
	public static <T extends Comparable<? super T>> int maxInd(T[] input)
	{
		T max = input[0];
		int index = 0;
		for(int i=0; i<input.length; i++)
			if(input[i].compareTo(max)>0)
			{
				max = input[i];
				index = i;
			}
		return index;
	}
	
	public static <T extends Comparable<? super T>> T[] bubbleSort(T[] input)//Applicable to any object that either directly implements the Comparable interface or inherit from a super class that implements the interface, sort the array.
	{
		boolean judge = false;
		while(!judge)//If the array is not ordered.
		{
			judge = true;//Set it to true and start checking the array.
			for(int i=0; i<input.length-1; i++)//Loop through the array.
			{
				if(input[i].compareTo(input[i+1])>0)//If the adjacent is not in order, flip the two.
				{
					judge = false;//The array is not ordered.
					T media = input[i];//Temporary holder.
					input[i] = input[i+1];
					input[i+1] = media;//Flip.
				}
			}
		}
		return input;
	}
	
	public static <T extends Comparable<? super T>> T[] selectionSort(T[] input)//Applicable to any object that either directly implements the Comparable interface or inherit from a super class that implements the interface, sort the array.
	{
		T min;//The minimum of the array.
		T media;//A temporary variable holder.
		int counter = 0;//The index of the minimum.
		for(int i=0; i<input.length; i++)
		{
			min = input[i];
			media = input[i];
			counter = i;//Assume the first element is the minimum.
			for(int j=i; j<input.length; j++)
			{
				if(input[j].compareTo(min)<0)//If have smaller ones than the assumed, record the index and assign it to minimum.
				{
					min = input[j];
					counter = j;
				}
			}
			input[i] = min;//Assign the minimum in correct sequence of the array.
			input[counter] = media;//Assign the first element into the spot that used to hold the minimum.
		}
		return input;
	}
	
	public static <T extends Comparable<? super T>> T[] quickSort(T[] input)
	{
		quickSorting(input,0,input.length-1);
		return input;
	}
	
	public static <T extends Comparable<? super T>> List<T> quickSort(List<T> input)
	{
		quickSorting(input,0,input.size()-1);
		return input;
	}
	
	public static <T extends Comparable<? super T>> void quickSorting(List<T> input, int ini, int fin)//Applicable to any object that either directly implements the Comparable interface or inherit from a super class that implements the interface, sort the array.
	{
		if(fin-ini==0)//Base case, nothing to sort, exit.
			return;
		T pivot = input.get((ini+fin)/2);//The pivot point to compare the other numbers.
		int counter1 = ini;
		int counter2 = fin;
		while(counter1<counter2)//While still checking, possibly not in order.
		{
			while(input.get(counter1).compareTo(pivot)<0)//If valid, go on.
				counter1++;
			while(input.get(counter2).compareTo(pivot)>0)//If valid, go on.
				counter2--;
			if(counter1<=counter2)//If still valid, still checking.
			{
				T temp = input.get(counter1);
				input.set(counter1, input.get(counter2));
				input.set(counter2, temp);
				counter1++;
				counter2--;//Counters go on.
			}
		}
		if(counter1<fin)//If haven't reach base case, solve recursively.
			quickSorting(input,counter1,fin);
		if(counter2>ini)//If haven't reach base case, solve recursively.
			quickSorting(input,ini,counter2);
	}
	
	public static <T extends Comparable<? super T>> void quickSorting(T[] input, int ini, int fin)//Applicable to any object that either directly implements the Comparable interface or inherit from a super class that implements the interface, sort the array.
	{
		if(fin-ini==0)//Base case, nothing to sort, exit.
			return;
		T pivot = input[(ini+fin)/2];//The pivot point to compare the other numbers.
		int counter1 = ini;
		int counter2 = fin;
		while(counter1<counter2)//While still checking, possibly not in order.
		{
			while(input[counter1].compareTo(pivot)<0)//If valid, go on.
				counter1++;
			while(input[counter2].compareTo(pivot)>0)//If valid, go on.
				counter2--;
			if(counter1<=counter2)//If still valid, still checking.
			{
				T temp = input[counter1];
				input[counter1] = input[counter2];
				input[counter2] = temp;//Flip the two unordered values.
				counter1++;
				counter2--;//Counters go on.
			}
		}
		if(counter1<fin)//If haven't reach base case, solve recursively.
			quickSorting(input,counter1,fin);
		if(counter2>ini)//If haven't reach base case, solve recursively.
			quickSorting(input,ini,counter2);
	}
	
	public static <T extends Comparable<? super T>> int binarySearch(T[] input, T tar)
	{
		quickSort(input);
		return binarySearching(input,tar,0,input.length-1);
	}
	
	public static <T extends Comparable<? super T>> int binarySearching(T[] input, T tar, int ini, int fin)
	{
		if(ini==fin)
		{
			if(input[ini].equals(tar))
				return ini;
			return -1;
		}
		int mid = (ini+fin)/2;
		if(input[ini].compareTo(tar)==0)
			return ini;
		if(input[fin].compareTo(tar)==0)
			return fin;
		if(input[ini].compareTo(tar)<0&&input[fin].compareTo(tar)>0)
		{
			if(input[mid].compareTo(tar)==0)
				return mid;
			if(input[mid].compareTo(tar)<0)
				return binarySearching(input,tar,mid+1,fin);
			return binarySearching(input,tar,ini,mid-1);
		}
		return -1;
	}
	
	public static void main(String[] args) 
	{
		
	}
	

}
