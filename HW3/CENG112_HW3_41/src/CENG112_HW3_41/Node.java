package CENG112_HW3_41;

public class Node<T> {
	private T data;
	private Node<T> nextNode;
	
	// Constructors
	public Node(T data) {
		this(data, null);
	}
	public Node(T data, Node<T> nextNode) {
		this.data = data;
		this.nextNode = nextNode;
	}
	
	// Setter & Getters
	public void setData(T data) {
		this.data = data;
	}
	public T getData() {
		return data;
	}
	public void setNextNode(Node<T> node) {
		nextNode = node;
	}
	public Node<T> getNextNode() {
		return nextNode;
	}
}
