public class ArrayStack<T> implements Stack<T>{

	protected T[] arr;
	protected int top;
	protected int size = 10;

	public ArrayStack(){
		top = -1;
		arr = (T[])new Object[size]; //Cast to type T
	}

	public void push(T item){
		if(top == arr.length -1) //If full grow array
			growArray();
		arr[++top] = item; //add item and increase top
	}

	public T pop(){
		if(empty())
			throw new ArrayIndexOutOfBoundsException("Error");
		return arr[top--]; //return the last item
	}
	public T peek(){
		if(empty())
			throw new ArrayIndexOutOfBoundsException("Error");
		return arr[top];
	}
	public boolean empty(){
		return top == -1;

	}

	public void growArray(){
		T[] temp = (T[])new Object[arr.length * 2]; //Create array double size
		System.arraycopy(arr,0,temp,0,arr.length-1);// copy all elements
		arr = temp;
	}
}