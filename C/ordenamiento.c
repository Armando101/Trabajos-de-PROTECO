#include <stdio.h>
#include <stdlib.h>
#include <time.h>

//Ordenar los nuemros al azar

int main(int argc, char const *argv[])
{

	srand(time(NULL));
	int aleatorio = rand();
	FILE *archivo;
	archivo=fopen("numeros.txt", "w");
	

	for (int i = 0; i < 1000; i++){
		fprintf(archivo, "%d\n", rand()%1000);
	}
	fclose(archivo);
/*
while((c=fgetc(archivo))!=EOF){
			
		printf("%n\n", c);

			}	



void insetrion_sort(int *, int);
*/



	return 0;
}