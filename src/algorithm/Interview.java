package algorithm;
import java.util.*;

public class Interview 
{

	public static boolean unique(String input)
	{
		for(int i=0; i<input.length(); i++)
		{
			for(int j=i+1; j<input.length(); j++)
			{
				if(input.charAt(i)==input.charAt(j))
					return false;
			}
		}
		return true;
	}
	
//	public static boolean per(String a, String b)
//	{
//		if(a.length()!=b.length())
//			return false;
//		char[] aa = a.toCharArray();
//		char[] bb = b.toCharArray();
//		Arrays.sort(aa);
//		Arrays.sort(bb);
//		//return 
//		
//	}
	
	public static void main(String[] args) 
	{

	}

}
