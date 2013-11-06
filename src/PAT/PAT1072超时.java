package PAT;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PAT1072超时 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int Ds = sc.nextInt();
		sc.nextLine();
		HashMap<String, Vertex> graph = new HashMap<String, Vertex>((N + M));
		while (sc.hasNext()) {
			String index1 = sc.next();
			String index2 = sc.next();
			Integer dist = sc.nextInt();
			Vertex v1 = graph.get(index1);
			if (v1 == null) {
				v1 = new Vertex(index1, (N + M) );
				graph.put(index1, v1);
			}
			Vertex v2 = graph.get(index2);
			if (v2 == null) {
				v2 = new Vertex(index2, (N + M) );
				graph.put(index2, v2);
			}
			v1.adjcent.put(v2, dist);
			v2.adjcent.put(v1, dist);
		}
		Vertex best = null;
		int bestMinDist = Integer.MIN_VALUE;
		int bestsum = 0;
		for (Entry<String, Vertex> entry : graph.entrySet()) {
			Vertex v = entry.getValue();
			if (v.isGasstation) {
				v.dist = 0;
				PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
				pq.add(v);
				while (pq.isEmpty() == false) {
					v = pq.poll();
					if (v.known == true) {
						continue;
					}
					v.known = true;
					for (Entry<Vertex, Integer> entry1 : v.adjcent.entrySet()) {
						Vertex adj = entry1.getKey();
						int adjDist = entry1.getValue();
						if (v.dist + adjDist < adj.dist) {
							adj.dist = v.dist + adjDist;
							pq.add(adj);
						}
					}
				}
				int sum = 0;
				int minDist = Integer.MAX_VALUE;
				boolean flag = false;
				for (Entry<String, Vertex> entry3 : graph.entrySet()) {
					Vertex curV = entry3.getValue();
					if (curV.isGasstation == false) {
						if (curV.dist > Ds) {
							flag = true;
							break;
						} else {
							sum += curV.dist;
							minDist = curV.dist < minDist ? curV.dist : minDist;
						}
					}
					curV.dist = Integer.MAX_VALUE;
					curV.known = false;
				}
				if (flag == false) {
					if (bestMinDist < minDist) {
						bestMinDist = minDist;
						best = entry.getValue();
						bestsum = sum;
					} else if (bestMinDist == minDist) {
						if (sum < bestsum) {
							best = entry.getValue();
							bestsum = sum;
						} else if (sum == bestsum) {
							best = entry.getValue().index.compareTo(best.index) < 0 ? entry.getValue() : best;
						}
					}
				}
			}
		}
		if (best == null) {
			System.out.println("No Solution");
		} else {
			System.out.println(best.index);
			System.out.printf("%.1f %.1f", bestMinDist + 0.0, (bestsum + 0.0) / N);
		}
		sc.close();
	}

}

class Vertex implements Comparable<Vertex> {
	String index;
	boolean known = false;
	boolean isGasstation = false;
	HashMap<Vertex, Integer> adjcent = null;
	int dist = Integer.MAX_VALUE;

	public Vertex(String index, int adjMaxNumber) {
		adjcent = new HashMap<Vertex, Integer>(adjMaxNumber * 2);
		this.index = index;
		if (index.startsWith("G")) {
			this.isGasstation = true;
		}
	}

	@Override
	public int compareTo(Vertex o) {
		if (this.dist > o.dist) {
			return 1;
		} else if (this.dist < o.dist) {
			return -1;
		} else {
			return 0;
		}
	}

	public String toString() {
		return index + ":" + String.valueOf(dist);
	}

}