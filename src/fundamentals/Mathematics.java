package fundamentals;

public abstract class Mathematics 
{

	public static double logBase(double base, double num)
	{
		if(num<=0)
		{
			Array.printArray("Invalid");
			return num;
		}
		return Math.log(num)/Math.log(base);
		
	}
	
//	public static double geometricSumO(double base, int pow)
//	{
//		double sum = 1;
//		if(pow>0)
//			for(int i=1; i<=pow; i++)
//				sum += Math.pow(base, i);
//		if(pow<0)
//			for(int i=-1; i>=pow; i--)
//				sum += Math.pow(base, i);
//		return sum;
//	}
	
	public static void main(String[] args) 
	{
		
	}

}
