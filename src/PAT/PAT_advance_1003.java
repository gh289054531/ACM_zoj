import java.util.Scanner;

public class PAT_advance_1003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int c1 = sc.nextInt();
		int c2 = sc.nextInt();
		int[][] map = new int[n][n];
		Node[] city = new Node[n];
		for (int i = 0; i < n; i++) {
			city[i] = new Node(sc.nextInt());
		}
		for (int i = 0; i < m; i++) {
			int source = sc.nextInt();
			int dest = sc.nextInt();
			int dist = sc.nextInt();
			map[source][dest] = dist;
			map[dest][source] = dist;
		}
		city[c1].dist = 0;
		city[c1].pathNum = 1;
		Dijstra(c1, c2, city, map);
		System.out.println(city[c2].pathNum + " " + city[c2].totalRescue);
		sc.close();
	}

	public static void Dijstra(int c1, int c2, Node[] city, int[][] map) {
		while (true) {
			int min = Integer.MAX_VALUE;
			int curCity = -1;
			for (int i = 0; i < city.length; i++) {
				if (city[i].visited == false && city[i].dist < min) {
					min = city[i].dist;
					curCity = i;
				}
			}
			if (curCity == -1) {
				return;
			}
			city[curCity].visited = true;
			for (int i = 0; i < city.length; i++) {
				if (map[curCity][i] > 0) {
					int newdist = city[curCity].dist + map[curCity][i];
					if (newdist < city[i].dist) {
						city[i].dist = newdist;
						city[i].totalRescue = Math.max(
								city[curCity].totalRescue + city[i].rescue,
								city[i].totalRescue);
						city[i].pathNum = city[curCity].pathNum;
					} else if (newdist == city[i].dist) {
						city[i].totalRescue = Math.max(
								city[curCity].totalRescue + city[i].rescue,
								city[i].totalRescue);
						city[i].pathNum += city[curCity].pathNum;
					}
				}
			}
		}
	}
}

class Node {
	int rescue;
	boolean visited = false;
	int dist = Integer.MAX_VALUE;
	int totalRescue;
	int pathNum = 0;

	public Node(int rescue) {
		this.rescue = rescue;
		this.totalRescue = rescue;
	}
}
