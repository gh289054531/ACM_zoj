package PAT;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class PAT1004 {

	public static void main(String[] args) throws FileNotFoundException {
		//Scanner sc = new Scanner(new File("test.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Record[] records = new Record[n];
		for (int i = 0; i < n; i++) {
			String name = sc.next();
			String num = sc.next();
			int score = sc.nextInt();
			records[i] = new Record(name, num, score);
		}
		Arrays.sort(records);
		System.out.println(records[n - 1].toString());
		System.out.println(records[0].toString());
		sc.close();
	}
}

class Record implements Comparable<Record> {
	String name;
	String num;
	int score;

	public Record(String name, String num, int score) {
		this.name = name;
		this.num = num;
		this.score = score;
	}

	public int compareTo(Record o) {
		if (this.score > o.score) {
			return 1;
		} else if (this.score < o.score) {
			return -1;
		} else {
			return 0;
		}
	}

	public String toString() {
		return name + " " + num;
	}
}