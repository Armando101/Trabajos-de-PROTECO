import java.util.Scanner;

public class Simplificar {
	int num1,num2;
	

	public Simplificar(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
		Sim();
	}   
	public void Sim() {
		int compara = Math.max(num1, num2);
	    while(compara!=0) {
    	if(compara==1 && ((num1*num1)==num2)) {     
        	num2=num2/num1; 
        	num1=num1/num1;
	        System.out.println("\n "+num1+"/"+num2);
    	    compara=0;
	    }else if(((num1%compara)==0) && ((num2%compara)==0)) 
    	{
        	num1=num1/compara; num2=num2/compara;
	        System.out.println("\n "+num1+"/"+num2);
    	    compara=0;
   		}
    	else 
     		compara--;
    	}
	}
}