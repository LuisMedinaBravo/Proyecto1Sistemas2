
package proyectoSIST2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Suma extends Thread {

	// VariableCompartida general;

	int n1;
	int n2;
	int resultado;
	int cantidad;
	int id;
	// int general = 0;

	Suma(int id) {

		// this.general = general;
		this.cantidad = cantidad;
		this.id = id;

	}

	public void setN1(int n1) {
		this.n1 = n1;
	}

	public void setN2(int n2) {
		this.n2 = n2;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

	public void run() {

		// this.resultado=n1+n2;

		int[][] caca = null;
		int[][] hola = new int[5][4];

		final int largoFila = hola.length - 1;
		int largoColumna = hola[0].length;

		for (int i = 0; i < hola.length; i++) {
			for (int j = 0; j < hola[i].length; j++) {

				hola[i][j] = j;

			}
		}
		/*
		 * 0123 0123 0123 0123 0123
		 */

//		if (this.id == 1) {
		// PrimeraFila
//			for (int i = 0; i < hola.length - largoFila; i++) {
//
//				for (int j = 0; j < hola[i].length - 1; j++) {
//					// Derecha
//					if (hola[i][j + 1] > hola[i][j]) {
//
//						hola[i][j] = hola[i][j + 1];
//					}
//					// Abajo
//					if (hola[i + 1][j] > hola[i][j]) {
//						hola[i][j] = hola[i + 1][j];
//					}
//
//				}
//
//			}

//			Ultima Fila
//			System.out.println("largo fila +1 =" + (largoFila + 1));
//			System.out.println(hola.length + " hola lenght");
//
//			for (int i = largoFila; i < hola.length; i++) {
//				System.out.println("cacca");
//				for (int j = 0; j < hola[i].length - 1; j++) {
//					// Derecha
//					if (hola[i][j + 1] > hola[i][j]) {
//						hola[i][j] = hola[i][j + 1];
//					}
//					// Abajo
//					if (hola[i - 1][j] > hola[i][j]) {
//						hola[i][j] = hola[i - 1][j];
//					}
//				}
//			}
//
//		}

		if (this.id == 1) {
			int[][] arrayDilatado = dilatacion(hola);
			int[][] arrayErosionado = erosion(hola);

		
			//Print Matriz normal
			System.out.println("Matriz normal:");
			for (int i = 0; i < hola.length; i++) {
				for (int j = 0; j < hola[i].length; j++)
					System.out.print(hola[i][j]);
				System.out.println("");
			}
			System.out.println("Matriz dilatada:");
			//Print Matriz Dilatada
			for (int i = 0; i < arrayDilatado.length; i++) {
				for (int j = 0; j < arrayDilatado[i].length; j++)
					System.out.print(arrayDilatado[i][j]);
				System.out.println("");
			}
			System.out.println("Matriz erosionada:");

			//Print Matriz Erosionada
			for (int i = 0; i < arrayErosionado.length; i++) {
				for (int j = 0; j < arrayErosionado[i].length; j++)
					System.out.print(arrayErosionado[i][j]);
				System.out.println("");
			}
			/*
			 * 
			 * try { caca = read(new File ("imgEdit2.pgm")); } catch (IOException ex) {
			 * Logger.getLogger(Suma.class.getName()).log(Level.SEVERE, null, ex); } //346 x
			 * 839 System.out.println("uno "+caca[0][1] + " lenght "+caca.length
			 * +" lenght 2 "+caca[0].length);
			 * 
			 * 
			 * try { BufferedWriter bw = new BufferedWriter(new FileWriter("caca.txt"));
			 * 
			 * for (int i = 0; i < caca.length; i++) { for (int j = 0; j < caca[i].length;
			 * j++) { bw.write(caca[i][j] + ","); } bw.newLine(); } bw.flush(); } catch
			 * (IOException e) {}
			 * 
			 * // 6x6 // 6 6 6 6 6 6 // 6 4 4 4 4 6 // 6 4 4 4 4 6 // 6 4 4 4 4 6 // 6 4 4 4
			 * 4 6 // 6 6 6 6 6 6
			 * 
			 * // 0x5 // 0 0 0 0 0
			 * 
			 * int largoFila=caca.length; int largoColumna=caca[0].length;
			 * 
			 * largoFila=largoFila-1;
			 * 
			 * if(this.id==1){ //PrimeraFila for(int i = 0; i<caca.length-largoFila; i++){
			 * 
			 * for(int j = 0; j < caca[i].length-1; j++){ //derecha
			 * if(caca[i][j+1]>caca[i][j]){ caca[i][j]=caca[i][j+1]; } //abajo
			 * if(caca[i+1][j]>caca[i][j]){ caca[i][j]=caca[i+1][j]; } } }
			 * 
			 * 
			 * 
			 * //Ultima Fila for(int i = largoFila+1; i<caca.length; i++){
			 * 
			 * for(int j = 0; j < caca[i].length-1; j++){ //derecha
			 * if(caca[i][j+1]>caca[i][j]){ caca[i][j]=caca[i][j+1]; } //abajo
			 * if(caca[i-1][j]>caca[i][j]){ caca[i][j]=caca[i-1][j]; } } }
			 * 
			 * 
			 * 
			 * }
			 * 
			 * if(this.id==2){
			 * 
			 * 
			 * //sin bordes for (int i = 1; i < caca.length-1; i++) { for (int j = 1; j <
			 * caca[i].length-1; j++) {
			 * 
			 * 
			 * //arriba if(caca[i-1][j] > caca[i][j]){ caca[i][j]=caca[i-1][j]; }
			 * //izquierda if(caca[i][j-1] > caca[i][j]){ caca[i][j]=caca[i][j-1]; }
			 * //derecha if(caca[i][j+1]> caca[i][j]){ caca[i][j]=caca[i][j+1]; } //abajo
			 * if(caca[i+1][j] > caca[i][j]){ caca[i][j]=caca[i+1][j];
			 * 
			 * } } }
			 * 
			 * 
			 * 
			 * for (int i = 0; i < caca.length; i++) {
			 * 
			 * for (int j = 0; j < caca[i].length; j++) {
			 * 
			 * System.out.println(caca[i][j] + ", nuevo "); }
			 * 
			 * }
			 * 
			 * 
			 * 
			 * 
			 * }
			 * 
			 * //imprimia
			 * 
			 * 
			 */

			/*
			 * int[][] caca2 = new int[caca.length+2][caca[0].length+2];
			 * 
			 * //Linea primera fila //Rellenamos las lineas nuevas // Linea de arriba
			 * 
			 * caca2[0][0]=0; caca2[0][caca2[0].length-1]=0;
			 * 
			 * for (int j = 1; j < caca2[0].length-1; j++) { caca2[0][j] = 255;
			 * 
			 * }
			 * 
			 * System.out.println("matri2");
			 * 
			 * for (int i = 0; i < caca2.length; i++) { for (int j = 0; j < caca2[0].length;
			 * j++) {
			 * 
			 * System.out.print(caca2[i][j]);
			 * 
			 * } break; }
			 * 
			 * for (int i = 0; i < caca.length; i++) { for (int j = 0; j < caca[0].length;
			 * j++) {
			 * 
			 * //System.out.print(caca[i][j]);
			 * 
			 * } }
			 */
//		 for (int i = 0; i < caca.length; i++) {
//			for (int j = 0; j < caca[0].length; j++) {
//				System.out.print(""+caca[i][j]+" ");
//				if (j%16==0) {
//					System.out.println();
//				}
//			}
//		}

			// System.out.println("Suma hilo: "+this.resultado);
			/// general.SumaGlobal (this.resultado);
		}
	}

	public int[][] dilatacion(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arrayDilatado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
				//Copiamos valores para los casos donde ninguna condicion se cumpla.
				arrayDilatado[i][j] = arrayInicial[i][j];
				// Primera Fila
				if (i == 0) {
					// Primera Columna
					if (j == 0) {
						// Derecha
						if (arrayInicial[i][j + 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j + 1];
						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j];

					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j - 1];
						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j];
					}
					// Otras columnas
					else {
						// Derecha
						if (arrayInicial[i][j + 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j + 1];
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j - 1];
						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j];
					}

				}
				// Ultima fila
				else if (i == arrayInicial.length - 1) {
					// Primera Columna
					if (j == 0) {
						// Derecha
						if (arrayInicial[i][j + 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j + 1];
						// Arriba
						if (arrayInicial[i - 1][j] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i - 1][j];

					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						

						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j - 1];
						// Arriba
						if (arrayInicial[i - 1][j] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i - 1][j];
					}
					// Otras columnas
					else {
						// Derecha
						if (arrayInicial[i][j + 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j + 1];

						// Arriba
						if (arrayInicial[i - 1][j] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i - 1][j];

						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j - 1];
					}

					// Las demas filas
				} else {
					// Primera Columna
					if (j == 0) {
						// Derecha
						if (arrayInicial[i][j + 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j + 1];
						// Arriba
						if (arrayInicial[i - 1][j] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i - 1][j];
						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j];

					} // Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j - 1];
						// Arriba
						if (arrayInicial[i - 1][j] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i - 1][j];
						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j];
					} // Otras columnas
					else {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j - 1];
						// Arriba
						if (arrayInicial[i - 1][j] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i - 1][j];
						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j];
						// Derecha
						if (arrayInicial[i][j + 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j + 1];
					}
				}

			}
		}
		return arrayDilatado;
	}
	public int[][] erosion(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arrayErosionado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
				//Copiamos valores para los casos donde ninguna condicion se cumpla.
				arrayErosionado[i][j] = arrayInicial[i][j];
				// Primera Fila
				if (i == 0) {
					// Primera Columna
					if (j == 0) {
						// Derecha
						if (arrayInicial[i][j + 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j + 1];
						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i + 1][j];

					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j - 1];
						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i + 1][j];
					}
					// Otras columnas
					else {
						// Derecha
						if (arrayInicial[i][j + 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j + 1];
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j - 1];
						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i + 1][j];
					}

				}
				// Ultima fila
				else if (i == arrayInicial.length - 1) {
					// Primera Columna
					if (j == 0) {
						// Derecha
						if (arrayInicial[i][j + 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j + 1];
						// Arriba
						if (arrayInicial[i - 1][j] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i - 1][j];

					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						

						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j - 1];
						// Arriba
						if (arrayInicial[i - 1][j] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i - 1][j];
					}
					// Otras columnas
					else {
						// Derecha
						if (arrayInicial[i][j + 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j + 1];

						// Arriba
						if (arrayInicial[i - 1][j] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i - 1][j];

						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j - 1];
					}

					// Las demas filas
				} else {
					// Primera Columna
					if (j == 0) {
						// Derecha
						if (arrayInicial[i][j + 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j + 1];
						// Arriba
						if (arrayInicial[i - 1][j] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i - 1][j];
						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i + 1][j];

					} // Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j - 1];
						// Arriba
						if (arrayInicial[i - 1][j] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i - 1][j];
						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i + 1][j];
					} // Otras columnas
					else {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j - 1];
						// Arriba
						if (arrayInicial[i - 1][j] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i - 1][j];
						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i + 1][j];
						// Derecha
						if (arrayInicial[i][j + 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j + 1];
					}
				}

			}
		}
		return arrayErosionado;
	}
	/**
	 * Magic number representing the binary PGM file type.
	 */
	private static final String MAGIC = "P5";
	/**
	 * Character indicating a comment.
	 */
	private static final char COMMENT = '#';
	/**
	 * The maximum gray value.
	 */
	private static final int MAXVAL = 255;

	public static int[][] read(final File file) throws IOException {
		final BufferedInputStream stream = new BufferedInputStream(new FileInputStream(file));
		try {
			if (!next(stream).equals(MAGIC))
				throw new IOException("File " + file + " is not a binary PGM image.");
			final int col = Integer.parseInt(next(stream));
			final int row = Integer.parseInt(next(stream));
			final int max = Integer.parseInt(next(stream));
			if (max < 0 || max > MAXVAL)
				throw new IOException("The image's maximum gray value must be in range [0, " + MAXVAL + "].");
			final int[][] image = new int[row][col];
			for (int i = 0; i < row; ++i) {
				for (int j = 0; j < col; ++j) {
					final int p = stream.read();
					if (p == -1)
						throw new IOException("Reached end-of-file prematurely.");
					else if (p < 0 || p > max)
						throw new IOException("Pixel value " + p + " outside of range [0, " + max + "].");
					image[i][j] = p;
				}
			}
			return image;
		} finally {
			stream.close();
		}
	}

	private static String next(final InputStream stream) throws IOException {
		final List<Byte> bytes = new ArrayList<Byte>();
		while (true) {
			final int b = stream.read();

			if (b != -1) {

				final char c = (char) b;
				if (c == COMMENT) {
					int d;
					do {
						d = stream.read();
					} while (d != -1 && d != '\n' && d != '\r');
				} else if (!Character.isWhitespace(c)) {
					bytes.add((byte) b);
				} else if (bytes.size() > 0) {
					break;
				}

			} else {
				break;
			}

		}
		final byte[] bytesArray = new byte[bytes.size()];
		for (int i = 0; i < bytesArray.length; ++i)
			bytesArray[i] = bytes.get(i);
		return new String(bytesArray);
	}

	public void Imprimir() {

	}

}
