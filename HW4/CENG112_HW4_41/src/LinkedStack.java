

public class LinkedStack <T> implements StackInterface<T>{
	
	private Node topNode; // References the first node in the chain
	public LinkedStack()
	{
	topNode = null;
	} // end default
	
	
	private class Node
	{
	private T data; // Entry in bag
	private Node next; // Link to next node
	
	private Node(T dataPortion)
	{
	this(dataPortion, null);
	} // end constructor
	
	private Node(T dataPortion, Node nextNode)
	{
	data = dataPortion;
	next = nextNode;
	}
	private T getData() 
	{
		return data;
	}
	private void setData (T newData) 
	{
		data= newData;
	}
	private Node getNextNode() 
	{
		return next;
	}
	private void setNextNode(Node nextNode) 
	{
		next= nextNode;
	}
	
}	
	
	@Override
	public void push(T newEntry) {
		 Node newNode = new Node(newEntry, topNode);
		 topNode = newNode;
	}

	@Override
	public T pop() {
		 T top = peek(); // Might throw EmptyStackException
		 assert topNode != null;
		 topNode = topNode.getNextNode();
		 return top;
	}

	@Override
	public T peek() {
		if (isEmpty())
			 System.out.println("is empty");
			 else
			 return topNode.getData();
		return null;

	}

	@Override
	public boolean isEmpty() {
		 return topNode == null;
	}

	@Override
	public void clear() {
		topNode = null;
	}

}

	