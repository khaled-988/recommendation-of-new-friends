public class BSTNode<K extends Comparable<K>, T> {
	public K key;
	public T data;
	public BSTNode<K, T> left, right;

	public BSTNode(K key, T data) {
		this.key = key;
		this.data = data;
		left = right = null;
	}
}
