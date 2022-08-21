package CENG112_HW3_41;

public final class PriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T> {
	private Node<T> firstNode;
	private int numberOfEntries;
	
	// Constructors
	public PriorityQueue() {
		resetTheQueue();
	}
	
	public void add(T newEntry) {
		Node<T> newNode = new Node<>(newEntry);
		Node<T> previousNode = getPreviousNode(newEntry);
		if(isEmpty()||(previousNode == null)) {
			newNode.setNextNode(firstNode);
			firstNode = newNode;
		} else {
			Node<T> nodeAfter = previousNode.getNextNode();
			newNode.setNextNode(nodeAfter);
			previousNode.setNextNode(newNode);
		}
		numberOfEntries++;
	}
	
	public T remove() {
		assert !isEmpty();
		T removedData = firstNode.getData();
		firstNode.setData(null);
		firstNode = firstNode.getNextNode();
		numberOfEntries--;
		return removedData;
	}

	public void clear() {
		resetTheQueue();
	}
	
	private final void resetTheQueue() {
		firstNode = null;
		numberOfEntries = 0;
	}
	public T peek() {
		assert !isEmpty();
		return firstNode.getData();
	}
	public boolean isEmpty() {
		if(firstNode == null) {
			assert numberOfEntries == 0;
		}
		return (firstNode == null);
	}
	public int getSize() {
		return numberOfEntries;
	}
	
	// Implementation details
	
	/**This function is at the heart of this class*/
	private Node<T> getPreviousNode(T entry) {
		Node<T> currentNode = firstNode;
		Node<T> previousNode = null;
		while((currentNode != null)&&(entry.compareTo(currentNode.getData()) < 0)) {
			previousNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
		return previousNode;
	}
}





