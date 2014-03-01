package PAT;
import java.util.Scanner;

public class PAT_advance_2013 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		boolean[][] connect = new boolean[n][n];
		for (int i = 0; i < m; i++) {
			int c1 = sc.nextInt() - 1;
			int c2 = sc.nextInt() - 1;
			connect[c1][c2] = true;
			connect[c2][c1] = true;
		}
		for (int i = 0; i < k; i++) {
			int city = sc.nextInt() - 1;
			boolean[][] temp = new boolean[n][n];
			for (int j = 0; j < n; j++) {
				System.arraycopy(connect[j], 0, temp[j], 0, n);
			}
			for (int x = 0; x < n; x++) {
				temp[city][x] = false;
				temp[x][city] = false;
			}
			System.out.println(Cal(temp, n));
		}
		sc.close();

	}

	public static int Cal(boolean[][] connect, int n) {
		boolean[] visited = new boolean[n];
		int begin = 0;
		visited[begin] = true;
		int unConnectGraph = 0;
		while (begin != -1) {
			dfs(begin, connect, n, visited);
			unConnectGraph++;
			begin = -1;
			for (int i = 0; i < n; i++) {
				if (visited[i] == false) {
					begin = i;
					visited[i] = true;
					break;
				}
			}
		}
		return unConnectGraph - 2;
	}

	public static void dfs(int begin, boolean[][] connect, int n, boolean[] visited) {
		for (int i = 0; i < n; i++) {
			if (visited[i] == false && connect[begin][i] == true) {
				visited[i] = true;
				dfs(i, connect, n, visited);
			}
		}
	}
}
