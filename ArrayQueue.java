
public class ArrayQueue<T> implements Queue<T>
{
   private final int size = 10;
   private int head, tail, count;
   private T[] arr; 

   public ArrayQueue()
   {
      head = tail = count = 0;
      arr = (T[]) (new Object[size]); //Cast to type T
   }

   public ArrayQueue (int initialCapacity)
   {
      head = tail = count = 0;
      arr = ( (T[])(new Object[initialCapacity]) );
   }

   public void enqueue (T element)
   {
      if (size() == arr.length) //Grow if full
         grow();

      arr[tail] = element; //add element

      tail = (tail+1) % arr.length; //Circular queue

      count++; //Keep track of total items
   }

   public T dequeue()
   {
      if (empty())
         throw new ArrayIndexOutOfBoundsException("Error");

      T result = arr[head];
      arr[head] = null;

      head = (head+1) % arr.length;

      count--;

      return result;
   }

   public T first()
   {
      if (empty())
         throw new ArrayIndexOutOfBoundsException("Error"); 

      return arr[head];
   }

   public boolean empty()
   {
      return (count == 0);
   }

   public int size()
   {
      return count;
   }

  public void grow()
  {
    T[] larger = (T[])(new Object[arr.length *2]);   

    for(int i=0; i < count; i++)
    {
      larger[i] = arr[head];
      head=(head+1) % arr.length;
    }

    head = 0;
    tail = count;
    arr = larger;
  }
  
}
