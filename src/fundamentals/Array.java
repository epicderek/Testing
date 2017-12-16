package fundamentals;
import java.util.*;
import java.util.logging.*;
import java.util.regex.*;
import java.io.*;
import java.lang.reflect.*;


public abstract class Array 
{	
	/**
	 * Generate the binary correspondent to the integer.
	 * @param input
	 * @return The binary number corresponding to the given integer.
	 */
	public static long binaryGenerator(int input)
    {
    	long digits = 0;//The number of digits that the inputed decimal number has.
		long media1;//An agent.
		long copy = input;//Assign a integer that equals to the input.
		long binary = 0;//Final form of the outputed binary in a form of integer.
    	while(copy!=0)//First figure out the number of digits of the decimal input will be when converted to binary.
    	{
    		media1 = copy % 2;//The general method of calculating the remainder.
    		copy/= 2;//Divide the value by 2 each time.
    		binary = binary + (long)(media1*Math.pow(10, digits));
    		digits++;//Add up the digits.
    	}
    	return binary;
    }
	
	/**
	 * Count the number of elements in a 2D array.
	 * @param input A 2D array to be counted.
	 * @return The number of elements of the given 2D array.
	 */
	public static int countEle(Object[][] input)
	{
		int count = 0;
		for(Object[] holder1: input)
			count+=holder1.length;
		return count;
	}
	
	
	/**
	 * Print the given array of elements. If only one element is present, print the element without adding square brackets. If multiple elements are present, each element is printed and separated with a comma and a space, and the elements are surrounded by a pair of square brackets. When encountering a 1D or 2D array as one of the element, print the array as it would of be printed if isolated, and treat this array as a whole as one element of the entire input array. 
	 * @param input The input array to be printed.
	 */
	@SafeVarargs
	public static <T> void printArray(T... input)//Print a list in a line with space between each element.
	{
		if(input.length==0)
		{
			System.out.println();
			return;
		}
		if(input instanceof Object[][])
		{
			System.out.print("[");
			for(int i=0; i<((Object[][])input).length; i++)
			{
				if(i==((Object[][])input).length-1)
				{
					helpArray(((Object[][])input)[i]);
					System.out.println("] ");
				}
				else
				{
					helpArray(((Object[][])input)[i]);
					System.out.print(", ");
				}
			}
			return;
		}
		if(input.length==1)
		{
			System.out.println(input[0]);
			return;
		}
		System.out.print("[");
		for(T holder: input)
		{
			if(holder instanceof Object[][])
			{
				System.out.print("[");
				for(int i=0; i<((Object[][])holder).length; i++)
				{
					if(i==((Object[][])holder).length-1)
					{
						helpArray(((Object[][])holder)[i]);
						if(holder.equals(input[input.length-1]))
						{
							System.out.println("]");
							return;
						}
						System.out.print("], ");
					}
					else
					{
						helpArray(((Object[][])holder)[i]);
						System.out.print(", ");
					}
				}
				continue;
			}
			if(holder instanceof Object[])
			{
				helpArray((Object[])holder);
				if(holder.equals(input[input.length-1]))
				{
					System.out.println("]");
					return;
				}
				System.out.print(", ");
				continue;
			}
			if(holder.equals(input[input.length-1]))
			{
				System.out.println(holder+"]");
				return;
			}
			System.out.print(holder+", ");
		}
	}
	
	/**
	 * A helper method to printArray.
	 * @param input The object array to be printed. 
	 */
	private static void helpArray(Object[] input)
	{
		System.out.print("[");
		if(input.length==0)
			System.out.print("]");
		for(int i=0; i<input.length; i++)
		{
			if(i==input.length-1)
				System.out.print(input[i]+"]");
			else
				System.out.print(input[i]+", ");
		}	
	}
	
	/**
	 * Print a dashed line.
	 */
	public static void printDash()
	{
		for(int i=0; i<50; i++)
			System.out.print("-");
		printArray();
	}
	
	/**
	 * Offer the string of a dashed line.
	 * @return the string of a dashed line.
	 */
	public static String dash()
	{
		StringBuilder builder = new StringBuilder();
		for(int i=0; i<50; i++)
			builder.append("-");
		builder.append("\n");
		return builder.toString();
	}
	
	/**
	 * Duplicate the 1D array using its wrapper class.
	 * @param input The inputed integer array.
	 * @return The Integer array of the wrapper class.
	 */
	public static Integer[] wrap(int[] input)
	{
		Integer[] output = new Integer[input.length];
		for(int i=0; i<input.length; i++)
			output[i] = input[i];
		return output;	
	}
	
	/**
	 * Duplicate the 1D double array using its wrapper class.
	 * @param input The inputed double array.
	 * @return The Double array of the wrapper class.
	 */
	public static Double[] wrap(double[] input)//Duplicate the 1D array using its wrapper class.
	{
		Double[] output = new Double[input.length];
		for(int i=0; i<input.length; i++)
			output[i] = input[i];
		return output;
	}
	
