/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escrituralecturabytes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;
/**
 *
 * @author armando
 */
public class EscrituraLecturaBytes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int contador = 0;
        int[] datos = new int [16936];
        
        try {
            FileInputStream archivo_lectura = new FileInputStream("/home/armando/Descargas/RdM.jpeg");
            boolean final_archivo = false;
            while(!final_archivo){
                int byte_entrada = archivo_lectura.read();
                
                if (byte_entrada != -1) {
                    datos[contador] = byte_entrada;
                }
                
                if (byte_entrada == -1) {
                    final_archivo = true;
                }
                contador++;
                //System.out.println(datos[contador]);
            }
            System.out.println(contador-1);
            archivo_lectura.close();
        }catch(IOException e){}
        crea_imagen(datos);
    
    }
    
    public static void crea_imagen(int[] datos) {
        try {
            FileOutputStream nuevaimagen = new FileOutputStream("/home/armando/Descargas/CopiaRM.jpeg");
            for (int i = 0; i < datos.length; i++) {
                nuevaimagen.write(datos[i]);
            }
        }catch (IOException e) {}
        
        
    }
    
    
}    
