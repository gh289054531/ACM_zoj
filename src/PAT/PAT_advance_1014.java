package PAT;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 3个点没过
 * 
 * @author root
 * 
 */
public class PAT_advance_1014 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int q = sc.nextInt();
		int[] time = new int[k];
		LinkedList<Integer>[] inYellow = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			inYellow[i] = new LinkedList<Integer>();
		}
		LinkedList<Integer> outYellow = new LinkedList<Integer>();
		int i = 0;
		boolean flag = true;
		while (flag) {
			for (int j = 0; j < n; j++, i++) {
				if (i == m * n) {
					while (i++ < k) {
						outYellow.add(sc.nextInt());
					}
					flag = false;
					break;
				}
				if (i < k && i < m * n) {
					int servetime = sc.nextInt();
					if (i < n) {
						inYellow[j].add(servetime);
						time[i] = servetime;
					} else {
						int temp = servetime + inYellow[j].peekLast();
						inYellow[j].add(temp);
						time[i] = temp;
					}
				} else {
					flag = false;
					break;
				}
			}
		}

		if (k > m * n) {
			int customers = m * n;
			while (customers < k) {
				int minTime = Integer.MAX_VALUE;
				int minID = -1;
				for (i = 0; i < n; i++) {
					if (inYellow[i].size() != 0) {
						if (inYellow[i].peek() < minTime) {
							minTime = inYellow[i].peek();
							minID = i;
						}
					}
				}

				int temp = outYellow.pollFirst() + inYellow[minID].peekLast();
				inYellow[minID].add(temp);
				inYellow[minID].pollFirst();
				time[customers] = temp;
				customers++;
			}
		}

		for (i = 0; i < q; i++) {
			int queryID = sc.nextInt() - 1;
			int curtime = time[queryID];
			if (curtime > 540) {
				System.out.println("Sorry");
			} else {
				int hour = curtime / 60 + 8;
				int minute = curtime - curtime / 60 * 60;
				String left = hour + "";
				String right = minute + "";
				if (hour < 10) {
					left = "0" + hour;
				}
				if (minute < 10) {
					right = "0" + minute;
				}
				System.out.println(left + ":" + right);
			}
		}
		sc.close();
	}
}
