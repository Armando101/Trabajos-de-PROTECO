#include <stdio.h>
#include <string.h>
int main (){
	FILE *file;
	
	/*char *cadena;
	cadena=(char*)malloc(50*sizeof(char))
	file=fopen("Archivo.txt","w");
	*/
	char cadena[50];
	file=fopen("Archivo.txt","r");
	
	while(strcmp(cadena,"salir")){
		fscanf(stdin,"%s",cadena);
		fprintf(file,"- %s\n",cadena);
	}
	fclose(file);
	
	return 0;
}
