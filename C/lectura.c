#include <stdio.h>
#include <stdlib.h>

int main(int argc, char const *argv[]){
	int i, *arreglo1;
	arreglo1 = (int *)malloc(1000*sizeof(int));

	FILE *archivo;
	archivo = fopen("numeros.txt", "r");
	for (int i = 0; i < 1000; i++){
		fscanf(archivo, "%d", &arreglo1[i]);
	}

	for (int i = 0; i < 1000; i++){
		fprintf(archivo, "%d", arreglo1[i]);
	}
	
	return 0;
}