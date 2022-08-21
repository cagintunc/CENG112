

public class BST<T> extends BinaryTree<T>
implements SearchTreeInterface<T>{
	

	
	protected Comparator<T> comp;
	
	private class ReturnObject
	{
		
		
		private  Object data;
		ReturnObject(Object data) {
			this.data=data;
		}
		@SuppressWarnings("unchecked")
		public  T get()
		{
		  return (T) data;
		}
		public void set(T newData)
		{
			this.data=newData;
		}
	}
	
	public BST(Comparator<T> comp)
	{
		 this.comp=comp;
		 comp = new Comparator<T>() 
		 {
			 @SuppressWarnings({ "unchecked", "rawtypes" })
			public int compare(T element1, T element2) 
			 {
				 return ((Comparable)element1).compareTo(element2);
			 }
		 };
	}
	
	public BST()
	{
	super();
	} // end default constructor
	
	public BST(T rootEntry)
	{
	super();
	setRootNode(new BinaryNode<T>(rootEntry));
	} // end constructor
	
	
	
	@Override
	
	public boolean contains(T entry) {
		return getEntry(entry) != null;
	}

	@Override
	public T getEntry(T entry) {
		return findEntry(getRootNode(), entry);
	} // end getEntry
	private T findEntry(BinaryNode<T> rootNode, T entry)
	{
	 T result = null;
	 if (rootNode != null)
	 {
	 T rootEntry = rootNode.getData();
	 if (entry.equals(rootEntry))
	 result = rootEntry;
	 else if (comp.compare(entry,rootEntry) < 0)
	 result = findEntry(rootNode.getLeftChild(), entry);
	 else
	 result = findEntry(rootNode.getRightChild(), entry);
	 } // end if
	 return result;
	} // end findEntry
	

	@Override
	public T add(T newEntry) {
		T result = null;
		 if (isEmpty())
		 setRootNode(new BinaryNode<>(newEntry));
		 else
		 result = addEntry(getRootNode(), newEntry);
		 return result;
	}//end add


	@Override
	public T remove(T entry)
	{
	 ReturnObject oldEntry = new ReturnObject(null);
	 BinaryNode<T> newRoot = removeEntry(getRootNode(), entry, oldEntry);
	 setRootNode(newRoot);
	 return oldEntry.get();
	} // end remove
	
	
	
	private T addEntry(BinaryNode<T> rootNode, T newEntry)
	{
	 assert rootNode != null;
	 T result = null;
	 int comparison = comp.compare(newEntry, rootNode.getData());
	
     if (comparison < 0)
	 {
	   if (rootNode.hasLeftChild()) 
	   result = addEntry(rootNode.getLeftChild(), newEntry);
	  
	   else 
	   rootNode.setLeftChild(new BinaryNode<>(newEntry));
	   
	 }
	 else {
	 
	   assert comparison > 0;
	   if (rootNode.hasRightChild()) 
	   result = addEntry(rootNode.getRightChild(), newEntry);
	   
	   else 
	    rootNode.setRightChild(new BinaryNode<>(newEntry));
	    
	 } // end if
	 return result;
	} // end addEntry
	
	
	
	
	
	
	private BinaryNode<T> removeEntry(BinaryNode<T> rootNode, T entry,
			 ReturnObject oldEntry)
	{
	 if (rootNode != null)
	 {
	 T rootData = rootNode.getData();
	 int comparison = comp.compare(entry,rootData);
	 if (comparison == 0) // entry == root entry
	 {
	 oldEntry.set(rootData);
	 rootNode = removeFromRoot(rootNode);
	 }
	 else if (comparison < 0) // entry < root entry
	 {
	 BinaryNode<T> leftChild = rootNode.getLeftChild();
	 BinaryNode<T> subtreeRoot = removeEntry(leftChild, entry, oldEntry);
	 rootNode.setLeftChild(subtreeRoot);
	 }
	 else // entry > root entry
	 {
	 BinaryNode<T> rightChild = rootNode.getRightChild();
	 rootNode.setRightChild(removeEntry(rightChild, entry, oldEntry));
	 } // end if
	 } // end if
	 return rootNode;
	} // end removeEntry
	
	
	
	
	
	
	
	
	
	// Returns the root node of the revised subtree.
	private BinaryNode<T> removeFromRoot(BinaryNode<T> rootNode)
	{
	 // Case 1: rootNode has two children
	 if (rootNode.hasLeftChild() && rootNode.hasRightChild())
	 {
	 // Find node with largest entry in left subtree
	 BinaryNode<T> leftSubtreeRoot = rootNode.getLeftChild();
	 BinaryNode<T> largestNode = findLargest(leftSubtreeRoot);
	 // Replace entry in root
	 rootNode.setData(largestNode.getData());
	 // Remove node with largest entry in left subtree
	 rootNode.setLeftChild(removeLargest(leftSubtreeRoot));
	 } // end if
	 // Case 2: rootNode has at most one child
	 else if (rootNode.hasRightChild())
	 rootNode = rootNode.getRightChild();
	 else
	 rootNode = rootNode.getLeftChild();
	 // Assertion: if rootNode was a leaf, it is now null
	 return rootNode;
	} // end removeEntry
	
	
	
	private BinaryNode<T> findLargest(BinaryNode<T> rootNode)
	{
	 if (rootNode.hasRightChild())
	 rootNode = findLargest(rootNode.getRightChild());
	 return rootNode;
	} // end findLargest
	
	

	public T findMax() {
		BinaryNode<T> max=findLargest(getRootNode());
		if (max != null) {
            return (T) max.getData();
        }
        return null;
		
	}
	private BinaryNode<T> findMinimum(BinaryNode<T> rootNode)
	{
	 if (rootNode.hasLeftChild())
	 rootNode = findMinimum(rootNode.getLeftChild());
	 return rootNode;
	} // end findLargest
	
	public T findMin() {
		BinaryNode<T> min=findMinimum(getRootNode());
		if (min != null) {
            return (T) min.getData();
        }
        return null;
		
	}
	
	
	
	private BinaryNode<T> removeLargest(BinaryNode<T> rootNode)
	{
	 if (rootNode.hasRightChild())
	 {
	 BinaryNode<T> rightChild = rootNode.getRightChild();
	 rightChild = removeLargest(rightChild);
	 rootNode.setRightChild(rightChild);
	 }
	 else
	 rootNode = rootNode.getLeftChild();
	 return rootNode;
	} // end removeLargest
	 
	
	
	
	
}