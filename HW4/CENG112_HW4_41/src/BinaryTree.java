import java.util.NoSuchElementException;

public class BinaryTree <T> implements BinaryTreeInterface<T>{
	
	protected Comparator<T> comp;
	private BinaryNode<T> root;
	
	{
	root = null;
	} // end default constructor
	
	public BinaryTree(T rootData)
	{
	root = new BinaryNode<>(rootData);
	} // end constructor
	
	
	public void setTree(T rootData) {
		root = new BinaryNode<>(rootData);
		
	}
	public BinaryTree()
	{    
		 
		 comp = new Comparator<T>() 
		 {
			 @SuppressWarnings("unchecked")
			public int compare(T element1, T element2) 
			 {
				 return ((Comparable)element1).compareTo(element2);
			 }
		 };
	}
	public BinaryTree(Comparator<T> comp) 
	  // Creates an empty BST object - uses Comparator comp for order
	  // of elements.
	  {
	    root = null;
	    this.comp = comp;
	  }
	
	public T getRootData() {
		if (isEmpty())
			 System.out.println("is empty");
		else
			 return root.getData();
		return null;
		} // end getRootData
			
	
	protected void setRootData(T rootData)
	{
	  root.setData(rootData);
	} // end setRootData
	protected void setRootNode(BinaryNode<T> rootNode)
	{
	  root = rootNode;
	} // end setRootNode
	protected BinaryNode<T> getRootNode()
	{
	  return root;
	} // end getRootNode
			
	
	
	
	
	
	private class InorderIterator implements Iterator<T>
	 {
	 private StackInterface<BinaryNode<T>> nodeStack  ;
	 private BinaryNode<T> currentNode;
	
	 public InorderIterator()
	 {
	 nodeStack = new LinkedStack<>();
	 currentNode = root;
	 } // end default constructor
	
	 public boolean hasNext()
	 {
	 return !nodeStack.isEmpty() || (currentNode != null);
	 } // end hasNext
	
	 public T next()
	 {
	 BinaryNode<T> nextNode = null;
	
	 // Find leftmost node with no left child
	 while (currentNode != null)
	 {
	 nodeStack.push(currentNode);
	 currentNode = currentNode.getLeftChild();
	 } // end while
	
	 // Get leftmost node, then move to its right subtree
	 if (!nodeStack.isEmpty())
	 {
	 nextNode = nodeStack.pop();
	 assert nextNode != null; // Since nodeStack was not empty
	 // before the pop
	 currentNode = nextNode.getRightChild(); 
	 }
	 else
	 throw new NoSuchElementException();
	
	 return nextNode.getData();
	 } // end next
	
	 public void remove()
	 {
	 throw new UnsupportedOperationException();
	 } // end remove
	 } // end InorderIterato
    
	

	@Override
	public int getHeight() {
		return root.getHeight();
	}

	@Override
	public int getNumberOfNodes() {
		return root.getNumberOfNodes();
	
	}

	@Override
	public boolean isEmpty() 
	{
		return root == null;
	}

	@Override
	public void clear() {
		 root = null;
		
	}

	
	public void iterativeInorderTraverse()
	{
	 StackInterface<BinaryNode<T>> nodeStack = new LinkedStack<>();
	 BinaryNode<T> currentNode = root;
	 while (!nodeStack.isEmpty() || (currentNode != null))
	 {
	 // Find leftmost node with no left child
	 while (currentNode != null)
	 {
	 nodeStack.push(currentNode);
	 currentNode = currentNode.getLeftChild();
	 } // end while
	 // Visit leftmost node, then traverse its right subtree
	 if (!nodeStack.isEmpty())
	 {
	 BinaryNode<T> nextNode = nodeStack.pop();
	 assert nextNode != null; // Since nodeStack was not empty
	 // before the pop
	 System.out.println(nextNode.getData());
	 currentNode = nextNode.getRightChild();
	 } // end if
	 } // end while
	} // end iterativeInorderTraverse

    
	

	


	


	private class postorderIter implements Iterator<T>
	{
		 private StackInterface<BinaryNode<T>> nodeStack  ;
		 private BinaryNode<T> currentNode;
		 
		 public postorderIter()
		 {
		 nodeStack = new LinkedStack<>();
		 currentNode = root;
		 }// end default constructor
		 
		
		@Override
		public boolean hasNext() {
			 return !nodeStack.isEmpty() || (currentNode != null);
		}
		@Override
		public T next() {
			BinaryNode<T> nextNode = null;
			
			 
			 while (currentNode != null)
			 {
				 if(currentNode.getRightChild()!=null){
					 
			 nodeStack.push(currentNode.getRightChild());
			 nodeStack.push(currentNode);
			 currentNode = currentNode.getLeftChild();
				 }
			 } // end while
			 if(nodeStack.isEmpty())
				 return null;
			 currentNode=nodeStack.pop();
			
			 if (!nodeStack.isEmpty()&&currentNode.getRightChild()!=null&&currentNode.getRightChild()==nodeStack.peek())
			 {
			 nextNode = nodeStack.pop();
			 assert nextNode != null; // Since nodeStack was not empty
			 nodeStack.push(currentNode);
			 // before the pop
			 currentNode = nextNode.getRightChild(); 
			 }
			 else
			 throw new NoSuchElementException();
			
			 return nextNode.getData();
			 } // end next


		@Override
		public void remove() {
			 throw new UnsupportedOperationException();
			
		}
		}
      private class levelorderIter implements Iterator<T>{
    	  
    	  QueueInterface<BinaryNode<T>> nodeQueue;
    	  BinaryNode<T> currentNode ;
        
    	 public levelorderIter()
 		 {
 		 nodeQueue = new LinkedQueue<>();
 		 currentNode = root;
 		 }// end default constructor
		@Override
		public boolean hasNext() {
			 return !nodeQueue.isEmpty() || (currentNode != null);
		}

		@Override
		public T next() {
			
			nodeQueue.enqueue(root);
			while(!nodeQueue.isEmpty()) {
				BinaryNode<T> curr =nodeQueue.dequeue();
				System.out.print(curr.getData());
				if(curr.getLeftChild()!=null) {
					nodeQueue.enqueue(curr.getLeftChild());
				}
                 if(curr.getRightChild()!=null) {
                	 nodeQueue.enqueue(curr.getRightChild());
                 }
			}
			return null;
		}

		@Override
		public void remove() {
			 throw new UnsupportedOperationException();
		}
    	  
      }
      
      
      public void preorderTraverse()
      {
       preorderTraverse(root);
      } // end preorderTraverse
      private void preorderTraverse(BinaryNode<T> node)
      {
       if (node != null)
       {
       System.out.println(node.getData());
       preorderTraverse(node.getLeftChild());
       preorderTraverse(node.getRightChild());
       } // end if
      } // end preorderTraverse


	@Override
	public Iterator<T> getInorderIterator() {
		return new InorderIterator();
	}


	@Override
	public Iterator<T> getLevelOrderIterator() {
		return new levelorderIter();
	}
	@Override
	public Iterator<T> getPostorderIterator() {
		
		return new postorderIter();
	}
	
	
	}
	
	
	

