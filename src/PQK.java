public interface PQK<P extends Comparable<P>, T> {

	// Return the length of the queue
	int length();

	// Enqueue a new element. The queue keeps the k elements with the highest priority. In case of a tie apply FIFO.
	void enqueue(P pr, T e);

	// Serve the element with the highest priority. In case of a tie apply FIFO.
	Pair<P, T> serve();
}
