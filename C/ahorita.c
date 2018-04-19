#include <stdio.h>
#include <string.h>

int main(void){
	  
	  FILE *first,*second;
	  char filename[50],c,fmn[50];
	  printf("Ingresta el nombre del archivo: ");
	  gets(filename);
	  first=fopen(strcat(filename,".txt"),"r");
		if(first==NULL){
		printf("El archivo no existe \n");
	}
	else{
		
		while((c=fgetc(first))!=EOF){
			printf("%c",c);		
	
		}
	}
	puts(filename);
	
	fclose(first);
	
	return 0;
}
