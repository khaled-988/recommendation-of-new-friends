public class MGraph<K extends Comparable<K>> implements Graph<K> {
	public Map<K, List<K>> adj; // Do not change this
	
	public MGraph() {
		adj=new BSTMap<K, List<K>>() ;
		
	}
	@Override
	public boolean addNode(K i) {
		try {
		if (adj.size()==0) {
			adj.insert(i,new LinkedList<K>());
			
		}
		else {
			List<K>tmp=adj.getKeys();
			tmp.findFirst();
			while (tmp.last() == false) {
				if (tmp.retrieve().equals(i))
					return false;
				tmp.findNext();
			}
			if (tmp.retrieve().equals(i))
				return false;
			
			adj.insert(i, new LinkedList<K>());
		}
		return true;
		}catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}
	@Override
	public boolean isNode(K i) {
		try {
		List<K>tmp=adj.getKeys();
		tmp.findFirst();
		while (tmp.last() == false) {
			if (tmp.retrieve().equals(i))
				return true;
			tmp.findNext();
		}
		if (tmp.retrieve().equals(i))
			return true;
		return false;
		}catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}
	@Override
	public boolean addEdge(K i, K j) {
		try {
		List<K> tmp=this.getNodes();
		boolean ch=false;
		tmp.findFirst();
		while (tmp.last() == false) {
			if (tmp.retrieve().equals(i))
				ch=true;
			tmp.findNext();
		}
		if (tmp.retrieve().equals(i))
			ch=true;
//			return true;
		
			
	
		List<K> tmp1=this.getNodes();
		boolean ch1=false;
		tmp1.findFirst();
		while (tmp1.last() == false) {
			if (tmp1.retrieve().equals(j))
				ch1=true;
			tmp1.findNext();
		}
		if (tmp1.retrieve().equals(j))
			ch1=true;
//			return true;
		
		
		
			if (ch && ch1) {
				if (isEdge(i, j))
					return false;
				List<K> ret=adj.retrieve(i).second;
				ret.insert(j);
				
				List<K> ret1=adj.retrieve(j).second;
				ret1.insert(i);
				return true;
			
		}
		
			return false;
		}catch (Exception e) {
			return false;
			// TODO: handle exception
		}
		
	}
	@Override
	public boolean isEdge(K i, K j) {
		try {
		List<K> tmp=this.getNodes();
		boolean ch=false;
		K c1=null;
		tmp.findFirst();
		while (tmp.last() == false) {
			if (tmp.retrieve().equals(i)) {
				ch=true;
				c1=tmp.retrieve();
			}
			tmp.findNext();
		}
		if (tmp.retrieve().equals(i)) {
			
			c1=tmp.retrieve();
			ch=true;
		}
		
		
		K c2=null;
		List<K> tmp1=this.getNodes();
		boolean ch1=false;
		tmp1.findFirst();
		while (tmp1.last() == false) {
			if (tmp1.retrieve().equals(j)) {
				c2=tmp1.retrieve();
				ch1=true;
			}
			tmp1.findNext();
		}
		if (tmp1.retrieve().equals(j)) {
			
			c2=tmp1.retrieve();
			ch1=true;
		}
		
		if (ch && ch1) {
			Pair<Boolean, List<K>> Pc1=adj.retrieve(c1);
			if(Pc1.first==false)
				return false;
			List<K> loop1=Pc1.second;
			loop1.findFirst();
			for (int a=0;a<loop1.size();a++) {
				if (c2.equals(loop1.retrieve()))
					return true;
				loop1.findNext();
			}
			
			// call private method 
			Pair<Boolean, List<K>> Pc2=adj.retrieve(c2);
			if(Pc2.first==false)
				return false;
			List<K> loop2=Pc2.second;
			loop2.findFirst();
			for (int a=0;a<loop2.size();a++) {
				if (c1.equals(loop2.retrieve()))
					return true;
				loop2.findNext();
			}
			
		}
		return false;
		}catch (Exception e) {
		return false;
			// TODO: handle exception
		
		}
	}
	

	@Override
	public List<K> neighb(K i) {
		try {
		List<K> tmp=this.getNodes();
		List<K> tmp1=new LinkedList<>();
		boolean ch=false;
		tmp.findFirst();
		while (tmp.last() == false) {
			if (isEdge(tmp.retrieve(), i)) {
				tmp1=adj.retrieve(i).second;
				ch=true;
			}
			tmp.findNext();
		}
		if (tmp.exists(tmp.retrieve())	) {
			tmp1=adj.retrieve(i).second;
			ch=true;
		}

		if (ch) {
			return tmp1;
		}
		return null;
		}catch (Exception e) {
			return null;
			// TODO: handle exception
		}
	}
	@Override
	public int deg(K i) {
		try {
		List<K> tmp=this.getNodes();
		boolean ch=false;
		tmp.findFirst();
		while (tmp.last() == false) {
			if (tmp.retrieve().equals(i))
				ch=true;
			tmp.findNext();
		}
		if (tmp.retrieve().equals(i))
			ch=true;
		if (ch==false) {
			return -1;
		}
		List<K> tmp1=adj.retrieve(i).second;
		tmp1.findFirst();
		int x=0;
		while (tmp1.last()==false) {
			x++;
			tmp1.findNext();
		}
		return tmp1.size();
		}catch (Exception e) {
			return -1;
			// TODO: handle exception
		}
	}
	@Override
	public List<K> getNodes() {
		try {
		
		List<K> tmp =new LinkedList<K>();
		tmp=adj.getKeys();
		
		return tmp;
		}catch (Exception e) {
			return new LinkedList<K>();
			// TODO: handle exception
		}
		}
		
	
	
}
