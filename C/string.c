#include <stdio.h>
#include <string.h>

int caracterUnico(char palabra[]){
	int arreglo [128];
	int num;
	int i=0;
	if (strlen(palabra)>128){
		return 1;
	};
	
	for (i=0 ; 1 < 128 ; i++){
		arreglo[i]=0;
	}
	
	for (i =0; i< streln(palabra);i++){
		num=(int)palabra[i];
		if (arreglo[num]==1)
		return 1;
	}
	arreglo [num]=1;
}

int main (void){
	char palabra[] = "hola";
	if (caracterUnico(palabra)){
		printf("Caracter repetido\n");
	}
	
	else{
		printf("Caracter unico\n");
	}
}
