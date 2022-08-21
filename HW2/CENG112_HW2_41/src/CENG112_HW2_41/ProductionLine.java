package CENG112_HW2_41;

public class ProductionLine<T> implements QueueInterface<T>{
	/*Data fields*/
	private T[] queue;
	private int frontIndex;
	private int backIndex;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 5;
	private static final int MAXIMUM_CAPACITY = 10000;
	
	public ProductionLine() {
		this(DEFAULT_CAPACITY);
	}
	public ProductionLine(int capacity) {
		assert checkCapacity(capacity);
		/*It is safe to cast since it's element initialized as null entries*/
		@SuppressWarnings("unchecked")
		T[] temporary = (T[]) new Object[capacity+1];
		queue = temporary;
		frontIndex = 0;
		backIndex = capacity;
		initialized = true;
	}
	/**When we add something to the queue we add(enqueue) it at the back of the queue.*/
	public void enqueue(T newEntry) {
		checkInitialization();
		ensureCapacity();
		backIndex = (backIndex + 1)%queue.length;
		queue[backIndex] = newEntry;
	}
	/**When we remove(dequeue) something we must remove it from the front of the queue*/
	public T dequeue() {
		checkInitialization();
		if(isEmpty()) {
			return null;
		}
		else {
			T front = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex+1)%queue.length;
			return front;
		}
	}
	public T getFront() {
		checkInitialization();
		if(isEmpty()) {
			return null;
		}
		return queue[frontIndex];
	}
	public boolean isEmpty() {
		checkInitialization();
		return frontIndex == (backIndex+1)%queue.length;
	}
	public void clean() {
		checkInitialization();
		while(!isEmpty()) {
			dequeue();
		}
	}
	/**For security*/
	private void checkInitialization() {
		if(!initialized) {
			throw new SecurityException();
		}
	}
	private void ensureCapacity() {
		if(frontIndex == ((backIndex + 2)%queue.length)) {
			T[] fullQueue = queue;
			int newLength = (fullQueue.length)*2;
			assert checkCapacity(newLength-1);
			/*The cast is safe since the new array includes null entries*/
			@SuppressWarnings("unchecked")
			T[] tempQueue = (T[]) new Object[newLength];
			for(int index = 0; index < fullQueue.length - 1; index++) {
				tempQueue[index] = fullQueue[index];
				frontIndex = (frontIndex + 1)%fullQueue.length;
			}
			frontIndex = 0;
			backIndex = fullQueue.length - 2;
		}
	}
	private boolean checkCapacity(int capacity) {
		return capacity <= MAXIMUM_CAPACITY;
	}
}
