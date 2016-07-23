import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IUArrayList<T> implements IndexedUnorderedList<T>
{
	private int count;
	private int capacity; 
	private T[] list; 
	
	@SuppressWarnings("unchecked")
	public IUArrayList()
	{
		count = 0; 
		capacity = 100;
		list = (T[])(new Object[capacity]);
	}
	
	@Override
	public Iterator<T> iterator()
	{
		throw new UnsupportedOperationException("List - iterator");
	}

	@Override
	public void add(T element)
	{
		if(count == capacity)
		{
			expand(); 
		}
		list[count] = element;
		count++;
	}

	private void expand()
	{
		capacity = (int)(capacity * 1.5); 
		Arrays.copyOf(list, capacity); 
	}
	
	@Override
	public void add(int index, T element)
	{
		if(count == capacity)
		{
			expand(); 
		}

		if(index < 0 || index > size())
		{
			throw new IndexOutOfBoundsException("List - add(index)");
		}
		
		for(int i = count; i > index; i--)
		{
			list[i] = list[i - 1];
		}
		list[index] = element; 
		count++; 
	}

	@Override
	public int indexOf(T element)
	{
		boolean found = false;
		int index = 0;
		while(!found && index < count)
		{
			if(list[index] == element)
			{
				found = true;
			}
			else
			{
				index++; 
			}
		}
		
		if(!found)
		{
			throw new NoSuchElementException("List - indexOf");
		}
		
		return index;
	}

	@Override
	public T get(int index)
	{
		if(index < 0 || index >= size())
		{
			throw new IndexOutOfBoundsException("List - get");
		}
		
		return list[index];
	}

//	

	@Override
	public void set(int index, T element)
	{
		if(index < 0 || index >= size())
		{
			throw new IndexOutOfBoundsException("List - get");
		}
		
		list[index] = element;
	}

	@Override
	public int size()
	{
		return count;
	}

	@Override
	public boolean isEmpty()
	{
		return (count == 0);
	}

	@Override
	public T removeFirst() {
		
		if(isEmpty()){
			throw new IllegalStateException();
		}
		
		T temp = list[0];
		
		for(int i = 0; i < count; i++)
		{
			list[i] = list[i + 1];
		}
		count--;
		return temp;
	}

	@Override
	public T removeLast() {
		
		if(isEmpty()){
			throw new IllegalStateException();
		}
		
		T temp = list[count - 1];
		count--;
		return temp;
	}


	@Override
	public T remove(T element)
	{
		boolean found = false;
		int index = 0;
		while(!found && index < count)
		{
			if(list[index] == element)
			{
				found = true;
			}
			else
			{
				index++; 
			}
		}
		
		if(!found)
		{
			throw new NoSuchElementException("List - indexOf");
		}
		
		for(int i = index; i < count; i++)
		{
			list[i] = list[i + 1]; 
		}
		count--;
		
		return list[index];
	}

	
	@Override
	public T first() {
		if(isEmpty()){
			throw new IllegalStateException();
		}
		return list[0];
	}

	@Override
	public T last() {
		if(isEmpty()){
			throw new IllegalStateException();
		}
		return list[count - 1];
	}

	
	@Override
	public boolean contains(T target) {
		boolean found = false;
		int i = 0;
		
		while(!found && i < count){
			
			if(list[i] == target){
				found = true;
			}
			i++;
		}
		return found;
	}

	@Override
	public T remove(int index) {

		if((index < 0 || index >= count)){
			throw new IndexOutOfBoundsException();
		}
		T temp = list[index];
		
		for(int i = index; i < count; i++)
		{
			list[index] = list[i + 1];
		}
		
		count--;
		return temp;
	}

	@Override
	public void addToFront(T element) {
		

		T temp;
		 
		for(int i = 0; i < count; i++)
		{
			
			temp = list[i + 1];
			list[i + 1] = list[i];
			list[i + 1]= temp;
			
		}
		
		
		
		
		count++;
	}

	@Override
	public void addToRear(T element) {
		// TODO Auto-generated method stub
		
		count++;
	}

	@Override
	public void addAfter(T element, T target) {
		// TODO Auto-generated method stub
		count++;
	}

}