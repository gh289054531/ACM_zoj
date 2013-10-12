/*JAVA≥¨ ±£¨”√C

	#include <iostream>
	#include <cstdio>
	#include <cstring>
	using namespace std;
		int min(int a,int b){
			return a>b?b:a;
		}
		
		bool isUpperCase(char c){
			if(c>='A' && c<='Z'){
				return true;
			}
			return false;
		}
		
		bool isDigit(char c){
			int x=c-'0';
			if(x>=0&&x<=9){
				return true;
			}
			return false;
		}
		bool isLetter(char c){
			if((c>='a'&&c<='z')||(c>='A'&&c<='Z')){
				return true;
			}
			return false;
		}
	
		int main(){
			freopen("test.txt","r",stdin);
			string convert[] =  { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };
	
			string s1,s2,s3,s4;
			cin>>s1>>s2>>s3>>s4;
			bool flag1 = false;
			int upper1 = min(s1.length(), s2.length());
			for (int i = 0; i < upper1; i++) {
				char c1 = s1[i];
				char c2 = s2[i];
				if (c1 == c2 && flag1 == false && c1>='A'&&c1<='G') {
					cout<<convert[c1 - 'A'] <<" ";
					flag1 = true;
					continue;
				}
				if (c1 == c2 && flag1 == true && (isDigit(c1) || (c1 >= 'A' && c1 <= 'N'))) {
					if (isDigit(c1)) {
						printf("%02d:",c1-'0');
						break;
					} else {
						printf("%02d:",(c1 - 'A' + 10));
						break;
					}
				}
			}
			int upper2 = min(s3.length(), s4.length());
			for (int i = 0; i < upper2; i++) {
				char c3 = s3[i];
				char c4 = s4[i];
				if (c3 == c4 && isLetter(c3)) {
					printf("%02d",i);
					break;
				}
			}
			return 0;
		}
	
}
*/
