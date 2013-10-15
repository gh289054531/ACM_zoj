/*
 * 部分超时,C改写通过
 */
package PAT;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PAT2_11 {

	static PrintWriter cout = new PrintWriter(new BufferedOutputStream(System.out));

	public static void printList(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			cout.print(list.get(i));
			if (i != list.size() - 1) {
				cout.print(" ");
			}
		}
		cout.flush();
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		//Scanner sc = new Scanner(new File("test.txt"));
		ArrayList<Integer> list1 = new ArrayList<Integer>(300000);
		ArrayList<Integer> list2 = new ArrayList<Integer>(300000);
		while (true) {
			int curnum = sc.nextInt();
			if (curnum != -1) {
				list1.add(curnum);
			} else {
				break;
			}
		}
		while (true) {
			int curnum = sc.nextInt();
			if (curnum != -1) {
				list2.add(curnum);
			} else {
				break;
			}
		}
		sc.close();
		if (list1.size() == 0 && list2.size() == 0) {
			System.out.println("NULL");
		} else if (list1.size() == 0) {
			printList(list2);
		} else if (list2.size() == 0) {
			printList(list1);
		} else {
			int i = 0, j = 0;
			for (; i < list1.size() && j < list2.size();) {
				int num1 = list1.get(i);
				int num2 = list2.get(j);
				if (num1 > num2) {
					cout.print(num2 + " ");
					j++;
				} else if (num1 < num2) {
					cout.print(num1 + " ");
					i++;
				} else {
					cout.print(num1 + " " + num2);
					i++;
					j++;
					if (list1.size() != i || list2.size() != j) {
						cout.print(" ");
					}
				}
			}
			if (list1.size() == i && list2.size() != j) {
				for (; j < list2.size(); j++) {
					cout.print(list2.get(j));
					if (j != (list2.size() - 1)) {
						cout.print(" ");
					}
				}
			}
			if (list2.size() == j && list1.size() != i) {
				for (; i < list1.size(); i++) {
					cout.print(list1.get(i));
					if (i != list1.size() - 1) {
						cout.print(" ");
					}
				}
			}
			cout.flush();
		}
	}
}

/*
#include <stdio.h>

void printList(int list[],int length) {
	long i=0;
	for (; i < length; i++) {
		printf("%d",list[i]);
		if (i != length - 1) {
			printf(" ");
		}else{
			printf("\n");
		}
	}
}
int list1[2000000];//在全局变量区域分配内存 
int list2[2000000];
int main(){
	//freopen("test.txt","r",stdin);

	int x=-1;
	long index1=0;
	long index2=0;
	while (scanf("%d",&x)) {
		if(x!=-1){
			list1[index1++]=x;
		}else{
			break;
		}
	}
	while (scanf("%d",&x)) {
		if(x!=-1){
			list2[index2++]=x;
		}else{
			break;
		}
	}
	if (index1 == 0 && index2 == 0) {
		printf("NULL\n");
	} else if (index1 == 0) {
		printList(list2,index2);
	} else if (index2 == 0) {
		printList(list1,index1);
	} else {
		long i = 0, j = 0;
		for (; i <index1&& j < index2;) {
			int num1 = list1[i];
			int num2 = list2[j];
			if (num1 > num2) {
				printf("%d",num2);
				j++;
			} else if (num1 < num2) {
				printf("%d",num1);
				i++;
			} else {
				printf("%d %d",num1 , num2);
				i++;
				j++;			
			}
			if (index1 != i || index2 != j) {
				printf(" ");
			}	
		}
		if (index1 == i && index2 != j) {
			for (; j < index2; j++) {
				printf("%d",list2[j]);
				if (j != (index2 - 1)) {
					printf(" ");
				}		
			}
		}
		if (index2 == j && index1 != i) {
			for (; i < index1; i++) {
				printf("%d",list1[i]);
				if (i != index1 - 1) {
					printf(" ");
				}
			}
		}
		printf("\n");
	}
	return 0;
}

*/