	/**
	 * Duplicate the 1D char array using its wrapper class.
	 * @param input The inputed char array.
	 * @return The Character array of the wrapper class.
	 */
	public static Character[] wrap(char[] input)//Duplicate the 1D array using its wrapper class.
	{
		Character[] output = new Character[input.length];
		for(int i=0; i<input.length; i++)
			output[i] = input[i];
		return output;
	}
	
	/**
	 * Duplicate the 1D long array using its wrapper class.
	 * @param input The inputed long array.
	 * @return The Long array of the wrapper class.
	 */
	public static Long[] wrap(long[] input)
	{
		Long[] output = new Long[input.length];
		for(int i=0; i<input.length; i++)
			output[i] = input[i];
		return output;
	}
	
	/**
	 * Duplicate the 2D array using its wrapper class.
	 * @param input The inputed integer array.
	 * @return The Integer array of the wrapper class.
	 */
	public static Integer[][] wrap(int[][] input)//Duplicate the 2D array using its wrapper class.
	{
		Integer[][] output = new Integer[input.length][];
		for(int i=0; i<input.length; i++)
			output[i] = wrap(input[i]);
		return output;
	}
	
	/**
	 * Duplicate the 2D array using its wrapper class.
	 * @param input The inputed double array.
	 * @return The Double array of the wrapper class.
	 */
	public static Double[][] wrap(double[][] input)//Duplicate the 2D array using its wrapper class.
	{
		Double[][] output = new Double[input.length][];
		for(int i=0; i<input.length; i++)
			output[i] = wrap(input[i]);
		return output;
	}
	
	/**
	 * Duplicate the 2D array using its wrapper class.
	 * @param input The inputed char array.
	 * @return The Character array of the wrapper class.
	 */
	public static Character[][] wrap(char[][] input)//Duplicate the 2D array using its wrapper class.
	{
		Character[][] output = new Character[input.length][];
		for(int i=0; i<input.length; i++)
			output[i] = wrap(input[i]);
		return output;
	}
	
	/**
	 * Duplicate the 2D array using its wrapper class.
	 * @param input The inputed long array.
	 * @return The Long array of the wrapper class.
	 */
	public static Long[][] wrap(long[][] input)//Duplicate the 2D array using its wrapper class.
	{
		Long[][] output = new Long[input.length][];
		for(int i=0; i<input.length; i++)
			output[i] = wrap(input[i]);
		return output;
	}
		
	/**
	 * Verify whether the content of an array composed of objects consist only of null references.
	 * @param sub The subject array to be examined.
	 * @return True if the array contains only null references, false otherwise.
	 */
	public static <T> boolean nullcheck(T[] sub)
	{
		for(int i=0; i<sub.length; i++)
			if(sub[i]!=null)
				return true;
		return false;
	}
	
	/**
	 * Merge the given objects into an object array.
	 * @param input A list of objects to be merged into an array.
	 * @return The merged array of objects with objects references.
	 */
	public static Object[] merge(Object... input)
	{
		Object[] output = new Object[input.length];
		for(int i=0; i<input.length; i++)
			output[i] = input[i];
		return output;
	}
	
	/**
	 * Merge the given object arrays into a 2D object array.
	 * @param input A list of object arrays.
	 * @return The merged 2D array of object arrays.
	 */
	public static Object[][] merge(Object[]... input)//Merge the given list of arrays into a 2D array.
	{
		Object[][] output = new Object[input.length][];
		for(int i=0; i<input.length; i++)
			output[i] = input[i];
		return output;
	}
	
	/**
	 * Cast the Integer array of the wrapper class to int array.
	 * @param input The Integer array to be down casted. 
	 * @return An int array casted from the Integer array inputed.
	 */
	public static int[] cast(Integer[] input)
	{
		int[] output = new int[input.length];
		for(int i=0; i<input.length; i++)
			output[i] = input[i];
		return output;
	}
	
	/**
	 * Cast the Double array of wrapper class to double array.
	 * @param input The Double array to be down casted.
	 * @return A double array casted from the Double wrapper array. 
	 */
	public static double[] cast(Double[] input)
	{
		double[] output = new double[input.length];
		for(int i=0; i<input.length; i++)
			output[i] = input[i];
		return output;
	}
	
	/**
	 * Cast the Character array of wrapper class to char array.
	 * @param input The Character array to be down casted.
	 * @return A char array casted from the Character wrapper array. 
	 */
	public static char[] cast(Character[] input)
	{
		char[] output = new char[input.length];
		for(int i=0; i<input.length; i++)
			output[i] = input[i];
		return output;
	}
	
	/**
	 * Cast the Long array of wrapper class to long array.
	 * @param input The Long array to be down casted.
	 * @return A long array casted from the Long wrapper array. 
	 */
	public static long[] cast(Long[] input)
	{
		long[] output = new long[input.length];
		for(int i=0; i<input.length; i++)
			output[i] = input[i];
		return output;
	}
	
