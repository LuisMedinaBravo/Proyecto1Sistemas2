package Proyecto1;

import java.io.File;
import java.util.Scanner;

public class LokoRenzo {
	public static void main(String args[]) throws Exception {

		// iniciar hilos
		Suma s1, s2,s3,s4;
                int opcion=0;
                int opcion1=0;
                int opcion2=0;
                
                Scanner entrada = new Scanner(System.in);
                
                
                while(opcion1==0){
                    
                    System.out.println("Menú");
                    System.out.println("1) Problema 1");
                    System.out.println("2) Problema 2");
                    
                    opcion1=entrada.nextInt();
                }
                
                while(opcion==0){
                    
                    System.out.println("Escoger forma de trabajar");
                    System.out.println("1) Hilos");
                    System.out.println("2) Secuencial");
                    
                    opcion=entrada.nextInt();
                }
                
                //HILOS
                if(opcion1==1 && opcion==1){
                    
                    
                    PGMIO pmgEditor = new PGMIO();
                    
                    int[][] matrizLeida = pmgEditor.read(new File ("imgEdit2.pgm"));
                    
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
                    if(s1.fin==true && s2.fin==true){
                        pmgEditor.write(s1.getImagenResultado(), new File ("imagenSalidaDilatacion.pgm"));
                        pmgEditor.write(s2.getImagenResultado2(), new File ("imagenSalidaErosion.pgm"));
                    }
                    
                  
                    
                    
                    
                    //SECUENCIAL
                }else if (opcion1==1 && opcion==2){
                 
                    PGMIO pmgEditor = new PGMIO();
                    int[][] matrizLeida = pmgEditor.read(new File ("imgEdit.pgm"));
                    
                    s1 = new Suma(1, matrizLeida);
                    s1.dilatacionElem1Normal(matrizLeida);
                    pmgEditor.write(s1.getImagenResultado(), new File ("imagenSalidaDila.pgm"));
                    s1.erosionElem1Normal(matrizLeida);
                    pmgEditor.write(s1.getImagenResultado2(), new File ("imagenSalidaEro.pgm"));
                }
                
                
                //HILOS
                else if(opcion1== 2 && opcion== 1){
                    
                    
                    while(opcion2==0){

                        System.out.println("Escoger Figura");
                        System.out.println("1) Figura 1");
                        System.out.println("2) Figura 2");
                        System.out.println("3) Figura 3");
                        System.out.println("4) Figura 4");
                        System.out.println("5) Figura 5");
                        System.out.println("6) Figura 6");

                        opcion2=entrada.nextInt();
                    }
                    
                    if(opcion2==1){
                        
                    
                    
                    }else if(opcion2==2){
                        
                        
                    
                    }else if(opcion2==3){
                        
                        
                    
                    }else if(opcion2==4){
                        
                        
                    
                    }else if(opcion2==5){
                        
                        
                    
                    }else if(opcion2==6){
                        
                        
                    }
                    
                    
                    
                    
                    //SECUENCIAL    
                }
                else if(opcion1== 2 && opcion== 2){
                    
                    
                    
                    while(opcion2==0){

                        System.out.println("Menú");
                        System.out.println("1) Figura 1");
                        System.out.println("2) Figura 2");
                        System.out.println("3) Figura 3");
                        System.out.println("4) Figura 4");
                        System.out.println("5) Figura 5");
                        System.out.println("6) Figura 6");

                        opcion2=entrada.nextInt();
                    }
                    
                    if(opcion2==1){
                        
                        PGMIO pmgEditor = new PGMIO();
                        int[][] matrizLeida = pmgEditor.read(new File ("imgEdit2.pgm"));


                        s1 = new Suma(1, matrizLeida);
                        s1.dilatacionElem1Normal(matrizLeida);
                        pmgEditor.write(s1.getImagenResultado(), new File ("imagenSalidaDilata.pgm"));
                        s1.erosionElem1Normal(matrizLeida);
                        pmgEditor.write(s1.getImagenResultado2(), new File ("imagenSalidaErosiona.pgm"));
                        
                    }
                    else if(opcion2==2){
                        
                        PGMIO pmgEditor = new PGMIO();
                        int[][] matrizLeida = pmgEditor.read(new File ("imgEdit2.pgm"));

                        s1 = new Suma(1, matrizLeida);
                        s1.dilatacionElem2Normal(matrizLeida);
                        pmgEditor.write(s1.getImagenResultado(), new File ("imagenSalidaDilata.pgm"));
                        s1.erosionElem2Normal(matrizLeida);
                        pmgEditor.write(s1.getImagenResultado2(), new File ("imagenSalidaErosiona.pgm"));
                        
                        
                    }
                    else if(opcion2==3){
                        
                        
                        PGMIO pmgEditor = new PGMIO();
                        int[][] matrizLeida = pmgEditor.read(new File ("imgEdit2.pgm"));

                        s1 = new Suma(1, matrizLeida);
                        s1.dilatacionElem3Normal(matrizLeida);
                        pmgEditor.write(s1.getImagenResultado(), new File ("imagenSalidaDilata.pgm"));
                        s1.erosionElem3Normal(matrizLeida);
                        pmgEditor.write(s1.getImagenResultado2(), new File ("imagenSalidaErosiona.pgm"));
                    }
                    else if(opcion2==4){
                        
                        PGMIO pmgEditor = new PGMIO();
                        int[][] matrizLeida = pmgEditor.read(new File ("imgEdit2.pgm"));

                        s1 = new Suma(1, matrizLeida);
                        s1.dilatacionElem4Normal(matrizLeida);
                        pmgEditor.write(s1.getImagenResultado(), new File ("imagenSalidaDilata.pgm"));
                        s1.erosionElem4Normal(matrizLeida);
                        pmgEditor.write(s1.getImagenResultado2(), new File ("imagenSalidaErosiona.pgm"));
                    }
                    else if(opcion2==5){
                        
                        PGMIO pmgEditor = new PGMIO();
                        
                        int[][] matrizLeida = pmgEditor.read(new File ("imgEdit2.pgm"));
                        
                        
                        s1 = new Suma(1, matrizLeida);
                        s1.dilatacionElem5Normal(matrizLeida);
                        pmgEditor.write(s1.getImagenResultado(), new File ("imagenSalidaDilata.pgm"));
                        s1.erosionElem5Normal(matrizLeida);
                        pmgEditor.write(s1.getImagenResultado2(), new File ("imagenSalidaErosiona.pgm"));
                    
                    
                    }
                    else if(opcion2==6){
                        
                        PGMIO pmgEditor = new PGMIO();
                        int[][] matrizLeida = pmgEditor.read(new File ("imgEdit2.pgm"));

                        s1 = new Suma(1, matrizLeida);
                        s1.dilatacionElem6Normal(matrizLeida);
                        pmgEditor.write(s1.getImagenResultado(), new File ("imagenSalidaDilata.pgm"));
                        s1.erosionElem6Normal(matrizLeida);
                        pmgEditor.write(s1.getImagenResultado2(), new File ("imagenSalidaErosiona.pgm"));
                    }
                    
                }
        }
}
