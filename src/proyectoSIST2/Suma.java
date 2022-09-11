
package Proyecto1;

public class Suma extends Thread {

	// VariableCompartida general;

	int n1;
	int n2;
	int resultado;
	int cantidad;
	int id;
	int[][] imagenPGM; 
	int[][] imagenResultado;
	boolean fin = false;
	// int general = 0;

	Suma(int id, int[][] matriz) {

		// this.general = general;
		//this.cantidad = cantidad;
		this.id = id;
		this.imagenPGM = matriz;

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
public int[][] getImagenResultado() {
	return imagenResultado;
}
	public void run() {


		
		


		//	Llenando matriz de prueba
		//int[][] hola = new int[5][4];
//		for (int i = 0; i < hola.length; i++) {
//			for (int j = 0; j < hola[i].length; j++) {
//
//				hola[i][j] = j;
//
//			}
//		}
//		

		if (this.id == 1) {
			
			
			//Matriz de prueba
			//int[][] arrayDilatado = dilatacion(hola);
			//int[][] arrayErosionado = erosion(hola);
			//Print Matriz normal
			//System.out.println("Matriz normal:");
			//imprimirMatriz(hola);
			//System.out.println("Matriz dilatada:");
			//Print Matriz Dilatada
			//imprimirMatriz(arrayDilatado);
			//System.out.println("Matriz erosionada:");

			//Print Matriz Erosionada
			//imprimirMatriz(arrayErosionado);

			//Matriz de image PMG
			//int[][] arrayDilatado = dilatacion(imagenPGM);
			//this.imagenResultado = arrayDilatado;
			int[][] arrayErosionado = erosion(imagenPGM);
			this.imagenResultado = arrayErosionado;
			fin=true;
		}
	}



	private int[][] dilatacion(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arrayDilatado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
                            
                                if(this.id==1){
                            
				// Copiamos valores para los casos donde ninguna condicion se cumpla.
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
				} 
                                
                                }
                                else if(this.id==2) {
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

	private int[][] erosion(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arrayErosionado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
                            
                                if(this.id == 1){
                                    
                                
				// Copiamos valores para los casos donde ninguna condicion se cumpla.
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

                                }// Las demas filas
				} else if(this.id==2){
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

	//Metodo para imprimir una matriz
	private void imprimirMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++)
				System.out.print(matriz[i][j]);
			System.out.println("");
		}
	}
	

}
