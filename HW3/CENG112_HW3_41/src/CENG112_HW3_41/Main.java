package CENG112_HW3_41;
// Main class
public class Main {
	// Main method
	public static void main(String[] args) {
		Node<OsSimulation> os1 = new Node<>(new OsSimulation(3), null);
		Node<OsSimulation> os2 = new Node<>(new OsSimulation(5), null);
		Node<OsSimulation> os3 = new Node<>(new OsSimulation(10), null);
		os1.setNextNode(os2);
		os2.setNextNode(os3);
		Node<OsSimulation> currentNode = os1;
		while(currentNode != null) {
			currentNode.getData().setUp();
			System.out.println("_________________________________________");
			currentNode = currentNode.getNextNode();
		}
	}
}
;