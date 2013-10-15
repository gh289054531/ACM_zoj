//²¿·Ö³¬Ê±£¬»»c++
package PAT;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Scanner;

public class PAT5_05 {
	public static void main(String[] args) {
		HashMap<String, String> zhanghao = new HashMap<String, String>(50000);
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			String minglingfu = sc.next();
			String qq = sc.next();
			String password = sc.next();
			if (minglingfu.equals("N")) {
				if (zhanghao.containsKey(qq) == true) {
					System.out.println("ERROR: Exist");
				} else {
					zhanghao.put(qq, password);
					System.out.println("New: OK");
				}
			} else {
				if (zhanghao.containsKey(qq) == true) {
					if (zhanghao.get(qq).equals(password)) {
						System.out.println("Login: OK");
					} else {
						System.out.println("ERROR: Wrong PW");
					}
				} else {
					System.out.println("ERROR: Not Exist");
				}
			}
		}
		sc.close();
	}
}

/*
#include <stdio.h>
#include <string>
#include <map>
#include <iostream>
using namespace std;

int main() {
	//freopen("test.txt","r",stdin);
	map <string, string> zhanghao;
	int N;
	scanf("%d",&N);
	for (int i = 0; i < N; i++) {
		string minglingfu,qq,password ;
		cin>>minglingfu>>qq>>password;
		if (minglingfu=="N") {
			if (zhanghao.find(qq)!= zhanghao.end( )) {
				printf("ERROR: Exist\n");
			} else {
				zhanghao[qq]=password;
				printf("New: OK\n");
			}
		} else {
			if (zhanghao.find(qq)!=zhanghao.end()) {
				if (zhanghao.find(qq)->second ==password) {
					printf("Login: OK\n");
				} else {
					printf("ERROR: Wrong PW\n");
				}
			} else {
				printf("ERROR: Not Exist\n");
			}
		}
	}
	return 0;
}


*/