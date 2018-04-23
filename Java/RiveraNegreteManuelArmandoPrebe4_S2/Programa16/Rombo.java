import java.util.Scanner;
import java.io.IOException;

public class Rombo {
    
    public void asterisco(int numero){
        char caracter='*';
        for(int i=0; i<numero; i++){
            System.out.println();
                    for(int j=0; j <numero-i-1; j++){
                            System.out.print(" ");       
                    }for(int k=0; k<2*i+1;k++){
                            System.out.print(caracter);
                    }           
        }
        for(int j=numero-2; j>=0; j--){
            System.out.println();
                    for(int i=0; i <numero-j-1; i++){
                            System.out.print(" ");       
                    }for(int i=0; i<2*j+1; i++){
                            System.out.print(caracter);
                    }           
        }
        System.out.println();
    }
}