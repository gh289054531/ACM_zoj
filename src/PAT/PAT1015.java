//java超时，用c++
package PAT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class PAT1015 {
	public static int L;
	public static int H;
	public static LinkedList<Student> list1 = new LinkedList<Student>();
	public static LinkedList<Student> list2 = new LinkedList<Student>();
	public static LinkedList<Student> list3 = new LinkedList<Student>();
	public static LinkedList<Student> list4 = new LinkedList<Student>();
	public static int type5num = 0;

	public static void main(String[] args) throws IOException {
		//long start = System.currentTimeMillis();
		// BufferedReader reader = new BufferedReader(new
		// FileReader("test.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] line = reader.readLine().split(" ");
		int N = Integer.parseInt(line[0]);
		L = Integer.parseInt(line[1]);
		H = Integer.parseInt(line[2]);
		for (int i = 0; i < N; i++) {
			String[] curline = reader.readLine().split(" ");
			int no = Integer.parseInt(curline[0]);
			int de = Integer.parseInt(curline[1]);
			int cai = Integer.parseInt(curline[2]);
			Student s = new Student(no, de, cai);
		}
		reader.close();
		Collections.sort(list1);
		Collections.sort(list2);
		Collections.sort(list3);
		Collections.sort(list4);
		StringBuilder sb = new StringBuilder(4800000);
		for (Student stu : list1) {
			sb.append(stu.toString());
			sb.append("\n");
		}
		for (Student stu : list2) {
			sb.append(stu.toString());
			sb.append("\n");
		}
		for (Student stu : list3) {
			sb.append(stu.toString());
			sb.append("\n");
		}
		for (Student stu : list4) {
			sb.append(stu.toString());
			sb.append("\n");
		}
		System.out.println(N - type5num);
		System.out.print(sb.toString());
		//long end = System.currentTimeMillis();
		//System.out.println(end - start);
	}

	static class Student implements Comparable<Student> {
		int no;
		int de;
		int cai;
		int total;
		int type;// 1才德全尽 2德胜才 3才德兼亡但尚有德胜才 4其它 5无资格

		public Student(int no, int de, int cai) {
			this.no = no;
			this.de = de;
			this.cai = cai;
			this.total = de + cai;
			if (de < L || cai < L) {
				this.type = 5;
				type5num++;
			} else if (de >= H && cai >= H) {
				this.type = 1;
				list1.add(this);
			} else if (de >= H && cai < H) {
				this.type = 2;
				list2.add(this);
			} else if (de < H && cai < H && de >= cai) {
				this.type = 3;
				list3.add(this);
			} else {
				this.type = 4;
				list4.add(this);
			}
		}

		public int compareTo(Student o) {
			if (this.total != o.total) {
				return o.total - this.total;
			} else if (this.de != o.de) {
				return o.de - this.de;
			} else {
				return this.no - o.no;
			}
		}

		public String toString() {
			return this.no + " " + this.de + " " + this.cai;
		}
	}
}

/*
#include <cstdio>  
#include <algorithm>  
#include <vector>  
#include <string>  
  
using namespace std;  
    
typedef struct Student  
{  
    string  ID;  
  
    int  De;  
    int Cai;  
}Student;  
  
inline bool compare(Student a,Student b)  
{  
    if ((a.Cai+a.De)!=(b.Cai+b.De))  
    return a.Cai+a.De>b.Cai+b.De;  
    else if (a.De!=b.De)  
    return a.De>b.De;  
    else  
    return a.ID<b.ID;  
}  
  
  
inline void print(Student s)  
{ 
//  cout<<s.ID<<" "<<s.De<<" "<<s.Cai<<endl;
    printf("%s %d %d\n",s.ID.c_str(),s.De,s.Cai);  
}  
  
int main()  
{  
     int N,L,H;  
     char id[10];  
     Student  S;  
     string  ID;  
     vector<Student>    vec1;  
     vector<Student>    vec2;  
     vector<Student>    vec3;  
     vector<Student>    vec4;  
  
    // cin>>N>>L>>H; 
     scanf("%d %d %d",&N,&L,&H);  
  
     while(N--)  
     {  
        //cin>>S.ID>>S.De>>S.Cai; 
         scanf("%s%d%d",id,&S.De,&S.Cai);  
         S.ID.assign(id);  
        if (S.De>=L&&S.Cai>=L)  
        {  
            if (S.De>=H&&S.Cai>=H)  
                vec1.push_back(S);  
            else  
            if (S.De>=H&&S.Cai<H)  
                vec2.push_back(S);  
            else  
           if (S.De<H&&S.Cai<H&&S.De>=S.Cai)  
                vec3.push_back(S);  
            else  
                vec4.push_back(S);    
        }  
     }  
     sort(vec1.begin(),vec1.end(),compare);  
     sort(vec2.begin(),vec2.end(),compare);  
     sort(vec3.begin(),vec3.end(),compare);  
     sort(vec4.begin(),vec4.end(),compare);  
  
    // cout<<vec1.size()+vec2.size()+vec3.size()+vec4.size()<<endl; 
     printf("%d\n",vec1.size()+vec2.size()+vec3.size()+vec4.size());  
  
       
     for_each(vec1.begin(),vec1.end(),print);  
     for_each(vec2.begin(),vec2.end(),print);  
     for_each(vec3.begin(),vec3.end(),print);  
     for_each(vec4.begin(),vec4.end(),print);  
    //  system("PAUSE");  
    return 0;  
} 
*/
