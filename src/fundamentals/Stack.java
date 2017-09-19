package fundamentals;
import java.util.*;

public class Stack<T>
{
	private LinkedList<T> core;
	
	public Stack()
	{
		core = new LinkedList<T>();
	}
	
	public Stack(Collection<T> content)
	{
		core = new LinkedList<T>(content);
	}
	
	public void add(T element)
	{
		core.add(element);
	}
	
	public T remove()
	{
		return core.removeLast();
	}
	
	public static void main(String[] args) 
	{

	}

}
