
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
		int[][] hola = new int[5][4];
		for (int i = 0; i < hola.length; i++) {
			for (int j = 0; j < hola[i].length; j++) {

				hola[i][j] = j;

			}
		}
		

		if (this.id == 1) {
			
			
			
			 //Matriz de prueba 
			//int[][] arrayDilatado = dilatacionElem2(hola); 
			//int[][]arrayErosionado = erosionElem3(hola); 
			//Print Matriz normal
			 // System.out.println("Matriz normal:"); imprimirMatriz(hola);
			 // System.out.println("Matriz dilatada:"); 
			  //Print Matriz Dilatada
			 // imprimirMatriz(arrayDilatado); 
			 // System.out.println("Matriz erosionada:");
			 // PrintMatriz Erosionada 
			  //imprimirMatriz(arrayErosionado);
			 
			//Matriz de image PMG
			int[][] arrayDilatado = dilatacionElem1Hilos(imagenPGM);
			this.imagenResultado = arrayDilatado;
			int[][] arrayErosionado = erosionElem1Hilos(imagenPGM);
			this.imagenResultado = arrayErosionado;
			fin=true;
		}
        }
        
       
        
         //Signo +
	public int[][] dilatacionElem1Hilos(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arrayDilatado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
				// Copiamos valores para los casos donde ninguna condicion se cumpla.
				arrayDilatado[i][j] = arrayInicial[i][j];
                                
                                if(this.id==1){
                                    
                                
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
                                if(this.id==2) {
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
        
        
        public int[][] erosionElem1Hilos(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arrayErosionado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
				// Copiamos valores para los casos donde ninguna condicion se cumpla.
				arrayErosionado[i][j] = arrayInicial[i][j];
                                
                                if(this.id==1){
                                    
                                
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
				} 
                                }
                                if(this.id==2) {
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
        
        
        
        
        
        
        
        
        
        //Signo +
	public int[][] dilatacionElem1(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arrayDilatado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
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
        


        
         //Signo +
	public int[][] dilatacionElem6(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arrayDilatado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
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
        
        
        
        
        
	//Signo +
	public int[][] dilatacionElem5(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arrayDilatado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
				// Copiamos valores para los casos donde ninguna condicion se cumpla.
				arrayDilatado[i][j] = arrayInicial[i][j];
				// Primera Fila
				if (i == 0) {
					// Primera Columna
					if (j == 0) {
						
						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j];

					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						
						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j];
					}
					// Otras columnas
					else {
						
						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j];
					}
				}
				// Ultima fila
				else if (i == arrayInicial.length - 1) {
					// Primera Columna
					if (j == 0) {
						
					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {

						
					}
					// Otras columnas
					else {
						
					}

					// Las demas filas
				} else {
					// Primera Columna
					if (j == 0) {
						
						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j];

					} // Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						
						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j];
					} // Otras columnas
					else {
						
						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j];
						
					}
				}

			}
		}
		return arrayDilatado;
	}
        
        
        
        
        
        
        
        
        
        
        
        
        
     
        
        
        public int[][] erosionElem5(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arrayErosionado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
				// Copiamos valores para los casos donde ninguna condicion se cumpla.
				arrayErosionado[i][j] = arrayInicial[i][j];
				// Primera Fila
				if (i == 0) {
					// Primera Columna
					if (j == 0) {
						
						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i + 1][j];

					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						
						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i + 1][j];
					}
					// Otras columnas
					else {
						
						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i + 1][j];
					}

				}
				// Ultima fila
				else if (i == arrayInicial.length - 1) {
					// Primera Columna
					if (j == 0) {
						

					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {

						
					}
					// Otras columnas
					else {
						
					}

					// Las demas filas
				} else {
					// Primera Columna
					if (j == 0) {
						
						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i + 1][j];

					} // Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						
						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i + 1][j];
					} // Otras columnas
					else {
						
						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i + 1][j];
						
					}
				}

			}
		}
		return arrayErosionado;
	}
        
        
        
	public int[][] erosionElem1(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arrayErosionado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
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
	
	//Signo izquierda-abajo
	public int[][] dilatacionElem2(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arrayDilatado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
				// Copiamos valores para los casos donde ninguna condicion se cumpla.
				arrayDilatado[i][j] = arrayInicial[i][j];
				// Primera Fila
				if (i == 0) {
					// Primera Columna
					if (j == 0) {

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
					// Primera Columna, no revisa nada pero hay que dejarlo.
					if (j == 0) {
						
					}
					
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j - 1];
					}
					// Otras columnas
					else {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j - 1];
					}

					// Las demas filas
				} else {
					// Primera Columna
					if (j == 0) {

						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j];

					} // Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j - 1];
						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j];
					} // Otras columnas
					else {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j - 1];
						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j];
					}
				}

			}
		}
		return arrayDilatado;
	}
	public int[][] erosionElem2(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arrayDilatado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
				// Copiamos valores para los casos donde ninguna condicion se cumpla.
				arrayDilatado[i][j] = arrayInicial[i][j];
				// Primera Fila
				if (i == 0) {
					// Primera Columna
					if (j == 0) {

						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j];

					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j - 1];
						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j];
					}
					// Otras columnas
					else {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j - 1];
						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j];
					}
					

				}
				// Ultima fila
				else if (i == arrayInicial.length - 1) {
					// Primera Columna, no revisa nada pero hay que dejarlo.
					if (j == 0) {
						
					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j - 1];
					}
					// Otras columnas
					else {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j - 1];
					}

					// Las demas filas
				} else {
					// Primera Columna
					if (j == 0) {

						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j];

					} // Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j - 1];
						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j];
					} // Otras columnas
					else {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j - 1];
						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j];
					}
				}

			}
		}
		return arrayDilatado;
	}	

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //Elemento izquierda-arriba
        public int[][] erosionElem3(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arrayErosionado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
				// Copiamos valores para los casos donde ninguna condicion se cumpla.
				arrayErosionado[i][j] = arrayInicial[i][j];
				// Primera Fila
				if (i == 0) {
					// Primera Columna
					if (j == 0) {
                                            
                                           
					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j - 1];
						
					}
					// Otras columnas
					else {
						
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j - 1];
                                                
                                                
					}

				}
				// Ultima fila
				else if (i == arrayInicial.length - 1) {
					// Primera Columna
					if (j == 0) {
						
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
						
						// Arriba
						if (arrayInicial[i - 1][j] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i - 1][j];
						

					} // Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j - 1];
						// Arriba
						if (arrayInicial[i - 1][j] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i - 1][j];
						
					} // Otras columnas
					else {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j - 1];
						// Arriba
						if (arrayInicial[i - 1][j] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i - 1][j];
						
					}
				}

			}
		}
		return arrayErosionado;
	}
	
	//Signo izquierda-arriba
	public int[][] dilatacionElem3(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arrayDilatado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
				// Copiamos valores para los casos donde ninguna condicion se cumpla.
				arrayDilatado[i][j] = arrayInicial[i][j];
				// Primera Fila
				if (i == 0) {
					// Primera Columna
					if (j == 0) {

						

					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j - 1];
						
					}
					// Otras columnas
					else {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j - 1];
						
					}
					

				}
				// Ultima fila
				else if (i == arrayInicial.length - 1) {
					// Primera Columna
					if (j == 0) {
                                            
                                                //Arriba
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
						// Arriba
						if (arrayInicial[i - 1][j] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i - 1][j];
						

					} // Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j - 1];
						// Arriba
						if (arrayInicial[i - 1][j] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i - 1][j];
					} // Otras columnas
					else {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j - 1];
						// Arriba
						if (arrayInicial[i - 1][j] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i - 1][j];
					}
				}

			}
		}
		return arrayDilatado;
	}

        //Elemento izquierda-derecha
        public int[][] erosionElem4(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arrayErosionado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
				// Copiamos valores para los casos donde ninguna condicion se cumpla.
				arrayErosionado[i][j] = arrayInicial[i][j];
                                
				// Primera Fila
				if (i == 0) {
					// Primera Columna
					if (j == 0) {
                                                //Derecha
                                                if (arrayInicial[i][j + 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j + 1];
					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j - 1];
						
					}
					// Otras columnas
					else {
						// Derecha
						if (arrayInicial[i][j + 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j + 1];
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j - 1];						
					}

				}
				// Ultima fila
				else if (i == arrayInicial.length - 1) {
					// Primera Columna
					if (j == 0) {
						
						// Derecha
						if (arrayInicial[i][j + 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j + 1];

					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
                                            
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j - 1];
						
					}
					// Otras columnas
					else {
						
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j - 1];
                                                
                                                // Derecha
						if (arrayInicial[i][j + 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j + 1];
					}

					// Las demas filas
				} else {
					// Primera Columna
					if (j == 0) {
						
						// Derecha
						if (arrayInicial[i][j + 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j + 1];
						

					} // Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
                                            
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j - 1];
						
					} // Otras columnas
					else {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j - 1];
                                                
						// Derecha
						if (arrayInicial[i][j + 1] < arrayInicial[i][j])
							arrayErosionado[i][j] = arrayInicial[i][j + 1];
						
					}
				}

			}
		}
		return arrayErosionado;
	}
	
	//Signo izquierda-arriba
	public int[][] dilatacionElem4(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arrayDilatado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
				// Copiamos valores para los casos donde ninguna condicion se cumpla.
				arrayDilatado[i][j] = arrayInicial[i][j];
				// Primera Fila
				if (i == 0) {
					// Primera Columna
					if (j == 0) {
                                           
                                                //Derecha
                                                if (arrayInicial[i][j + 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j + 1];	

					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
                                            
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j - 1];
						
					}
					// Otras columnas
					else {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j - 1];
                                                
                                                // Derecha
						if (arrayInicial[i][j + 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j + 1];
						
					}
					

				}
				// Ultima fila
				else if (i == arrayInicial.length - 1) {
                                    
					// Primera Columna
					if (j == 0) {
                                            
                                                //Derecha
                                                if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j];
					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {

                                                // Izquierda
                                                if (arrayInicial[i][j - 1] > arrayInicial[i][j])
                                                        arrayDilatado[i][j] = arrayInicial[i][j - 1];
                                                
					}
                                        
					// Otras columnas
					else {		
                                            
                                                // Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j - 1];
                                                
						// Derecha
						if (arrayInicial[i][j + 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j + 1];

						
					}

					// Las demas filas
				} else {
					// Primera Columna
					if (j == 0) {		
                                            
						// Derecha
						if (arrayInicial[i][j + 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j + 1];

					} // Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
                                            
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j - 1];
						
					} // Otras columnas
					else {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j - 1];
                                                
						// Derecha
						if (arrayInicial[i][j + 1] > arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i][j + 1];
					}
				}

			}
		}
		return arrayDilatado;
	}
        
        
        
        
        public int[][] erosionElem6(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arrayDilatado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
				// Copiamos valores para los casos donde ninguna condicion se cumpla.
				arrayDilatado[i][j] = arrayInicial[i][j];
				// Primera Fila
				if (i == 0) {
					// Primera Columna
					if (j == 0) {
						// Derecha y Abajo
						if (arrayInicial[i + 1][j + 1] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j + 1];


					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda y Abajo
						if (arrayInicial[i + 1][j - 1] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j - 1];

					}
					// Otras columnas
					else {
						// Derecha y Abajo
						if (arrayInicial[i + 1][j + 1] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j + 1];
						// Izquierda y Abajo
						if (arrayInicial[i + 1][j - 1] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j - 1];
						
					}
					

				}
				// Ultima fila
				else if (i == arrayInicial.length - 1) {
					// Primera Columna
					if (j == 0) {
						// Derecha y Arriba
						if (arrayInicial[i - 1][j + 1] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i - 1][j + 1];


					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {

						// Izquierda y Arriba
						if (arrayInicial[i - 1][j - 1] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i - 1][j - 1];
					
					}
					// Otras columnas
					else {
						// Derecha y Arriba
						if (arrayInicial[i - 1][j + 1] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i - 1][j + 1];
						// Izquierda y Arriba
						if (arrayInicial[i - 1][j - 1] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i - 1][j - 1];
					}

					// Las demas filas
				} else {
					// Primera Columna
					if (j == 0) {
						// Derecha y Arriba
						if (arrayInicial[i - 1][j + 1] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i - 1][j + 1];
						// Derecha y Abajo
						if (arrayInicial[i + 1][j + 1] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j + 1];

					} // Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda y Arriba
						if (arrayInicial[i - 1][j - 1] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i - 1][j - 1];
						// Izquierda y Abajo
						if (arrayInicial[i + 1][j - 1] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j - 1];
						
					} // Otras columnas
					else {
						// Izquierda y Arriba
						if (arrayInicial[i - 1][j - 1] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i - 1][j - 1];
						// Izquierda y Abajo
						if (arrayInicial[i + 1][j - 1] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j - 1];
						// Derecha y Arriba
						if (arrayInicial[i - 1][j + 1] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i - 1][j + 1];
						// Derecha y Abajo
						if (arrayInicial[i + 1][j + 1] < arrayInicial[i][j])
							arrayDilatado[i][j] = arrayInicial[i + 1][j + 1];
					}
				}

			}
		}
		return arrayDilatado;
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
