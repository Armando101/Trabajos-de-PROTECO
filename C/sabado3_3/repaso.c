#include <stdlib.h>
#include <stdio.h>


int main(){
	int a=1;
	int b=2;
	int c=3;
	int num[3] = {a,b,c};
	
	int* _ptr_a=&a;
	int* _ptr_b=&b;
	int* _ptr_c=&c;
	
	int _ptr_num = num;

	return 0;
}
