import java.util.Scanner;

public class PATadvance1004 {
	static class Node {
		int id;
		int[] childid = new int[100];
		int k = 0;

		public Node(int id) {
			this.id = id;
		}
	}

	public static void DFS(Node[] nodes, int curnode, int curlevel,
			int[] count, boolean[] visited) {
		if (curlevel > maxlevel) {
			maxlevel = curlevel;
		}
		visited[curnode] = true;
		if (nodes[curnode].k != 0) {
			for (int j = 0; j < nodes[curnode].k; j++) {
				if (visited[nodes[curnode].childid[j]] == false) {
					DFS(nodes, nodes[curnode].childid[j], curlevel + 1, count,
							visited);
				}
			}
		} else {
			count[curlevel]++;
		}
	}

	public static int maxlevel = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		Node[] nodes = new Node[N];
		for (int i = 0; i < N; i++) {
			nodes[i] = new Node(i);
		}
		for (int i = 0; i < M; i++) {
			int nodeid = sc.nextInt() - 1;
			int k = sc.nextInt();
			nodes[nodeid].k = k;
			for (int j = 0; j < k; j++) {
				nodes[nodeid].childid[j] = sc.nextInt() - 1;
			}
		}
		sc.close();
		int[] count = new int[N];
		boolean[] visited = new boolean[N];
		DFS(nodes, 0, 0, count, visited);
		for (int i = 0; i < maxlevel; i++) {
			System.out.print(count[i] + " ");
		}
		System.out.println(count[maxlevel]);
	}
}
