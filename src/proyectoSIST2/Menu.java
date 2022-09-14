package Proyecto1;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Menu {
    
	public static void main(String args[]) throws Exception {

		// Iniciar hilos
		Secuencial s1;
                
                boolean archivo = false;
		int opcion = 0;
		int opcion1 = 0;
		int opcion2 = 0;
                String nombre_archivo="";
		
                Scanner entrada = new Scanner(System.in);
                
                System.out.println("Ingrese el nombre de la imagen a utilizar:");
                System.out.println("Por ejemplo: imgEdit");
                
                
                while(archivo==false){
                
                
                    nombre_archivo=entrada.nextLine();
                
                    FileReader fr;
        
                    try{
                        //Si existe el archivo
                        fr = new FileReader(nombre_archivo+".pgm");
                        //System.out.println("Existe");
                        archivo=true;


                    }catch(Exception e){
                        //System.out.println("No existe\n");
                        //No existe el archivo
                        //System.out.println("No existe");
                        System.out.println("Archivo no se encuentra en el directorio");
                        System.out.println("Ingrese otro archivo: ");

                    }  

                }
                
                

		// Elegir Problema 1 o 2
		while (opcion1 == 0) {

			System.out.println("\n\nMenu");
			System.out.println("1) Problema 1");
			System.out.println("2) Problema 2");

			opcion1 = entrada.nextInt();
                        
                }
		
                // Elegir Hilos o Secuencial
		while (opcion == 0) {

			System.out.println("\nEscoger forma de trabajar");
			System.out.println("1) Hilos");
			System.out.println("2) Secuencial");

			opcion = entrada.nextInt();
		}

		//Cambiar el nombre de la imagen que se va a leer
		
		
		//PGMIO pmgEditor = new PGMIO();
		int[][] matrizLeida = PGMIO.read(new File(nombre_archivo+".pgm"));

		// Problema 1 - HILOS
		if (opcion1 == 1 && opcion == 1) {

			// Medimos el tiempo antes de realizar los filtros
			final long tiempoPartida = System.currentTimeMillis();

			Paralelo p1 = new Paralelo(1, matrizLeida, 1);
			Paralelo p2 = new Paralelo(2, matrizLeida, 1);

			p1.start();
			p2.start();

			try {

				p1.join();
				p2.join();

			} catch (Exception e) {

				// imprimir = new Suma(-1);
				// imprimir.Imprimir();

			}
			// Finalizamos el tiempo luego de realizar los filtros
			final long tiempoLlegada = System.currentTimeMillis();

			System.out.println("Tiempo total de ejecuci�n: " + (tiempoLlegada - tiempoPartida) + " msec");

			if (p1.fin == true && p2.fin == true) {
				PGMIO.write(p1.getImagenResultado(), new File("imgSalidaElem1Dilatacion.pgm"));
				PGMIO.write(p2.getImagenResultado2(), new File("imgSalidaElem1Erosion.pgm"));
			}

			// Problema 1 - SECUENCIAL
		} else if (opcion1 == 1 && opcion == 2) {

			s1 = new Secuencial(1, matrizLeida);

			// Medimos el tiempo antes de realizar los filtros
			final long tiempoPartida = System.currentTimeMillis();

			s1.dilatacionElem1(matrizLeida);
			PGMIO.write(s1.getImagenResultado(), new File("imgSalidaElem1Dilatacion.pgm"));
			s1.erosionElem1(matrizLeida);
			PGMIO.write(s1.getImagenResultado2(), new File("imgSalidaElem1Erosion.pgm"));

			// Finalizamos el tiempo luego de realizar los filtros
			final long tiempoLlegada = System.currentTimeMillis();
			System.out.println("Tiempo total de ejecuci�n: " + (tiempoLlegada - tiempoPartida) + " msec");
		}

		// Problema 2 - HILOS
		else if (opcion1 == 2 && opcion == 1) {

			while (opcion2 == 0) {

				System.out.println("\nEscoger Figura");
				System.out.println("1) Figura 1 (Signo +)");
				System.out.println("2) Figura 2 (Izquierda - Abajo)");
				System.out.println("3) Figura 3 (Izquierda - Arriba)");
				System.out.println("4) Figura 4 (Izquierda - Derecha)");
				System.out.println("5) Figura 5 (Abajo)");
				System.out.println("6) Figura 6 (Signo x)");

				opcion2 = entrada.nextInt();
			}
			// Le entregamos el id dele hilo, la matriz leida y la figura elegida
			Paralelo p1 = new Paralelo(1, matrizLeida, opcion2);
			Paralelo p2 = new Paralelo(2, matrizLeida, opcion2);
			
			// Medimos el tiempo antes de realizar los filtros
			
			final long tiempoPartida = System.currentTimeMillis();
			p1.start();
			p2.start();
			try {

				p1.join();
				p2.join();

			} catch (Exception e) {

			}
			// Finalizamos el tiempo luego de realizar los filtros
			final long tiempoLlegada = System.currentTimeMillis();
			
			if (opcion2 == 1) {
				
				if (p1.fin == true && p2.fin == true) {
					PGMIO.write(p1.getImagenResultado(), new File("imgSalidaElem1Dilatacion.pgm"));
					PGMIO.write(p2.getImagenResultado2(), new File("imgSalidaElem1Erosion.pgm"));
				}
				

			} else if (opcion2 == 2) {
				if (p1.fin == true && p2.fin == true) {
					PGMIO.write(p1.getImagenResultado(), new File("imgSalidaElem2Dilatacion.pgm"));
					PGMIO.write(p2.getImagenResultado2(), new File("imgSalidaElem2Erosion.pgm"));
				}
			} else if (opcion2 == 3) {
				if (p1.fin == true && p2.fin == true) {
					PGMIO.write(p1.getImagenResultado(), new File("imgSalidaElem3Dilatacion.pgm"));
					PGMIO.write(p2.getImagenResultado2(), new File("imgSalidaElem3Erosion.pgm"));
				}
			} else if (opcion2 == 4) {
				if (p1.fin == true && p2.fin == true) {
					PGMIO.write(p1.getImagenResultado(), new File("imgSalidaElem4Dilatacion.pgm"));
					PGMIO.write(p2.getImagenResultado2(), new File("imgSalidaElem4Erosion.pgm"));
				}

			} else if (opcion2 == 5) {
				if (p1.fin == true && p2.fin == true) {
					PGMIO.write(p1.getImagenResultado(), new File("imgSalidaElem5Dilatacion.pgm"));
					PGMIO.write(p2.getImagenResultado2(), new File("imgSalidaElem5Erosion.pgm"));
				}
			} else if (opcion2 == 6) {
				if (p1.fin == true && p2.fin == true) {
					PGMIO.write(p1.getImagenResultado(), new File("imgSalidaElem6Dilatacion.pgm"));
					PGMIO.write(p2.getImagenResultado2(), new File("imgSalidaElem6Erosion.pgm"));
				}
			}

			System.out.println("Tiempo total de ejecuci�n: " + (tiempoLlegada - tiempoPartida) + " msec");
			// Problema 2 - SECUENCIAL
		} else if (opcion1 == 2 && opcion == 2) {

			while (opcion2 == 0) {

				System.out.println("\nEscoger Figura");
				System.out.println("1) Figura 1 (Signo +)");
				System.out.println("2) Figura 2 (Izquierda - Abajo)");
				System.out.println("3) Figura 3 (Izquierda - Arriba)");
				System.out.println("4) Figura 4 (Izquierda - Derecha)");
				System.out.println("5) Figura 5 (Abajo)");
				System.out.println("6) Figura 6 (Signo x)");

				opcion2 = entrada.nextInt();
			}
			
			s1 = new Secuencial(1, matrizLeida);
			
			// Figura 1
			if (opcion2 == 1) {

				
				
				// Medimos el tiempo antes de realizar los filtros
				final long tiempoPartida = System.currentTimeMillis();
				
				s1.dilatacionElem1(matrizLeida);
				PGMIO.write(s1.getImagenResultado(), new File("imgSalidaElem1Dilatacion.pgm"));
				s1.erosionElem1(matrizLeida);
				PGMIO.write(s1.getImagenResultado2(), new File("imgSalidaElem1Erosion.pgm.pgm"));
				// Finalizamos el tiempo luego de realizar los filtros
				final long tiempoLlegada = System.currentTimeMillis();
				System.out.println("Tiempo total de ejecuci�n: " + (tiempoLlegada - tiempoPartida) + " msec");
			// Figura 2
			} else if (opcion2 == 2) {

				
				// Medimos el tiempo antes de realizar los filtros
				final long tiempoPartida = System.currentTimeMillis();
				s1.dilatacionElem2(matrizLeida);
				PGMIO.write(s1.getImagenResultado(), new File("imgSalidaElem2Dilatacion.pgm"));
				s1.erosionElem2(matrizLeida);
				PGMIO.write(s1.getImagenResultado2(), new File("imgSalidaElem2Erosion.pgm"));
				// Finalizamos el tiempo luego de realizar los filtros
				final long tiempoLlegada = System.currentTimeMillis();
				System.out.println("Tiempo total de ejecuci�n: " + (tiempoLlegada - tiempoPartida) + " msec");
			// Figura 3
			} else if (opcion2 == 3) {

				// Medimos el tiempo antes de realizar los filtros
				final long tiempoPartida = System.currentTimeMillis();
				s1.dilatacionElem3(matrizLeida);
				PGMIO.write(s1.getImagenResultado(), new File("imgSalidaElem3Dilatacion.pgm"));
				s1.erosionElem3(matrizLeida);
				PGMIO.write(s1.getImagenResultado2(), new File("imgSalidaElem3Erosion.pgm"));
				// Finalizamos el tiempo luego de realizar los filtros
				final long tiempoLlegada = System.currentTimeMillis();
				System.out.println("Tiempo total de ejecuci�n: " + (tiempoLlegada - tiempoPartida) + " msec");
				
			// Figura 4
				
			} else if (opcion2 == 4) {

				
				// Medimos el tiempo antes de realizar los filtros
				final long tiempoPartida = System.currentTimeMillis();
				s1.dilatacionElem4(matrizLeida);
				PGMIO.write(s1.getImagenResultado(), new File("imgSalidaElem4Dilatacion.pgm"));
				s1.erosionElem4(matrizLeida);
				PGMIO.write(s1.getImagenResultado2(), new File("imgSalidaElem4Erosion.pgm"));
				// Finalizamos el tiempo luego de realizar los filtros
				final long tiempoLlegada = System.currentTimeMillis();
				System.out.println("Tiempo total de ejecuci�n: " + (tiempoLlegada - tiempoPartida) + " msec");
				
			// Figura 5
				
			} else if (opcion2 == 5) {
				// Medimos el tiempo antes de realizar los filtros
				final long tiempoPartida = System.currentTimeMillis();
				s1.dilatacionElem5(matrizLeida);
				PGMIO.write(s1.getImagenResultado(), new File("imgSalidaElem5Dilatacion.pgm"));
				s1.erosionElem5(matrizLeida);
				PGMIO.write(s1.getImagenResultado2(), new File("imgSalidaElem5Erosion.pgm"));
				// Finalizamos el tiempo luego de realizar los filtros
				final long tiempoLlegada = System.currentTimeMillis();
				System.out.println("Tiempo total de ejecuci�n: " + (tiempoLlegada - tiempoPartida) + " msec");
				
			// Figura 6
				
			} else if (opcion2 == 6) {
				// Medimos el tiempo antes de realizar los filtros
				final long tiempoPartida = System.currentTimeMillis();
				s1.dilatacionElem6(matrizLeida);
				PGMIO.write(s1.getImagenResultado(), new File("imgSalidaElem6Dilatacion.pgm"));
				s1.erosionElem6(matrizLeida);
				PGMIO.write(s1.getImagenResultado2(), new File("imgSalidaElem6Erosion.pgm"));
				// Finalizamos el tiempo luego de realizar los filtros
				final long tiempoLlegada = System.currentTimeMillis();
				System.out.println("Tiempo total de ejecuci�n: " + (tiempoLlegada - tiempoPartida) + " msec");
			}

		}
		entrada.close();
	}
}