	/**
	 * Cast the valid 1D array of Object reference into Integer reference.
	 * @param input The valid Object array whose elements are to be casted into Integers.
	 * @return The 1D array of Integers casted from the Object reference. 
	 */
	public static Integer[] castInt(Object[] input)
	{
		Integer[] output = new Integer[input.length];
		for(int i=0; i<input.length; i++)
			output[i] = (Integer)(input[i]);
		return output;
	}
	
	/**
	 * Cast the valid 1D array of Object reference into Double reference.
	 * @param input The valid Object array whose elements are to be casted into Doubles.
	 * @return The 1D array of Doubles casted from the Object reference.
	 */
	public static Double[] castDou(Object[] input)
	{
		Double[] output = new Double[input.length];
		for(int i=0; i<input.length; i++)
			output[i] = (Double)(input[i]);
		return output;
	}
	
	/**
	 * Cast the valid 1D array of Object reference into Character reference.
	 * @param input The valid Object array whose elements are to be casted into Characters.
	 * @return The 1D array of Characters casted from the Object reference.
	 */
	public static Character[] castChar(Object[] input)//Cast the valid 1D array of Object reference into Character reference.
	{
		Character[] output = new Character[input.length];
		for(int i=0; i<input.length; i++)
			output[i] = (Character)(input[i]);
		return output;
	}
	
	/**
	 * Cast the valid 1D array of Object reference into Long reference.
	 * @param input The valid Object array whose elements are to be casted into Longs.
	 * @return The 1D array of Long casted from the Object reference.
	 */
	public static Long[] castLong(Object[] input)//Cast the valid 1D array of Object reference into Long reference.
	{
		Long[] output = new Long[input.length];
		for(int i=0; i<input.length; i++)
			output[i] = (Long)(input[i]);
		return output;
	}
	
	/**
	 * Cast the valid 2D array of Object reference into Integer reference.
	 * @param input The valid 2D Object array whose elements are to be casted into Integers.
	 * @return The 2D array of Integers casted from the Object reference.
	 */
	public static Integer[][] castInt(Object[][] input)
	{
		Integer[][] output = new Integer[input.length][];
		for(int i=0; i<input.length; i++)
			output[i] = castInt(input[i]);
		return output;
	}
	
	/**
	 * Cast the valid 2D array of Object reference into Double reference.
	 * @param input The valid 2D Object array whose elements are to be casted into Doubles.
	 * @return The 2D array of Doubles casted from the Object reference.
	 */
	public static Double[][] castDou(Object[][] input)
	{
		Double[][] output = new Double[input.length][];
		for(int i=0; i<input.length; i++)
			output[i] = castDou(input[i]);
		return output;
	}
	
	/**
	 * Cast the valid 2D array of Object reference into Character reference.
	 * @param input The valid 2D Object array whose elements are to be casted into Characters.
	 * @return The 2D array of Characters casted from the Object reference.
	 */
	public static Character[][] castChar(Object[][] input)
	{
		Character[][] output = new Character[input.length][];
		for(int i=0; i<input.length; i++)
			output[i] = castChar(input[i]);
		return output;
	}
	
	/**
	 * Cast the valid 2D array of Object reference into Long reference.
	 * @param input The valid 2D Object array whose elements are to be casted into Longs.
	 * @return The 2D array of Longs casted from the Object reference.
	 */
	public static Long[][] castLong(Object[][] input)
	{
		Long[][] output = new Long[input.length][];
		for(int i=0; i<input.length; i++)
			output[i] = castLong(input[i]);
		return output;
	}
	
	/**
	 * Reverse the given 1D array.
	 * @param input The 1D array to be reversed.
	 */
	public static void reverse(Object[] input)
	{
		for(int i=0; i<input.length/2; i++)
		{
			Object temp = input[i];
			input[i] = input[input.length-1-i];
			input[input.length-1-i] = temp;
		}
	}
	
	/**
	 * Reverse the valid given 2D array.
	 * @param input The valid 2D array to be reversed.
	 */
	public static void reverse(Object[][] input)//Reverse the given 2D array.
	{
		int limit = countEle(input)/2;
		int counter = 0;
		label:
		for(int i=0; i<input.length; i++)
		{
			for(int j=0; j<input[i].length; j++)
			{
				Object temp = input[i][j];
				input[i][j] = input[input.length-1-i][input[input.length-1-i].length-1-j];
				input[input.length-1-i][input[input.length-1-i].length-1-j] = temp;
				if(++counter>=limit)
					break label;
			}
		}
	}

	/**
	 * Search for the desired item by linear search. 
	 * @param input The array to be searched. 
	 * @param tar The targeted element. 
	 * @return the index of the element. -1 if not found in the given array. 
	 */
	public static <T> int linearSearch(T[] input, T tar)
	{
		for(int i=0; i<input.length; i++)
			if(input[i].equals(tar))
				return i;
		return -1;
	}
	
	/**
	 * Search for the targeted item in a collection via linear search.
	 * @param input the inputed collection to be searched.
	 * @param tar The targeted item.
	 * @return The index of the item targeted.
	 */
	public static <T> int linearSearch(Collection<T> input, T tar)
	{
		Iterator<T> pointer = input.iterator();
		int counter = 0;
		while(pointer.hasNext())
			if(pointer.next().equals(tar))
				return counter;
			else 
				counter++;
		return -1;
	}
	
