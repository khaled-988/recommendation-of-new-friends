public class Main {

	private static void testPQK() {
		System.out.println("-------------------");
		PQK<Integer, String> pq = new PQKImp<Integer, String>(3);
		pq.enqueue(5, "A");
		pq.enqueue(3, "B");
		pq.enqueue(2, "C");
		pq.enqueue(1, "D");
		pq.enqueue(2, "E");
		pq.enqueue(4, "F");
		pq.enqueue(6, "G");
		pq.enqueue(7, "H");
		pq.enqueue(8, "I");
		pq.enqueue(8, "J");
		pq.enqueue(7, "K");
		pq.enqueue(6, "L");
		pq.enqueue(5, "M");
		while (pq.length() > 0) {
			Pair<Integer, String> p = pq.serve();
			System.out.println(p.first + "\t" + p.second);
		}
		System.out.println("-------------------");
	}

	private static void testMap() {
		System.out.println("-------------------");
		Map<Integer, Integer> m = new BSTMap<Integer, Integer>();
		for (int i = 100; i > 0; i--) {
			m.insert(i % 13, i);
		}
		List<Integer> l = m.getKeys();
		l.findFirst();
		while (true) {
			int k = l.retrieve();
			System.out.println(k);
			if (l.last()) {
				break;
			} else {
				l.findNext();
			}
		}
		System.out.println("-------------------");
	}

	private static void testGraph() {
		System.out.println("-------------------");
		int n = 8;
		Graph<Integer> g = new MGraph<Integer>();
		for (int i = 0; i < n; i++) {
			g.addNode(i);
		}
		for (int i = 0; i < n; i++) {
			g.addEdge(i, (i + 1) % n);
		}
		List<Integer> l = g.getNodes();
		l.findFirst();
		while (!l.last()) {
			int i = l.retrieve();
			List<Integer> ni = g.neighb(i);
			if (!ni.empty()) {
				ni.findFirst();
				while (true) {
					int j = ni.retrieve();
					System.out.println(i + "\t" + j);
					if (ni.last()) {
						break;
					} else {
						ni.findNext();
					}
				}
			}
			if (l.last()) {
				break;
			} else {
				l.findNext();
			}
		}
		System.out.println("-------------------");
	}

	private static void testRecommender() {
		System.out.println("-------------------");
		Graph<Integer> g = Recommender.read("C://Users//Lenovo//Desktop//PA4/graph.txt");
		{
			PQK<Double, Integer> top = Recommender.recommendPop(g, 3, 4);
			while (top.length() > 0) {
				Pair<Double, Integer> e = top.serve();
				System.out.println(e.second + "\t" + e.first);
			}
		}
		System.out.println("----------");
		{
			PQK<Double, Integer> top = Recommender.recommendCN(g, 3, 4);
			while (top.length() > 0) {
				Pair<Double, Integer> e = top.serve();
				System.out.println(e.second + "\t" + e.first);
			}
		}
		System.out.println("-------------------");
	}

	public static void main(String[] args) {
		List<Integer> l=new LinkedList<>();
		System.out.println(l.size()+"\n");
		l.insert(5);
		System.out.println(l.size()+"\n");
		l.insert(4);
		System.out.println(l.size()+"\n");
		l.remove();
		System.out.println(l.size()+"\n");
		l.findFirst();
		l.remove();
		System.out.println(l.size()+"\n");

	}
}