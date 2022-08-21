
public class LinkedQueue <T> implements QueueInterface<T>
{
	private class Node<T>
	 {
		private T data;
		private Node next;
		
		private Node (T dataPortion) 
		{
			this(dataPortion,null);
		}
		private Node(T dataPortion,Node nextNode )
		{
			data = dataPortion;
			next= nextNode;
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


	
	
	private Node firstNode;
	private Node lastNode ;
	
	public LinkedQueue() {
		firstNode=null;
		lastNode=null;
		
	}
	

	@Override
	public void enqueue(T newEntry) {
		Node newNode =new Node(newEntry, null);
		
		if (isEmpty())
			firstNode=newNode;
		else
			lastNode.setNextNode(newNode);
		lastNode =newNode;
	}

	@Override
	public T dequeue() 
	{
		T front= getFront();
		assert firstNode != null;
		firstNode.setData(null);
		firstNode= firstNode.getNextNode();
		
		if(firstNode == null);
		lastNode=null;
		
		return front;
	}

	@Override
	public T getFront() 
	{
		if (isEmpty())
          System.out.println("queue is empty");
		else
			return (T) firstNode.getData();
		return null;
		
	}

	@Override
	public boolean isEmpty() 
	{
		return(firstNode==null)&& (lastNode ==null);
		
	}


	

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	

}
