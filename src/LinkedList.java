
public class LinkedList<T> implements List<T>{
	private Node1<T> head;
	private Node1<T> cur;
	private int size;

	public LinkedList() {
		head = null;
		size=0;
		cur = null;
	}

	public LinkedList(Node1<T> head) {
		super();
		
		this.head = head;
		cur = null;
	}

	public LinkedList(Node1<T> head, Node1<T> cur) {
		super();
		this.head = null;
		
		this.cur = null;
	}

	public void setCur(Node1<T> c) {
		cur=c;
	}
	

	public Node1<T> getCur(){
		return cur;
	}
	
	public int length() {
		try {
		Node1 <T> tmp =head;
		int x=0;
		while (tmp != null) {
			x++;
			tmp=tmp.next;
		}
		return x;
		}catch (Exception e) {
			return 0;
			// TODO: handle exception
		}
	}
	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return head == null;
	}

	@Override
	public boolean full() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void findFirst() {
		cur = head;
		// TODO Auto-generated method stub

	}
	@Override

	public void findNext() {
		cur = cur.next;
		// TODO Auto-generated method stub

	}

	@Override
	public boolean last() {
		
		// TODO Auto-generated method stub
		return cur.next == null;
		
	}

	@Override
	public T retrieve() {
		// TODO Auto-generated method stub
		return cur.data;
	}

	@Override
	public void update(T e) {
		cur.data=e;
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(T e) {
		try {

	    /* 1. allocate node  
	     * 2. put in the data */
	    Node1<T> new_node = new Node1<T>(e); 
	  
	    Node1<T> last = head; /* used in step 5*/
	  
	    /* 3. This new node is going to be the last node, so 
	     * make next of it as NULL*/
	    new_node.next = null; 
	  
	    /* 4. If the Linked List is empty, then make the new 
	     * node as head */
	    if (head == null) { 
	        new_node.til = null; 
	      cur=  head = new_node; 
	        size++;
	        return; 
	    } 
	  
	    /* 5. Else traverse till the last node */
	    while (last.next != null) 
	        last = last.next; 
	  
	    /* 6. Change the next of last node */
	    last.next = new_node; 
	  
	    /* 7. Make last node as previous of new node */
	    new_node.til = last; 
	    cur=last.next;
		size++;
		/*
		if (head == null)
			cur = head = new Node1<T>(e);
		else {
			Node1<T> tmp = cur.getNext();
			Node1<T> tmp1 = head;
			while (tmp1.next != cur) {
				tmp1=tmp1.next;
			}
			tmp1.next.setNext(new Node1<T>(e));
			tmp1=tmp1.next;
			cur=cur.next;
			cur.setNext(new Node1<T>(e));
			cur = cur.getNext();
			cur.setNext(tmp);
		}*/
		}catch (Exception ee) {
			// TODO: handle exception
		}
	}

	@Override
	public void remove() {
		try {
		if (cur == head)
			head = head.getNext();
		else {
			Node1<T> tmp = head;
			while (tmp.getNext() != cur)
				tmp = tmp.getNext();
			tmp.setNext(cur.getNext());

		}
		if (cur.getNext() == null)
			cur = head;
		else
			cur = cur.getNext();
		size--;
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public int size() {
		try {
			Node1 <T> tmp =head;
			int x=0;
			while (tmp != null) {
				x++;
				tmp=tmp.next;
			}
			return x;
			}catch (Exception e) {
				return 0;
				// TODO: handle exception
			}
	}

	@Override
	public boolean exists(T e) {
		try {
		if (empty())
		return false;
		Node1<T> tmp=head;
		while (tmp != null) {
			if (tmp.data.equals(e)) {
				//cur=tmp;
				return true;
			}
			tmp=tmp.next;
		}
		return false;
		}catch (Exception ee) {
			return false;
			// TODO: handle exception
		}
		}

	
}

 class Node1<T> {

	public Node1<T> next;
	public Node1<T> til;
	public T data;

	public Node1(T v) {
		super();
		this.next = null;
		this.til = null;
		this.data = v;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node1<T> getNext() {
		return next;
	}

	public Node1<T> getTil() {
		return til;
	}

	public void setNext(Node1<T> next) {
		this.next = next;
	}

	public void setTil(Node1<T> til) {
		this.til = til;
	}

}
