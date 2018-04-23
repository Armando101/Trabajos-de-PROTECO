import java.util.Scanner;
class Matriz{

    Scanner sc = new Scanner(System.in);
    double matriz [][];
    int orden;

    public Matriz(int orden){
        this.orden= orden;
        this.matriz = new double[orden][orden];
    }

    public void setElemento(int a, int b, double x){
        this.matriz[a][b] = x;
    }

    public double getElemento(int a, int b){
        return matriz[a][b];
    }
    public int getOrden(){
        return this.orden;
    }

    public double[] getFila(int m){
        return this.matriz[m];
    }

    public void llenar(){
        double k =0;
        System.out.println("Ingresa los elementos de la matriz");
        for (int i=0; i< this.getOrden(); i++){
            for(int j= 0; j<this.getOrden(); j++){
                System.out.println("elemento "+(i+1)+" "+(j+1));
                k = sc.nextInt();
                this.setElemento(i,j, k);
            }
        }
    }

    Matriz obtenermenores(int i, int j){
        int ordenmenor= (this.getOrden()-1); 
        Matriz submatriz = new    Matriz(ordenmenor);
        
        int r=0, s = 0;

        for (int k=0; k<this.getOrden(); k++){
            double[] fila = this.getFila(k);

            if(k != i){
                for(int l=0; l<fila.length; l++){
                    if (l != j){
                        submatriz.setElemento(r,s++, fila[l]);
                    }
                }
                r++;
                s=0;
            }
        }
        return submatriz;
    }

    double getDeterminante(Matriz mat, double determinante){
        
        if(mat.getOrden()==1){
            return mat.getElemento(0,0);
        }else{
            determinante=0;
            for(int j = 0; j<mat.getOrden();j++){
                Matriz submatriz = mat.obtenermenores(0,j);
                determinante += (Math.pow(-1,j))*mat.getElemento(0,j)*(getDeterminante(submatriz, determinante));
    
            }
        }
        return determinante;
    }
}