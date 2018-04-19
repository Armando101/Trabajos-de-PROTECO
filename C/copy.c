#include <stdio.h>
#include <string.h>
int main (void){
	
	FILE *f,*f2;
	char c;
	char nombre[50],nombreE[50];
	printf("Dame el nombre");
	dscanf(stdin,"%s",nombre);
	
	strcpy(nombre,nombreE);
	strcat(nombreE,".txt")
	
	f=fopen(nombreE,"r");
	strcat(nombre,"copia.txt");
	f2=fopen("Copia.txt","w");
	
	if(f==NULL){
		printf("El archivo no existe \n");
	}
	else{
		while((c=fgetc(f))!=EOF){
			printf("%c",c);	
			fputc(c,f2);	
	
		}
	}
	
	fclose(f);
	fclose(f2);
	
	return 0;
	
}
