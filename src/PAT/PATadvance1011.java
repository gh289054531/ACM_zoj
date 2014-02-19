import java.util.Scanner;
import java.util.PriorityQueue;

public class PATadvance1011 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Double> threeMaxOdd = new PriorityQueue<Double>();
		threeMaxOdd.add(Double.MIN_VALUE);
		threeMaxOdd.add(Double.MIN_VALUE);
		threeMaxOdd.add(Double.MIN_VALUE);
		while (sc.hasNext()) {
			Double w = sc.nextDouble();
			Double t = sc.nextDouble();
			Double l = sc.nextDouble();
			if (w > t && w > l) {
				System.out.print("W ");
				if (w > threeMaxOdd.peek()) {
					threeMaxOdd.poll();
					threeMaxOdd.add(w);
				}
			}
			if (t > w && t > l) {
				System.out.print("T ");
				if (t > threeMaxOdd.peek()) {
					threeMaxOdd.poll();
					threeMaxOdd.add(t);
				}
			}
			if (l > w && l > t) {
				System.out.print("L ");
				if (l > threeMaxOdd.peek()) {
					threeMaxOdd.poll();
					threeMaxOdd.add(l);
				}
			}
		}
		sc.close();
		Double maxProfile = 2.0 * ((threeMaxOdd.poll() * threeMaxOdd.poll() * threeMaxOdd
				.poll()) * 0.65 - 1.0);
		maxProfile = Math.round(maxProfile * 100) / 100.0;
		System.out.printf("%.2f", maxProfile);
	}
}
