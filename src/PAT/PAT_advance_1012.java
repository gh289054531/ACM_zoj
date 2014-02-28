package PAT;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class PAT_advance_1012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Student[] s = new Student[n];
		HashMap<String, Student> ids = new HashMap<String, Student>(2 * n);
		for (int i = 0; i < n; i++) {
			String id = sc.next();
			s[i] = new Student(sc.nextInt(), sc.nextInt(), sc.nextInt());
			ids.put(id, s[i]);
		}
		String[] querys = new String[m];
		for (int i = 0; i < m; i++) {
			querys[i] = sc.next();
		}
		sc.close();

		Arrays.sort(s, new ComparatorA());
		s[0].ranka = 1;
		for (int i = 1; i < n; i++) {
			if (s[i].a == s[i - 1].a) {
				s[i].ranka = s[i - 1].ranka;
			} else {
				s[i].ranka = i + 1;
			}
		}
		Arrays.sort(s, new ComparatorC());
		s[0].rankc = 1;
		for (int i = 1; i < n; i++) {
			if (s[i].c == s[i - 1].c) {
				s[i].rankc = s[i - 1].rankc;
			} else {
				s[i].rankc = i + 1;
			}
		}

		Arrays.sort(s, new ComparatorM());
		s[0].rankm = 1;
		for (int i = 1; i < n; i++) {
			if (s[i].m == s[i - 1].m) {
				s[i].rankm = s[i - 1].rankm;
			} else {
				s[i].rankm = i + 1;
			}
		}

		Arrays.sort(s, new ComparatorE());
		s[0].ranke = 1;
		for (int i = 1; i < n; i++) {
			if (s[i].e == s[i - 1].e) {
				s[i].ranke = s[i - 1].ranke;
			} else {
				s[i].ranke = i + 1;
			}
		}

		for (String id : querys) {
			if (ids.containsKey(id)) {
				System.out.println(ids.get(id).bestRank());
			} else {
				System.out.println("N/A");
			}
		}
	}

}

class Student {
	int c;
	int m;
	int e;
	double a;

	int rankc;
	int rankm;
	int ranke;
	int ranka;

	public Student(int c, int m, int e) {
		this.c = c;
		this.m = m;
		this.e = e;
		this.a = (c + m + e + 0.0) / 3;
	}

	public String bestRank() {
		if (ranka <= rankc && ranka <= rankm && ranka <= ranke) {
			return ranka + " A";
		}
		if (rankc < ranka && rankc <= rankm && rankc <= ranke) {
			return rankc + " C";
		}
		if (rankm < ranka && rankm < rankc && rankm <= ranke) {
			return rankm + " M";
		}
		return ranke + " E";
	}
}

class ComparatorA implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		if (o1.a < o2.a) {
			return 1;
		} else if (o1.a > o2.a) {
			return -1;
		} else {
			return 0;
		}
	}
}

class ComparatorC implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		if (o1.c < o2.c) {
			return 1;
		} else if (o1.c > o2.c) {
			return -1;
		} else {
			return 0;
		}
	}
}

class ComparatorM implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		if (o1.m < o2.m) {
			return 1;
		} else if (o1.m > o2.m) {
			return -1;
		} else {
			return 0;
		}
	}
}

class ComparatorE implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		if (o1.e < o2.e) {
			return 1;
		} else if (o1.e > o2.e) {
			return -1;
		} else {
			return 0;
		}
	}
}
