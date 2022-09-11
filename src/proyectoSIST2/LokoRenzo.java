package Proyecto1;

import java.io.File;
import java.util.Scanner;

public class LokoRenzo {
	public static void main(String args[]) throws Exception {

		// iniciar hilos
		Suma s1, s2;
                int opcion=0;
                
                Scanner entrada = new Scanner(System.in);
                
                while(opcion==0){
                    
                    System.out.println("Menú");
                    System.out.println("1) Hilos");
                    System.out.println("2) Secuencial");
                    
                    opcion=entrada.nextInt();
                    
                    
                }
                
                if(opcion==1){
                    
                    PGMIO pmgEditor = new PGMIO();
                    int[][] matrizLeida = pmgEditor.read(new File ("imgEdit.pgm"));
                    s1 = new Suma(1, matrizLeida);
		
                    s2 = new Suma(2, matrizLeida);

                    s1.start();

                    s2.start();

                    try {

                            s1.join();
                            s2.join();

                    } catch (Exception e) {

                            // imprimir = new Suma(-1);
                            // imprimir.Imprimir();

                    }
                    //Escribimos el resultado
                    while (s1.fin==false && s2.fin==false) {


                    }
                    pmgEditor.write(s1.getImagenResultado(), new File ("imagenSalidaPruebaErosionar.pgm"));



                    }
                else{
                    
                    
                    
                }

		
	}
}
