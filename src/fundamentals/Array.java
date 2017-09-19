package fundamentals;
import java.util.*;

public abstract class Array 
{
	private static int level;
	
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
	
	public static int countEle(Object[][] input)//Count the number of elements in a 2D array.
	{
		int count = 0;
		for(Object[] holder1: input)
			count+=holder1.length;
		return count;
	}
	
	@SafeVarargs
	public static <T> void printArray(T... input)//Print a list in a line with space between each element.
	{
		if(input instanceof Object[][])
		{
			System.out.print("[");
			for(int i=0; i<((Object[][])input).length; i++)
			{
				if(i==((Object[][])input).length-1)
				{
					helpArray(((Object[][])input)[i]);
					System.out.print("] ");
				}
				else
				{
					helpArray(((Object[][])input)[i]);
					System.out.print(", ");
				}
			}
			return;
		}
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
						System.out.print("] ");
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
				System.out.print(" ");
				continue;
			}
			System.out.print(holder+" ");
		}
		System.out.println();
	}
	
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
	
	public static Integer[] wrap(int[] input)//Duplicate the 1D array using its wrapper class.
	{
		Integer[] output = new Integer[input.length];
		for(int i=0; i<input.length; i++)
			output[i] = input[i];
		return output;	
	}
	
	public static Double[] wrap(double[] input)//Duplicate the 1D array using its wrapper class.
	{
		Double[] output = new Double[input.length];
		for(int i=0; i<input.length; i++)
			output[i] = input[i];
		return output;
	}
	
	public static Character[] wrap(char[] input)//Duplicate the 1D array using its wrapper class.
	{
		Character[] output = new Character[input.length];
		for(int i=0; i<input.length; i++)
			output[i] = input[i];
		return output;
	}
	
	public static Long[] wrap(long[] input)
	{
		Long[] output = new Long[input.length];
		for(int i=0; i<input.length; i++)
			output[i] = input[i];
		return output;
	}
	
	public static Integer[][] wrap(int[][] input)//Duplicate the 2D array using its wrapper class.
	{
		Integer[][] output = new Integer[input.length][];
		for(int i=0; i<input.length; i++)
			output[i] = wrap(input[i]);
		return output;
	}
	
	public static Double[][] wrap(double[][] input)//Duplicate the 2D array using its wrapper class.
	{
		Double[][] output = new Double[input.length][];
		for(int i=0; i<input.length; i++)
			output[i] = wrap(input[i]);
		return output;
	}
	
	public static Character[][] wrap(char[][] input)//Duplicate the 2D array using its wrapper class.
	{
		Character[][] output = new Character[input.length][];
		for(int i=0; i<input.length; i++)
			output[i] = wrap(input[i]);
		return output;
	}
	
	public static Long[][] wrap(long[][] input)//Duplicate the 2D array using its wrapper class.
	{
		Long[][] output = new Long[input.length][];
		for(int i=0; i<input.length; i++)
			output[i] = wrap(input[i]);
		return output;
	}
		
	public static Object[] merge(Object... input)//Merge the given objects into an array.
	{
		Object[] output = new Object[input.length];
		for(int i=0; i<input.length; i++)
			output[i] = input[i];
		return output;
	}
	
	public static Object[][] merge(Object[]... input)//Merge the given list of arrays into a 2D array.
	{
		Object[][] output = new Object[input.length][];
		for(int i=0; i<input.length; i++)
			output[i] = input[i];
		return output;
	}
	
	public static int[] cast(Integer[] input)//Cast the 1D Integer[] into int[].
	{
		int[] output = new int[input.length];
		for(int i=0; i<input.length; i++)
			output[i] = input[i];
		return output;
	}
	
	public static double[] cast(Double[] input)//Cast the 1D Double[] into double[].
	{
		double[] output = new double[input.length];
		for(int i=0; i<input.length; i++)
			output[i] = input[i];
		return output;
	}
	
	public static char[] cast(Character[] input)//Cast the 1D Character[] into char[].
	{
		char[] output = new char[input.length];
		for(int i=0; i<input.length; i++)
			output[i] = input[i];
		return output;
	}
	
	public static long[] cast(Long[] input)//Cast the 1D Long[] into long[].
	{
		long[] output = new long[input.length];
		for(int i=0; i<input.length; i++)
			output[i] = input[i];
		return output;
	}
	
	public static Integer[] castInt(Object[] input)//Cast the valid 1D array of Object reference into Integer reference.
	{
		Integer[] output = new Integer[input.length];
		for(int i=0; i<input.length; i++)
			output[i] = (Integer)(input[i]);
		return output;
	}
	
	public static Double[] castDou(Object[] input)//Cast the valid 1D array of Object reference into Double reference.
	{
		Double[] output = new Double[input.length];
		for(int i=0; i<input.length; i++)
			output[i] = (Double)(input[i]);
		return output;
	}
	
	public static Character[] castChar(Object[] input)//Cast the valid 1D array of Object reference into Character reference.
	{
		Character[] output = new Character[input.length];
		for(int i=0; i<input.length; i++)
			output[i] = (Character)(input[i]);
		return output;
	}
	
	public static Long[] castLong(Object[] input)//Cast the valid 1D array of Object reference into Long reference.
	{
		Long[] output = new Long[input.length];
		for(int i=0; i<input.length; i++)
			output[i] = (Long)(input[i]);
		return output;
	}
	
	public static Integer[][] castInt(Object[][] input)//Cast the valid 2D array of Object reference into Integer reference.
	{
		Integer[][] output = new Integer[input.length][];
		for(int i=0; i<input.length; i++)
			output[i] = castInt(input[i]);
		return output;
	}
	
	public static Double[][] castDou(Object[][] input)//Cast the valid 2D array of Object reference into Double reference.
	{
		Double[][] output = new Double[input.length][];
		for(int i=0; i<input.length; i++)
			output[i] = castDou(input[i]);
		return output;
	}
	
	public static Character[][] castChar(Object[][] input)//Cast the valid 2D array of Object reference into Character reference.
	{
		Character[][] output = new Character[input.length][];
		for(int i=0; i<input.length; i++)
			output[i] = castChar(input[i]);
		return output;
	}
	
	public static Long[][] castLong(Object[][] input)//Cast the valid 2D array of Object reference into Long reference.
	{
		Long[][] output = new Long[input.length][];
		for(int i=0; i<input.length; i++)
			output[i] = castLong(input[i]);
		return output;
	}
	
	public static Object[] reverse(Object[] input)//Reverse the given 1D array.
	{
		for(int i=0; i<input.length/2; i++)
		{
			Object temp = input[i];
			input[i] = input[input.length-1-i];
			input[input.length-1-i] = temp;
		}
		return input;
	}
	
	public static Object[][] reverse(Object[][] input)//Reverse the given 2D array.
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
		return input;
	}

	public static <T extends Comparable<? super T>> int linearSearch(T[] input, T tar)
	{
		for(int i=0; i<input.length; i++)
			if(input[i].equals(tar))
				return i;
		return -1;
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
		if(input[mid].compareTo(tar)>0)
			return binarySearching(input,tar,ini,mid);
		return binarySearching(input,tar,mid+1,fin);
	}
	
	public static <T extends Comparable<? super T>> T[] sort(T[] data)//Sort the array in ascending order.
	{
		HeapSort.treeMax(data);
		HeapSort.sortMin(data);
		return data;
	}
	
	private static class HeapSort
	{
		
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
		ArrayList<T> output = new ArrayList<T>();
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
	public static <T> boolean compare(Collection<T> fir, Collection<T> sec)
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
	 * Compare the contents of two collections regardless of the the sequence they appear.
	 * @param fir The first collection.
	 * @param sec The second collection.
	 * @return True if two collections share the same elements, false otherwise.
	 */
	public static <T extends Comparable<? super T>> boolean compareCon(List<T> fir, List<T> sec)
	{
		Collections.sort(fir);
		Collections.sort(sec);
		return compare(fir,sec);
	}
	
	/**
	 * Regulate the copy of the given map in the sequence of the given key set.
	 * @param tar The map to be rearranged. 
	 * @param seq The key set.
	 * @return An empty map if the given key set does not match the key set of the map, a new map containing the same entries rearranged in the sequence of the set given otherwise.
	 */
	public static <A,B> Map<A,B> regulate(Map<A,B> tar, Set<A> seq)
	{
		Map<A,B> output = new LinkedHashMap<A,B>();
		if(!compare(tar.keySet(),seq))
		{
			printArray("Error, Dismatching Key Sets");
			return output;
		}
		for(A holder: seq)
			output.put(holder, tar.get(holder));
		return output;
	}
	
	/**
	 * Measure the frequency of the appearance of identical elements.
	 * @param input
	 * @return The map with the keys as elements in the collection and the values as integers of the counts of the occurrences.
	 */
	public static <T> Map<T,Integer> freq(Collection<T> input)
	{
		Set<T> key = new TreeSet<T>();
		for(T holder: input)
			key.add(holder);
		Map<T,Integer> output = new LinkedHashMap<T,Integer>();
		for(T holder1: key)
		{
			int counter = 0;
			for(T holder2: input)
				if(holder1.equals(holder2))
					counter++;
			output.put(holder1, counter);
		}
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
	public static <A,B> Map<A,B> initialize(Set<A> key, Set<B> values)
	{
		Map<A,B> output = new LinkedHashMap<A,B>();
		if(key.size()!=values.size())
		{
			printArray("Dismatching Size!");
			return output;
		}
		Iterator<A> pointer1 = key.iterator();
		Iterator<B> pointer2 = values.iterator();
		while(pointer1.hasNext())
			output.put(pointer1.next(), pointer2.next());
		return output;
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
		ArrayList<Integer> tester = new ArrayList<Integer>();
		Collections.addAll(tester, 1,2);
		printArray(settable(tester));
	}

}