	/**
	 * Get an item in a collection based on its index. This method is designed for contingent use; an abuse of usage of it alone, or the coupling with linear searches may lead to unreasonable run time. 
	 * @param input The collection to be fetched from according to the index.
	 * @param index The index of the element to be fetched. 
	 * @return
	 */
	public static <T> T get(Collection<T> input, int index)
	{
		Iterator<T> pointer = input.iterator();
		int counter = 0;
		while(pointer.hasNext())
			if(counter<index)
			{
				pointer.next();
				counter++;
			}
			else
				return pointer.next();
		throw new IndexOutOfBoundsException("The Given Index exceeds the Valid Maximum Index of the Collection.");
	}
	
	public static <T extends Comparable<? super T>> Integer[] linearSearch(T[][] input, T tar)
	{
		for(int i=0; i<input.length; i++)
			for(int j=0; j<input[i].length; j++)
				if(input[i][j].equals(tar))
					return new Integer[]{i,j};
		return new Integer[]{-1,-1};
	}
	
	public static <T extends Comparable<? super T>> int binarySearch(T[] input, T tar)
	{
		sort(input);
		return binarySearching(input,tar,0,input.length-1);
	}
	
	public static <T extends Comparable<? super T>> int binarySearching(T[] input, T tar, int ini, int fin)
	{
		if(fin-ini==0)
		{
			if(input[ini].equals(tar))
				return ini;
			return -1;
		}
		int mid = (ini+fin)/2;
		if(input[mid].compareTo(tar)==0)
			return mid;
		if(input[mid].compareTo(tar)>0)
			return binarySearching(input,tar,ini,mid-1);
		return binarySearching(input,tar,mid+1,fin);
	}
	
	public static <T extends Comparable<? super T>> int binarySearching(List<T> input, T tar, int ini, int fin)
	{
		if(fin-ini==0)
		{
			if(input.get(ini).equals(tar))
				return ini;
			return -1;
		}
		int mid = (ini+fin)/2;
		if(input.get(mid).compareTo(tar)==0)
			return mid;
		if(input.get(mid).compareTo(tar)>0)
			return binarySearching(input,tar,ini,mid-1);
		return binarySearching(input,tar,mid+1,fin);
	}
	
	public static <T extends Comparable<? super T>> void sort(T[] data)//Sort the array in ascending order.
	{
		HeapSort.treeMax(data);
		HeapSort.sortMin(data);
	}
	
	public static <T extends Comparable<? super T>> void sortMax(T[] data)
	{
		sort(data);
		reverse(data);
	}
	
	private static class HeapSort
	{
		private static int level;
		
		public static <T extends Comparable<? super T>> void treeMax(T[] input)//Create a maximum binary tree.
		{
			for(int i=input.length-1; i>0; i--)
			{
				level = (int)(Mathematics.logBase(2,i+1));
				int after = (int)(Math.pow(2, level+1))-2-i;
				int corInd = (int)(Math.pow(2, level))-2-after/2;
				if(reverseMax(input,i,corInd))
				{
					flip(input,i, corInd);
					traceMax(input,i);
				}
			}
		}
		
		public static <T extends Comparable<? super T>> boolean reverseMax(T[] input, int index, int corInd)//Judge the element at the given index with its upward correspondence.
		{
			if(input[index].compareTo(input[corInd])>0)
				return true;
			return false;
		}
		
		public static <T extends Comparable<? super T>> void flip(T[] input, int index, int corInd)
		{
			T temp = input[index];
			input[index] = input[corInd];
			input[corInd] = temp;
		}
		
		public static <T extends Comparable<? super T>> void traceMax(T[] input, int index)
		{
			level = (int)(Mathematics.logBase(2, index+1));
			boolean judge1 = false;
			boolean judge2 = false;
			int after = (int)(Math.pow(2,level+1))-2-index;
			int down = (int)(Math.pow(2, level+2))-2-after*2;
			if(down-1>=input.length)
				return;
			if(down==input.length)
			{
				if(input[down-1].compareTo(input[index])>0)
				{
					T temp = input[index];
					input[index] = input[down-1];
					input[down-1] = temp;
				}
				return;
			}
			if(input[down].compareTo(input[index])>0)
			{
				T temp = input[index];
				input[index] = input[down];
				input[down] = temp;
				judge1 = true;
			}
			if(input[down-1].compareTo(input[index])>0)
			{
				T temp = input[index];
				input[index] = input[down-1];
				input[down-1] = temp;
				judge2 = true;
			}
			if(judge1)
				traceMax(input,down);
			if(judge2)
				traceMax(input,down-1);
		}
		
		public static <T extends Comparable<? super T>> void sortMin(T[] input)
		{
			for(int i=input.length-1; i>0; i--)
			{
				T temp = input[i];
				input[i] = input[0];
				input[locateMax(input,0,i,temp)] = temp;
			}
		}
		
