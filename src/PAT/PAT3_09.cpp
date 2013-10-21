#include <cstdio>  
#include <queue>  
  
using namespace std;  
  
int main()  
{  
    int N;  
    int t;  
    bool flag=false;  
  
    priority_queue<int,vector<int>,greater<int> >  q;    
    scanf("%d",&N);  
    while(N--)  
    {  
		scanf("%d",&t);  
    	q.push(t);  
    }  
    while (!q.empty())  
    {  
        if (flag)  
    		printf(" ");  
        else  
    		flag=true;  
        printf("%d",q.top());  
        q.pop();  
    }  
    printf("\n");  
	return 0;
}
