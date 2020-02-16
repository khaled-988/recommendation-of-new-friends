public interface Graph<K extends Comparable<K>> {

	// Add a node to the graph if it does not exist and return true. If the node already exists, return false.
	boolean addNode(K i);

	// Check if i is a node
	boolean isNode(K i);

	// Add an edge to the graph if it does not exist and return true. If i or j do not exist or the edge (i, j) already exists, return false.
	boolean addEdge(K i, K j);

	// Check if (i, j) is an edge.
	boolean isEdge(K i, K j);

	// Return the set of neighbors of node i. If i does not exist, the method returns null.
	List<K> neighb(K i);

	// Return the degree (the number of neighbors) of node i. If i does not exist, the method returns -1.
	int deg(K i);

	// Return a list containing the nodes in increasing order.
	List<K> getNodes();
}
