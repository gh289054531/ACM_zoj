/*JAVA³¬Ê±

#include <cstdio>
#include <string>
#include <stdlib.h>
using namespace std;

int main(){
	int a,n;
	scanf("%d %d",&a,&n);
	if (n == 0) {
		printf("%d\n",0);
	} else {
		int* cs=(int*)malloc(n*sizeof(int));
		int jinwei = 0;
		for (int i = 0; i < n; i++) {
			int temp = (n - i) * a + jinwei;
			int valueOfThisPos = temp % 10;
			jinwei = temp / 10;
			cs[n-i-1]=valueOfThisPos;
		}
		if(jinwei!=0){
			printf("%d",jinwei);
		}
		for(int i=0;i<n;i++){
			printf("%d",cs[i]);
		}
	}
	return 0;
}


*/