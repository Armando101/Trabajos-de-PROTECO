#include <stdio.h>
#include <string.h>
int main (void){
	
	FILE *f;
	char c;
	
	f=fopen("Archivo.txt","r");

	
	if(f==NULL){
		printf("El archivo no existe \n");
	}
	else{
		while((c=fgetc(f))!=EOF){
			printf("%c",c);	
				
	
		}
	}
	
	fclose(f);
	
	
	return 0;
	
}
