public interface List<T> {
	boolean empty();

	boolean full();

	void findFirst();

	void findNext();

	boolean last();

	T retrieve();

	void update(T e);

	void insert(T e);

	void remove();

	// Return the number of elements in the list.
	int size();

	// Searches for e in the list. Current must not change.
	boolean exists(T e);
}
