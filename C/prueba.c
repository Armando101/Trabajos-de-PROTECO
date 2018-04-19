#include <stdio.h>
#include <string.h>
int main (void){
	
	int a,b;
	a=sizeof(int);
	b=sizeof(int*);
	
	printf("%d",a);
	printf("\n%d",b);
	//puts(b);
}
