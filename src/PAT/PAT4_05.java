//最后一个case超时

package PAT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PAT4_05 {
	static class Node {
		String name;
		Node left, right;

		public Node(String name) {
			this.name = name;
			this.left = null;
			this.right = null;
		}
	}

	public static Node Add(Node root, int level, String name) {
		Node newnode = new Node(name);
		if (level == 0) {
			return newnode;
		}
		Node targetlevel = root;
		for (int i = 0; i < level; i++) {
			if (targetlevel.left == null) {
				targetlevel.left = newnode;
				return root;
			}
			targetlevel = targetlevel.left;
			while (targetlevel.right != null) {
				targetlevel = targetlevel.right;
			}
		}
		targetlevel.right = newnode;
		return root;
	}

	public static Node GetParaent(Node node, String name) {
		if (node == null || node.left == null) {
			return null;
		}
		Node childs = node.left;
		while (childs != null) {
			if (childs.name.equals(name)) {
				return node;
			}
			childs = childs.right;
		}
		Node result = GetParaent(node.right, name);
		if (result != null) {
			return result;
		}
		result = GetParaent(node.left, name);
		if (result != null) {
			return result;
		}
		return null;
	}

	public static Node Get(Node node, String name) {
		if (node == null) {
			return null;
		}
		if (node.name.equals(name)) {
			return node;
		}
		Node result = null;
		result = Get(node.right, name);
		if (result != null) {
			return result;
		}
		result = Get(node.left, name);
		if (result != null) {
			return result;
		}
		return null;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] firtline = reader.readLine().split(" ");
		int n = Integer.parseInt(firtline[0]);
		int m = Integer.parseInt(firtline[1]);
		Node root = null;
		for (int i = 0; i < n; i++) {
			String line = reader.readLine();
			String name = line.trim();
			int blanknum = line.length() - name.length();
			int level = blanknum / 2;
			root = Add(root, level, name);
		}
		for (int i = 0; i < m; i++) {
			String[] line = reader.readLine().split(" ");
			String name1 = line[0];
			String name2 = line[5];
			String relation = line[3];
			if (relation.equals("child")) {
				Node node2 = Get(root, name2);
				Node childs = node2.left;
				while (childs != null) {
					if (childs.name.equals(name1)) {
						System.out.println("True");
						break;
					}
				}
				if (childs == null) {
					System.out.println("False");
				}
				continue;
			}
			if (relation.equals("parent")) {
				Node node1 = Get(root, name1);
				Node childs = node1.left;
				while (childs != null) {
					if (childs.name.equals(name2)) {
						System.out.println("True");
						break;
					}
					childs = childs.right;
				}
				if (childs == null) {
					System.out.println("False");
				}
				continue;
			}
			if (relation.equals("sibling")) {
				Node node1paraent = GetParaent(root, name1);
				Node childs = node1paraent.left;
				while (childs != null) {
					if (childs.name.equals(name2)) {
						System.out.println("True");
						break;
					}
					childs = childs.right;
				}
				if (childs == null) {
					System.out.println("False");
				}
				continue;
			}
			if (relation.equals("descendant")) {
				Node node2 = Get(root, name2);
				Node node1 = Get(node2, name1);
				if (node1 == null) {
					System.out.println("False");
				} else {
					System.out.println("True");
				}
				continue;
			}
			if (relation.equals("ancestor")) {
				Node node1 = Get(root, name1);
				Node node2 = Get(node1, name2);
				if (node2 == null) {
					System.out.println("False");
				} else {
					System.out.println("True");
				}
				continue;
			}
		}
	}

}
