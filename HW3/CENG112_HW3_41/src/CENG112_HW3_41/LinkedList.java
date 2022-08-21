package CENG112_HW3_41;

public final class LinkedList<T> implements ListInterface<T> {
	private Node<T> firstNode;
	private Node<T> lastNode;
	private int numberOfEntries;
	
	// Constructor
	public LinkedList() {
		resetTheLinkage();
	}
	
	public void add(T newEntry) {
		Node<T> newNode = new Node<>(newEntry);
		if(isEmpty())
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);
		lastNode = newNode;
		numberOfEntries++;
	}
	
	public void add(int givenIndex, T newEntry) {
		if((givenIndex >= 1) && (givenIndex <= numberOfEntries + 1)) {
			Node<T> newNode = new Node<>(newEntry);
			if(isEmpty()) {
				firstNode = newNode;
				lastNode = newNode;
			} else if(givenIndex == 1) {
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			} else if(givenIndex == numberOfEntries + 1) {
				lastNode.setNextNode(newNode);
				lastNode = newNode;
			} else {
				Node<T> previousNode = getNodeAt(givenIndex - 1);
				Node<T> afterNode = previousNode.getNextNode();
				newNode.setNextNode(afterNode);
				previousNode.setNextNode(newNode);
			}
			numberOfEntries++;
		} else {
			throw new IndexOutOfBoundsException("Illegal position :(");
		}
	}
	
	public T remove(int givenIndex) {
		T removedItem = null;
		if((givenIndex >= 1) && (givenIndex <= numberOfEntries)) {
			assert !isEmpty(): "You are trying to remove an entry from an empty list or there is a problem :(";
			if(givenIndex == 1) {
				removedItem = firstNode.getData();
				firstNode.setData(null);
				firstNode = firstNode.getNextNode();
				if(firstNode == null) {
					lastNode = null;
				}
			} else { 
				Node<T> previousNode = getNodeAt(givenIndex - 1);
				Node<T> removedNode = previousNode.getNextNode();
				Node<T> afterNode = removedNode.getNextNode();
				removedItem = removedNode.getData();
				previousNode.setNextNode(afterNode);
				removedNode = null;
			}
			numberOfEntries--;
		} else {
			throw new IndexOutOfBoundsException("Illegal position");
		}
		return removedItem;
	}
	
	public T remove() {
		return remove(numberOfEntries);
	}
	
	public T getEntry(int givenIndex) {
		if((givenIndex >= 1) && (givenIndex <= numberOfEntries)) {
			Node<T> node = getNodeAt(givenIndex);
			assert node != null: "Entry is null :(";
			return node.getData();
		} else {
			throw new IndexOutOfBoundsException("Illegal position");
		}
	}
	
	public int getLentgh() {
		return numberOfEntries;
	}
	
	public boolean contains(T anEntry) {
		boolean founded = false;
		assert firstNode != null;
		Node<T> currentNode = firstNode;
		while((currentNode != null)&&(!founded)) {
			if(anEntry.equals(currentNode.getData()))
				founded = true;
			else
				currentNode = currentNode.getNextNode();
		}
		return founded;
	}
	
	public T replace(int givenIndex, T newEntry) {
		T result = null;
		if((givenIndex >= 1) && (givenIndex <= numberOfEntries)) {
			assert !isEmpty(): "Empty list allert";
			Node<T> node = getNodeAt(givenIndex);
			result = node.getData();
			node.setData(newEntry);
			assert getNodeAt(givenIndex).getData() == newEntry: "It couldn't replaced";
		} else {
			throw new IndexOutOfBoundsException("Illegal position");
		}
		return result;
	}
	
	public T[] toArray() {
		assert !isEmpty(): "It is empty but you try to convert it an array";
		Node<T> currentNode = firstNode;
		assert currentNode != null: "There is an problem with the logic of the method isEmpty";
		//Cast is safe because array has null entries
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[numberOfEntries];
		int index = 0;
		while((index < numberOfEntries) && (currentNode != null)) {
			array[index] = currentNode.getData();
			currentNode = currentNode.getNextNode();
			index++;
		}
		return array;
	}
	
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}
	
	public void clear() {
		resetTheLinkage();
	}
	
	// Implementation details of the class
	
	private void resetTheLinkage() {
		firstNode = null;
		lastNode = null;
		numberOfEntries = 0;
	}
	
	private Node<T> getNodeAt(int index) {
		assert (!isEmpty())&&(firstNode != null)&&(lastNode != null) : "there is a problem in getNodeAt about the logic of isEmpty :(";
		Node<T> currentNode = firstNode;
		for(int i = 1; i < index; i++) {
			currentNode = currentNode.getNextNode();
		}
		assert currentNode != null: "currentNode is null but it musn't be :(";
		return currentNode;
	}
}














