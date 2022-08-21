
public interface TreeIteratorInterface<T> {
	
	public Iterator<T> getInorderIterator();
	public Iterator<T> getPostorderIterator();
	public Iterator<T> getLevelOrderIterator();
}