		public static <T extends Comparable<? super T>> int locateMax(T[] input, int index, int limit, T holder)
		{
			level = (int)(Mathematics.logBase(2, index+1));
			int after = (int)(Math.pow(2,level+1))-2-index;
			int down = (int)(Math.pow(2, level+2))-2-after*2;
			if(down-1>=limit)
				return index;
			if(down==limit)
			{
				if(input[down-1].compareTo(holder)>0)
				{
					input[index] = input[down-1];
					return down-1;
				}else
					return index;
			}
			if(holder.compareTo(input[down])<0||holder.compareTo(input[down-1])<0)
			{
				if(input[down].compareTo(input[down-1])>0)
				{
					input[index] = input[down];
					return locateMax(input,down,limit,holder);
				}else
				{
					input[index] = input[down-1];
					return locateMax(input,down-1,limit,holder);
				}
			}
			return index;
		}
	}
	
	public static<T extends Comparable<? super T>> T[][] partialSort(T[][] input)//Sort the two dimensional array within each array contained with insertion sort.
	{
		for(int i=0; i<input.length; i++)
			sort(input[i]);
		return input;
	}
	
	public static Integer randomInt(Integer lowLim, Integer upLim)
	{
		return lowLim + (int)(Math.random()*(upLim-lowLim));
	}
	
	public static Double randomDou(Double lowLim, Double upLim)
	{
		return lowLim + (Math.random()*(upLim-lowLim));
	}
	
	public static Integer[] randomInt(Integer lowLim, Integer upLim, int size)//Generate an array of random integers with specific range and quantity.
	{
		Integer[] rand = new Integer[size];
		Integer amplitude = upLim-lowLim;
		for(int i=0; i<size; i++)
			rand[i] = (int)(amplitude*Math.random()) + lowLim;
		return rand;
	}
	
	public static List<Integer> randomIntL(Integer lowLim, Integer upLim, int size)//Generate an array of random integers with specific range and quantity.
	{
		List<Integer> rand = new LinkedList<Integer>();
		Integer amplitude = upLim-lowLim;
		for(int i=0; i<size; i++)
			rand.add((int)(amplitude*Math.random()) + lowLim);
		return rand;
	}
	
	public static int[] randomint(int lowLim, int upLim, int size)//Generate an array of random integers with specific range and quantity.
	{
		int[] rand = new int[size];
		int amplitude = upLim-lowLim;
		for(int i=0; i<size; i++)
			rand[i] = (int)(amplitude*Math.random()) + lowLim;
		return rand;
	}
	
	public static Double[] randomDou(Double lowLim, Double upLim, int size)//Generate an array of random doubles with specific range and quantity. 
	{
		Double[] rand = new Double[size];
		Double amplitude = upLim-lowLim;
		for(int i=0; i<size; i++)
			rand[i] = amplitude*Math.random() + lowLim;
		return rand;
	}
	
	public static double[] randomdou(double lowLim, double upLim, int size)//Generate an array of random doubles with specific range and quantity. 
	{
		double[] rand = new double[size];
		double amplitude = upLim-lowLim;
		for(int i=0; i<size; i++)
			rand[i] = amplitude*Math.random() + lowLim;
		return rand;
	}
	
	public static Integer[][] randomInt2(Integer min, Integer max, int arrayLength, int arrayNum)//Generate a 2D array of random integers with specific range and quantity. 
	{
		Integer[][] rand = new Integer[arrayNum][arrayLength];
		for(int i=0; i<arrayNum; i++)
			rand[i] = randomInt(min,max,arrayLength);
		return rand;
	}
	
	public static int[][] randomint2(int min, int max, int arrayLength, int arrayNum)//Generate a 2D array of random integers with specific range and quantity. 
	{
		int[][] rand = new int[arrayNum][arrayLength];
		for(int i=0; i<arrayNum; i++)
			rand[i] = randomint(min,max,arrayLength);
		return rand;
	}
	
	public static Double[][] randomDou2(Double min, Double max, int arrayLength, int arrayNum)//Generate a 2D array of random doubles with specific range and quantity. 
	{
		Double[][] rand = new Double[arrayNum][arrayLength];
		for(int i=0; i<arrayNum; i++)
			rand[i] = randomDou(min,max,arrayLength);
		return rand;
	}
	
	public static double[][] randomdou2(double min, double max, int arrayLength, int arrayNum)//Generate a 2D array of random doubles with specific range and quantity. 
	{
		double[][] rand = new double[arrayNum][arrayLength];
		for(int i=0; i<arrayNum; i++)
			rand[i] = randomdou(min,max,arrayLength);
		return rand;
	}
	
//	public static long hash(String arg)
//	{
//		int len = arg.length();
//		double rand = Math.random();
//		long output = (long)Math.pow(10, len+1);
//		String copy = new String(arg);
//		if(copy.toLowerCase().equals(arg))
//		{
//			output += len/10*(int)rand;
//			//output += 
//			
//		}
//	}
	
