package proyectoSIST2;

import java.io.File;

public class LokoRenzo {
	public static void main(String args[]) throws Exception {

		// iniciar hilos
		Suma s1, s2;


		PGMIO pmgEditor = new PGMIO();
		int[][] matrizLeida = pmgEditor.read(new File ("imgEdit2.pgm"));
		s1 = new Suma(1, matrizLeida);
		
		//s2 = new Suma(2);

		s1.start();
		
		//s2.start();

		try {

			s1.join();
			//s2.join();

		} catch (Exception e) {

			// imprimir = new Suma(-1);
			// imprimir.Imprimir();

		}
		//Escribimos el resultado
		while (s1.fin==false) {
			
			
		}
		pmgEditor.write(s1.getImagenResultado(), new File ("imagenSalida2PruebaErosionarElemento3.pgm"));

	}
}
