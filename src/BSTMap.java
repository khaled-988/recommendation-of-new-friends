public class BSTMap<K extends Comparable<K>, T> implements Map<K, T> {
	public BSTNode<K, T> root; // Do not change this
	// private BSTNode<K, T> current;
	int size;

	public BSTMap() {
		size = 0;
		root = null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean full() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		try {
		size = 0;
		root = null;
		// TODO Auto-generated method stub
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	private boolean findkey(K tkey) {
		try {
			BSTNode<K, T> p = root, q = root;

			if (root == null)
				return false;
			while (p != null) {
				q = p;
				if (p.key.compareTo(tkey) == 0) {
					// current = p;
					return true;
				} else if (tkey.compareTo(p.key) == -1)
					p = p.left;
				else
					p = p.right;
			}
			return false;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
		// current = q;
	}

	private BSTNode<K, T> Movekey(K tkey) {
		try {
		BSTNode<K, T> p = root, q = root;

		if (root == null)
			return null;
			while (p != null) {
				q = p;
				if (p.key.compareTo(tkey) == 0) {
					// current = p;
					return p;
				} else if (tkey.compareTo(p.key) == -1)
					p = p.left;
				else
					p = p.right;
			}

			// current = q;
			return q;
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
	}

	@Override
	public boolean update(K k, T e) {
		/*
		 * boolean check = findkey(k); if (check) { current.data = e; return true; }
		 */
		try {
			BSTNode<K, T> tmp = Movekey(k);
			if (tmp.key == k) {
				tmp.data = e;
				return true;
			}
			return false;
		} catch (Exception er) {
			return false;
			// TODO: handle exception
		}
	}

	@Override
	public Pair<Boolean, T> retrieve(K k) {
		/*
		 * if (!findkey(k))
		 * 
		 * return new Pair<Boolean, T>(false, null); return new Pair<Boolean, T>(true,
		 * current.data);
		 */
		try {
			BSTNode<K, T> tmp = Movekey(k);
			if (tmp.key==k) {
				return new Pair<Boolean, T>(true, tmp.data);
			}
			return new Pair<Boolean, T>(false, null);
		} catch (Exception e) {
			// TODO: handle exception
			return new Pair<Boolean, T>(false, null);
		}
	}

	@Override
	public boolean insert(K k, T e) {
		try {
			BSTNode<K, T> p, q = root;

			if (findkey(k)) {
				// current = q; // findkey() modified current
				return false; // key already in the BST
			}

			p = new BSTNode<K, T>(k, e);
			if (root == null) {
				root = p;
				size++;
				return true;
			} else {
				// current is pointing to parent of the new key
				q = Movekey(k);
				if (k.compareTo(q.key) == -1)
					q.left = p;
				else
					q.right = p;
				q = p;
				size++;
				return true;
			}
		} catch (Exception et) {
			return false;
			// TODO: handle exception
		}
	}

	@Override
	public boolean remove(K k) {
		try {
			K k1 = k;
			BSTNode<K, T> p = root;
			BSTNode<K, T> q = null;
// Parent of p      
			while (p != null) {
				if (k1.compareTo(p.key) == -1) {
					q = p;
					p = p.left;
				} else if (k1.compareTo(p.key) == 1) {
					q = p;
					p = p.right;
				} else { // Found the key // Check the three cases
					if ((p.left != null) && (p.right != null)) {

						// Case 3: two children // Search for the min in the right subtree
						BSTNode<K, T> min = p.right;
						q = p;
						while (min.left != null) {
							q = min;
							min = min.left;
						}
						p.key = min.key;
						p.data = min.data;
						k1 = min.key;
						p = min; // Now fall back to either case 1 or 2 }
					}
					if (p.left != null) { // One child
						p = p.left;
					} else { // One or no children
						p = p.right;
					}
					if (q == null) { // No parent for p, root must change
						root = p;
					} else {
						if (k1.compareTo(q.key) == -1) {
							q.left = p;
						} else {
							q.right = p;
						}
					}
					// current = root;
					size--;
					return true;
				}
			}
			return false; // Not found
		} catch (Exception e) {
			return false; // Not found
			// TODO: handle exception
		}
	}

	@Override
	public List<K> getKeys() {
		try {
			List<K> tmp = new LinkedList<K>();
			inOreder(tmp, root);
			return tmp;
		} catch (Exception e) {
			return new LinkedList<K>();
			// TODO: handle exception
		}
	}

	private void inOreder(List<K> tmp, BSTNode<K, T> root) {
		try {
		if (root == null)
			return;
		inOreder(tmp, root.left);
		tmp.insert(root.key);
		inOreder(tmp, root.right);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