	/**
	 * Verify if two arrays of the same reference type have the same elements in identical sequence.
	 * @param a The first array.
	 * @param b The second array.
	 * @return true if the two arrays contains the 
	 */
	public static <T> boolean verify(T[] a, T[] b)
	{
		if(a.length!=b.length)
		{
			printArray("Sizes Don't Match");
			return false;
		}
		for(int i=0; i<a.length; i++)
		{
			if(!a[i].equals(b[i]))
			{
				System.out.println("Mismatch");
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Duplicate the array in the second spare array provided in the argument. If the spare array has a size not matching the one to be copied, return the spare array.
	 * @param input The array to be duplicated.
	 * @param spare The array to be inscribed with the same element from the first.
	 * @return If size of the spare array is qualified
	 */
	public static <T> T[] dup(T[] input, T[] spare)
	{
		if(input.length!=spare.length)
		{
			printArray("Mismatching Array Length");
			return spare; 
		}
		for(int i=0; i<input.length; i++)
			spare[i] = input[i];
		return spare;
	}
	
	
	/**
	 * Inscribe the given list of elements into a list.
	 * @param input A list to be listed.
	 * @return A list consists of the elements inputed as the vararg.
	 */
	@SafeVarargs
	public static <T> List<T> list(T... input)
	{
		ArrayList<T> output = new ArrayList<T>(input.length);
		for(T holder: input)
			output.add(holder);
		return output;
	}
	
	public static <T> List<T> dup(List<T> input)
	{
		ArrayList<T> output = new ArrayList<T>();
		for(T holder: input)
			output.add(holder);
		return output;
	}
	
	public static <T> T[] arr(List<T> input, T[] spare)
	{
		if(input.size()!=spare.length)
		{
			printArray("Mismatching Array Sizes");
			return spare;
		}
		for(int i=0; i<input.size(); i++)
			spare[i] = input.get(i);
		return spare;
	}
	
	@SafeVarargs
	/**
	 * Append the vararg list at the given index of the array.
	 * @param input The array list to be manipulated.
	 * @param index The index to append.
	 * @param app The list to be appended.
	 * @return The array list after the appending.
	 */
	public static <T> ArrayList<T> append(ArrayList<T> input, int index, T... app)
	{
		for(int i=0; i<app.length; i++)
			input.add(index+1+i,app[i]);
		return input;
	}
	
	/**
	 * Compare the contents of the two collections based on their sequence. 
	 * @param fir The first collection.
	 * @param sec The second collection.
	 * @return True if both contain identical elements in identical sequence, false otherwise.
	 */
	public static <T> boolean verify(Collection<T> fir, Collection<T> sec)
	{
		if(fir.size()!=sec.size())
			return false;
		Iterator<T> pointer1 = fir.iterator();
		Iterator<T> pointer2 = sec.iterator();
		while(pointer1.hasNext())
			if(!pointer1.next().equals(pointer2.next()))
				return false;
		return true;
	}
	
	/**
	 * Compare the contents of two lists regardless of the the sequence they appear.
	 * @param fir The first collection.
	 * @param sec The second collection.
	 * @return True if two collections share the same elements, false otherwise.
	 */
	public static <T extends Comparable<? super T>> boolean verifyCon(List<T> fir, List<T> sec)
	{
		Collections.sort(fir);
		Collections.sort(sec);
		return verify(fir,sec);
	}
	
	/**
	 * Compare the contents of two lists regardless of the the sequence they appear.
	 * @param fir The first collection.
	 * @param sec The second collection.
	 * @return True if two collections share the same elements, false otherwise.
	 */
	public static <T extends Comparable<? super T>> boolean verifyCon(Set<T> fir, Set<T> sec)
	{
		List<T> firs = new ArrayList<T>(fir);
		List<T> secd = new ArrayList<T>(sec);
		Collections.sort(firs);
		Collections.sort(secd);
		return verify(firs,secd);
	}
	
	/**
	 * Regulate the copy of the given map in the sequence of the given key set.
	 * @param tar The map to be rearranged. 
	 * @param seq The key set.
	 * @return An empty map if the given key set does not match the key set of the map, a new map containing the same entries rearranged in the sequence of the set given otherwise.
	 */
	public static <A extends Comparable<? super A>,B> Map<A,B> regulate(Map<A,B> tar, Set<A> seq)
	{
		Map<A,B> output = new LinkedHashMap<A,B>();
		if(!verifyCon(tar.keySet(),seq))
		{
			printArray("Error, Mismatching Key Sets");
			return output;
		}
		for(A holder: seq)
			output.put(holder, tar.get(holder));
		return output;
	}
	
	/**
	 * An inner helper comparator intended to compare the arguments based on their given values in a parallel map. By applying this inner class, erroneous computation may occur in the tree map if the put method is executed twice for the same key in its defining value.
	 *
	 * @param <T>
	 */
	private static class Freq<T> implements Comparator<T>
	{
		private Map<T,Integer> in;
		
		public Freq(Map<T,Integer> input)
		{
			in = input;
		}
		
		/**
		 * Compare the two arguments  based on their given value in the properly computed inner map.
		 */
		public int compare(T arg0, T arg1)
		{
			if(in.get(arg0)==null)
				return arg1==null?0:1;
			if(in.get(arg1)==null)
				return arg0==null?0:-1;
			if(in.get(arg0)==in.get(arg1))
				return 0;
			return in.get(arg0)>in.get(arg1)?-1:1;
		}
	}
	
	/**
	 * Record the sorted frequency of the elements contained in the Collection.
	 * @param input
	 * @return The tree map of the sorted entries in terms of their frequencies.
	 */
	public static <T> TreeMap<T,Integer> freSort(Collection<T> input)
	{
		Map<T,Integer> parallel = new HashMap<T,Integer>();
		TreeMap<T,Integer> output = new TreeMap<T,Integer>(new Freq<T>(parallel));
		for(T holder: input)
			parallel.put(holder, parallel.get(holder)==null?1:parallel.get(holder)+1);
		for(T holder: parallel.keySet())
			output.put(holder, parallel.get(holder));
		return output;
	}
	
	/**
	 * Measure the frequency of the appearance of identical elements.
	 * @param input
	 * @return The map with the keys as elements in the collection and the values as integers of the counts of the occurrences.
	 */
	public static <T extends Comparable<? super T>> Map<T,Integer> freq(List<T> input)
	{
		Map<T,Integer> output = new HashMap<T,Integer>();
		for(T holder: input)
			output.put(holder, output.get(holder)==null?1:output.get(holder)+1);
		return output;
	}		
	
	/**
	 * Ascribe a list of the corresponding values base on the input list of the keys, and the given template as a map.
	 * @param template The map containing the keys and entries.
	 * @param mat The list containing the keys to be evaluated.
	 * @return The list containing the values in the sequence of the keys inputed as the list.
	 */
	public static <A,B> List<B> ascribe(Map<A,B> template, Collection<A> mat)
	{
		ArrayList<B> output = new ArrayList<B>();
		for(A holder: mat)
			output.add(template.get(holder));
		return output;
	}
	
	/**
	 * Initialize a map with two equal sized sets.
	 * @param one The key set.
	 * @param two The value set.
	 * @return If dismatching size, return empty map.
	 */
	public static <A,B> Map<A,B> map(Set<A> key, Collection<B> values)
	{
		Map<A,B> output = new HashMap<A,B>();
		if(key.size()!=values.size())
			throw new SizeMismatchException("Mismatching Sizes of Keys and Values");
		Iterator<A> pointer1 = key.iterator();
		Iterator<B> pointer2 = values.iterator();
		while(pointer1.hasNext())
			output.put(pointer1.next(), pointer2.next());
		return output;
	}
	
	
	public static <A,B> Map<A,B> map(A[] key, B[] values)
	{
		Set<A> keySet = new LinkedHashSet<A>();
		Collections.addAll(keySet,key);
		if(keySet.size()!=values.length)
			throw new SizeMismatchException("Mismatching Sizes of Keys and Values");
		return map(keySet,list(values));
	}
	
	public static Integer[] indexArr(int indexFin)
	{
		Integer[] output = new Integer[indexFin+1];
		for(int i=0; i<=indexFin; i++)
			output[i] = i;
		return output;
	}
	
	public static <T> Map<Integer,T> map(T[] input)
	{
		return map(indexArr(input.length-1),input);
	}
	
	/**
	 * Check if the list contains duplicate elements.
	 * @param input The inputed list.
	 * @return true if the collection contains no duplicate elements, false otherwise.
	 */
	public static <T> boolean settable(List<T> input)
	{
		for(int i=0; i<input.size(); i++)
		{
			Iterator<T> pointer = input.listIterator(i+1);
			while(pointer.hasNext())
				if(pointer.next().equals(input.get(i)))
					return false;
		}
		return true;
	}
	
	/**
	 * Check if the Collection contains duplicate elements.
	 * @param input The inputed list.
	 * @return true if the collection contains no duplicate elements, false otherwise.
	 */
	public static <T> boolean settable(Collection<T> input)
	{
		Iterator<T> pointer1 = input.iterator();
		for(int i=0; i<input.size(); i++)
		{
			Iterator<T> pointer2 = input.iterator();
			for(int counter=0; counter<i; counter++)
				pointer2.next();
			while(pointer2.hasNext())
				if(pointer1.next().equals(pointer2.next()))
					return false;
		}
		return true;
	}
	
	/**
	 * Construct a set given by the inputed list. Warning appears if the list contains dulicate elements.
	 * @param input The inputed list.
	 * @return The resultant set.
	 */
	public static <T> Set<T> set(List<T> input)
	{
		if(!settable(input))
			printArray("Warning! Duplicate Elements.");
		Set<T> output = new LinkedHashSet<T>();
		for(T holder: input)
			output.add(holder);
		return output;
	}
	
	/**
	 * Check if the collection contains duplicate elements.
	 * @param input The inputed collection.
	 * @return true if the collection contains no duplicate elements, false otherwise.
	 */
	public static <T> Set<T> set(Collection<T> input)
	{
		if(!settable(input))
			printArray("Warning! Duplicate Elements.");
		Set<T> output = new LinkedHashSet<T>();
		for(T holder: input)
			output.add(holder);
		return output;
	}
	
	
	public static <T extends Comparable<? super T>> Set<T> sort(Set<T> input)
	{
		List<T> media = new LinkedList<T>(input);
		Collections.sort(media);
		return input = new LinkedHashSet<T>(media);
	}
	
	public static <A extends Comparable<? super A>,B extends Comparable<? super B>> void sort(Map<A,B> input)
	{
		Set<A> keys = input.keySet();
		sort(keys);
		regulate(input,keys);
	}
	
	
	public static <A,B> Map<B,A> inverse(Map<A,B> input)
	{
		return map(new LinkedHashSet<B>(input.values()),input.keySet());
	}
	/**
	 * The desired element is not present in the container or array being searched. 
	 *
	 */
	public static class ElementNotExistException extends RuntimeException
	{
		private static final long serialVersionUID = 700;
		
		public ElementNotExistException()
		{
			super();
		}
		
		public ElementNotExistException(String info)
		{
			super(info);
		}
		
		public ElementNotExistException(Exception cause)
		{
			super(cause);
		}
	}
	
	/**
	 * The two containers or arrays compared are of a size discrepancy and thereby cannot be compared.
	 *
	 */
	public static class SizeMismatchException extends RuntimeException
	{
		private static final long serialVersionUID = 701;
		
		public SizeMismatchException()
		{
			super();
		}
		
		public SizeMismatchException(String info)
		{
			super(info);
		}
		
		public SizeMismatchException(Exception cause)
		{
			super(cause);
		}
	}
	
	public static class NoneSuperException extends RuntimeException
	{
		private static final long serialVersionUID = 702;
		
		public NoneSuperException()
		{
			super();
		}
		
		public NoneSuperException(String info)
		{
			super(info);
		}
		
		public NoneSuperException(Exception info)
		{
			super(info);
		}
	}
	
	public static void log(Exception ex)
	{
		Logger log = Logger.getLogger("Exception Logging");
		StringWriter wri = new StringWriter();
		ex.printStackTrace(new PrintWriter(wri));
		log.severe(wri.toString());
	}
	
	/**
	 * Computed the frequencies of the objects contained in the collection by their type information. The effect of inheritance is included in the computation which does not include that of interfaces.
	 * @param input The collection of objects to be computed of the type frequency.
	 * @return A map with the types of classes as the keys and the corresponding frequencies as the values.
	 */
	public static <T> Map<Class<?>,Integer> typeFre(Collection<T> input)
	{
		return new HashMap<Class<?>,Integer>()
		{
			private static final long serialVersionUID = 101;
			
			{
				for(T holder: input)
					count(holder.getClass());
			}
			
			private void count(Class<?> ref)
			{
				if(ref==Object.class)
					return;
				put(ref,!containsKey(ref)?1:get(ref)+1);
				count(ref.getSuperclass());
			}
			
			public String toString()
			{
				Pattern pat = Pattern.compile("\\s[^[A-Z]&&^,]*+([A-Z]\\w*=)");
				Matcher mat = pat.matcher(super.toString());
				StringBuffer buff = new StringBuffer();
				while(mat.find())
					mat.appendReplacement(buff,"$1");
				mat.appendTail(buff);
				return buff.toString();
			}
		};
	}
	
	public static void classInfo(Class<?> ref)
	{
		printArray("Constructors");
		Constructor<?>[] cons = ref.getConstructors();
		for(Constructor<?> holder: cons)
			printArray(holder.toString().replaceAll("\\w*+\\.",""));
		printDash();
		printArray("Fields");
		Field[] fields = ref.getFields();
		for(Field holder: fields)
			printArray(holder.toString().replaceAll("\\w*+\\.",""));
		printDash();
//		printArray("Inner Classes");
//		Class<?>[] classes = ref.getEnclosingClass();
//		for(Class<?> holder: classes)
//			printArray(holder.toString().replaceAll("\\w*+\\.",""));
		printArray("Methods");
		Method[] methods = ref.getMethods();
		for(Method holder: methods)
			printArray(holder.toString().replaceAll("\\w*+\\.",""));
		
	}

	
	
	public static void main(String[] args) 
	{		
//		Integer[] tester = randomInt(-1000,1000,1000000);
//		Integer[] tester2 = dup(tester,new Integer[1000000]);
//		Timer.timerStart();
//		printArray(binarySearch(tester,10));
//		Timer.timerStop();
//		Timer.timerStart();
//		printArray(linearSearch(tester2,10));
//		Timer.timerStop();
//		ArrayList<Integer> tester = new ArrayList<Integer>();
//		Collections.addAll(tester, 1,2);
//		printArray(settable(tester));
//		printDash();
//		HashSet<Integer> see = new LinkedHashSet<Integer>();
//		Collections.addAll(see,5,4,3,2,1);
//		printArray(get(see,3));
		List<Object> tester = new ArrayList<Object>();
		Collections.addAll(tester, "A",5,2,"2",new Error("Error"),5.274);
		String see = typeFre(tester).toString();
		printArray(see);
	}

}
