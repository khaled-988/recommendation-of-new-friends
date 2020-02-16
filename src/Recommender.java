import java.io.File;
import java.util.Scanner;

public class Recommender {

	public static <K extends Comparable<K>> PQK<Double, K> recommendPop(Graph<K> g, K i, int k) {
		//PQKImp<Double, K> pop=new PQKImp<>(k);
		try {
		if ( g== null ||g.getNodes().size()== 0)
			return null;
		if (g.isNode(i)==false)
			return null;
		List<K> nodes=g.getNodes();
		PQKImp<Double, K> save=new PQKImp<>(k);
		nodes.findFirst();
		for (int j=0;j<nodes.size();j++) {
			if(nodes.retrieve().compareTo(i) != 0) {
				
			if (g.isEdge(i, nodes.retrieve())== false) {
				save.enqueue((double) g.neighb(nodes.retrieve()).size(), nodes.retrieve());
			}
			}
			nodes.findNext();
		}
		return save;
		}catch (Exception e) {
			return null;
			// TODO: handle exception
		}
	}

	
	// Return the top k recommended friends for user i using the popular nodes
	// method. If i does not exist, return null. In case of a tie, users with the
	// lowest id are selected.
	/*public static <K extends Comparable<K>> PQK<Double, K> recommendPop1(Graph<K> g, K i, int k) {
		try {
		PQKImp<Double, K> ret=new PQKImp<>(k);
		if (!g.isNode(i))
			return null;
		List<K>tmp= g.neighb(i);
		if (tmp.size()==0)
			return null;
		//ÇÐÇ ãÇ ÚäÏå ÌíÑÇä æÔ ÇÓæí ¿¿¿¿
		boolean t=true;
		tmp.findFirst();
		List<K>tmp1= new LinkedList<>();
		List<K> check=g.getNodes();
		check.findFirst();
		for (int x=0;x<check.size();x++) {
			t=true;
			tmp.findFirst();
			for (int y=0;y<tmp.size();y++) {
				if (check.retrieve().equals(tmp.retrieve())) {
					t=false;
				}
				tmp.findNext();
			}
			
			if (t) {
				tmp1.insert(check.retrieve());
			}
			check.findNext();
			
		}
		tmp1.findFirst();
		
		List<K> result =new LinkedList<>();
		int qw=g.deg(tmp1.retrieve());
		K kk=null;
		for (int x=0;x<tmp1.size()-1;x++) {
			tmp1.findNext();
			qw=g.deg(tmp1.retrieve());
			kk=tmp1.retrieve();
			for (int y=x+1;y<tmp1.size()-1;y++) {
			if (qw<g.deg(tmp1.retrieve())) {
				qw=g.deg(tmp1.retrieve());
				kk=tmp1.retrieve();
			}
			tmp1.findNext();
			}
			
			result.insert(kk);
			tmp1.exists(kk);
			tmp1.remove();
			tmp1.findFirst();
			for (int z=0;z<=x;z++) {
				tmp1.findNext();
			}
		}
		List<K> result1 =new LinkedList<>();
		if (result.size() != 0)
			result.findFirst();
		for (int tt=0;tt<k;tt++) {
			K key=result.retrieve();
			int s=g.deg(key);
			if (result.size() != 0) {
				result.findNext();
				if (result.empty()==false)
				if (s==g.deg(result.retrieve())) {
					if (result.retrieve().compareTo(key)==1) {
						result.exists(key);
						result.remove();
						result1.insert(key);
					}
				}else
					result1.insert(key);
			}
		}
		double dds=0.0;
		result1.findFirst();
		for (int b=0;b<result1.size();b++) {
			
			 dds=g.deg(result1.retrieve());
			ret.enqueue(dds, result1.retrieve());
			result1.findNext();
		}
		return ret;
		}catch (Exception e) {
			return null;
			// TODO: handle exception
		}
	}*/

	public static <K extends Comparable<K>> PQK<Double, K> recommendCN(Graph<K> g, K i, int k) {
		try {
			if (g==null||g.getNodes().size()== 0)
				return null;
			if (g.isNode(i)==false)
				return null;
			List<K> nodes=g.getNodes();
			List<K> check=g.neighb(i);
			PQKImp<Double, K> save=new PQKImp<>(k);
			nodes.findFirst();
			for (int j=0;j<nodes.size();j++) {
				double count=0.0;
				if(nodes.retrieve().compareTo(i) != 0) {
					
				if (g.isEdge(i, nodes.retrieve())== false) {
					List<K> com=g.neighb(nodes.retrieve());
					com.findFirst();
					for (int t1=0;t1<com.size();t1++) {
						check.findFirst();
						
					for (int t=0;t<check.size();t++) {
						if (com.retrieve().equals(check.retrieve()))
							count++;
						check.findNext();
					}
					com.findNext();
					}
					save.enqueue(count, nodes.retrieve());
				}
				}
				nodes.findNext();
			}
			return save;
			}catch (Exception e) {
				return null;
				// TODO: handle exception
			}
	}
	
	// Return the top k recommended friends for user i using common neighbors
	// method. If i does not exist, return null. In case of a tie, users with the
	// lowest id are selected.
	
		

	// Read graph from file. The file is a text file where each line contains an
	// edge. The end and start of the edge are separated by space(s) or tabs.
	public static Graph<Integer> read(String fileName) {

		try {
			Graph<Integer> g = new MGraph<Integer>();
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNextInt()) {
				int i = scanner.nextInt();
				g.addNode(i);
				int j = scanner.nextInt();
				g.addNode(j);
				g.addEdge(i, j);
			}
			scanner.close();
			return g;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
