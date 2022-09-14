package proyectoSIST2;

public class Paralelo extends Thread{
	// VariableCompartida general;

	int id;
	int[][] imagenPGM;
	int[][] imagenResultado;
	int[][] imagenResultado2;
	int estructura;
	boolean fin = false;
	boolean fin2 = false;

	Paralelo(int id, int[][] matriz, int estruc) {
		this.id = id;
		this.imagenPGM = matriz;
		this.estructura = estruc;

	}


	public int[][] getImagenResultado() {
		return imagenResultado;
	}

	public int[][] getImagenResultado2() {
		return imagenResultado2;
	}

	public void run() {

		// Matriz de imagen PGM
		//Switch para ver que estructura eligio el usuario.
		//Ambas hacen lo mismo que hacia los hilos del problema 1, cambiando el nombre del metodo.
		switch (this.estructura) {
		case 1: {
			if (this.id == 1) {

				int[][] arrayDilatado = dilatacionElem1(imagenPGM);
				this.imagenResultado = arrayDilatado;
				fin = true;
			} else if (this.id == 2) {

				int[][] arrayErosionado = erosionElem1(imagenPGM);
				this.imagenResultado2 = arrayErosionado;

				fin = true;
			}
			break;
			
		}case 2: {
			if (this.id == 1) {

				int[][] arrayDilatado = dilatacionElem2(imagenPGM);
				this.imagenResultado = arrayDilatado;
				fin = true;
			} else if (this.id == 2) {

				int[][] arrayErosionado = erosionElem2(imagenPGM);
				this.imagenResultado2 = arrayErosionado;

				fin = true;
			}
			break;
			
		}case 3: {
			if (this.id == 1) {

				int[][] arrayDilatado = dilatacionElem3(imagenPGM);
				this.imagenResultado = arrayDilatado;
				fin = true;
			} else if (this.id == 2) {

				int[][] arrayErosionado = erosionElem3(imagenPGM);
				this.imagenResultado2 = arrayErosionado;

				fin = true;
			}
			break;
			
		}case 4: {
			if (this.id == 1) {

				int[][] arrayDilatado = dilatacionElem4(imagenPGM);
				this.imagenResultado = arrayDilatado;
				fin = true;
			} else if (this.id == 2) {

				int[][] arrayErosionado = erosionElem4(imagenPGM);
				this.imagenResultado2 = arrayErosionado;

				fin = true;
			}
			break;
			
		}case 5: {
			if (this.id == 1) {

				int[][] arrayDilatado = dilatacionElem5(imagenPGM);
				this.imagenResultado = arrayDilatado;
				fin = true;
			} else if (this.id == 2) {

				int[][] arrayErosionado = erosionElem5(imagenPGM);
				this.imagenResultado2 = arrayErosionado;

				fin = true;
			}
			break;
			
		}case 6: {
			if (this.id == 1) {

				int[][] arrayDilatado = dilatacionElem6(imagenPGM);
				this.imagenResultado = arrayDilatado;
				fin = true;
			} else if (this.id == 2) {

				int[][] arrayErosionado = erosionElem6(imagenPGM);
				this.imagenResultado2 = arrayErosionado;

				fin = true;
			}
			break;
			
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + this.estructura);
		}


	}
	// Signo +
	public int[][] dilatacionElem1(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arr_resultado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
				// Copiamos valores para los casos donde ninguna condicion se cumpla.
				arr_resultado[i][j] = arrayInicial[i][j];
				// Primera Fila
				if (i == 0) {
					// Primera Columna
					if (j == 0) {
						// Derecha
						if (arrayInicial[i][j + 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j + 1];
						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];

					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];
					}
					// Otras columnas
					else {
						// Derecha
						if (arrayInicial[i][j + 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j + 1];
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];
					}

				}
				// Ultima fila
				else if (i == arrayInicial.length - 1) {
					// Primera Columna
					if (j == 0) {
						// Derecha
						if (arrayInicial[i][j + 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j + 1];
						// Arriba
						if (arrayInicial[i - 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j];

					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {

						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
						// Arriba
						if (arrayInicial[i - 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j];
					}
					// Otras columnas
					else {
						// Derecha
						if (arrayInicial[i][j + 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j + 1];

						// Arriba
						if (arrayInicial[i - 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j];

						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
					}

					// Las demas filas
				} else {
					// Primera Columna
					if (j == 0) {
						// Derecha
						if (arrayInicial[i][j + 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j + 1];
						// Arriba
						if (arrayInicial[i - 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j];
						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];

					} // Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
						// Arriba
						if (arrayInicial[i - 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j];
						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];
					} // Otras columnas
					else {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
						// Arriba
						if (arrayInicial[i - 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j];
						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];
						// Derecha
						if (arrayInicial[i][j + 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j + 1];
					}
				}

			}
		}
		return arr_resultado;
	}
	public int[][] erosionElem1(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arr_resultado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
				// Copiamos valores para los casos donde ninguna condicion se cumpla.
				arr_resultado[i][j] = arrayInicial[i][j];
				// Primera Fila
				if (i == 0) {
					// Primera Columna
					if (j == 0) {
						// Derecha
						if (arrayInicial[i][j + 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j + 1];
						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];

					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];
					}
					// Otras columnas
					else {
						// Derecha
						if (arrayInicial[i][j + 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j + 1];
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];
					}

				}
				// Ultima fila
				else if (i == arrayInicial.length - 1) {
					// Primera Columna
					if (j == 0) {
						// Derecha
						if (arrayInicial[i][j + 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j + 1];
						// Arriba
						if (arrayInicial[i - 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j];

					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {

						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
						// Arriba
						if (arrayInicial[i - 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j];
					}
					// Otras columnas
					else {
						// Derecha
						if (arrayInicial[i][j + 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j + 1];

						// Arriba
						if (arrayInicial[i - 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j];

						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
					}

					// Las demas filas
				} else {
					// Primera Columna
					if (j == 0) {
						// Derecha
						if (arrayInicial[i][j + 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j + 1];
						// Arriba
						if (arrayInicial[i - 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j];
						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];

					} // Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
						// Arriba
						if (arrayInicial[i - 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j];
						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];
					} // Otras columnas
					else {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
						// Arriba
						if (arrayInicial[i - 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j];
						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];
						// Derecha
						if (arrayInicial[i][j + 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j + 1];
					}
				}

			}
		}
		return arr_resultado;
	}

	// Elemento 2, Izquierda Abajo
	public int[][] dilatacionElem2(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arr_resultado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
				// Copiamos valores para los casos donde ninguna condicion se cumpla.
				arr_resultado[i][j] = arrayInicial[i][j];
				// Primera Fila
				if (i == 0) {
					// Primera Columna
					if (j == 0) {
						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];
					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];
					}
					// Otras columnas
					else {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];
					}

				}
				// Ultima fila
				else if (i == arrayInicial.length - 1) {
					// Primera Columna
					if (j == 0) {

					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
					}
					// Otras columnas
					else {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
					}

					// Las demas filas
				} else {
					// Primera Columna
					if (j == 0) {
						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];
					} // Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];
					} // Otras columnas
					else {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							// Abajo
							if (arrayInicial[i + 1][j] > arrayInicial[i][j])
								arr_resultado[i][j] = arrayInicial[i + 1][j];

					}
				}

			}
		}
		return arr_resultado;
	}

	public int[][] erosionElem2(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arr_resultado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
				// Copiamos valores para los casos donde ninguna condicion se cumpla.
				arr_resultado[i][j] = arrayInicial[i][j];
				// Primera Fila
				if (i == 0) {
					// Primera Columna
					if (j == 0) {
						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];
					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];
					}
					// Otras columnas
					else {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];
					}

				}
				// Ultima fila
				else if (i == arrayInicial.length - 1) {
					// Primera Columna
					if (j == 0) {

					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
					}
					// Otras columnas
					else {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
					}

					// Las demas filas
				} else {
					// Primera Columna
					if (j == 0) {
						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];
					} // Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];
					} // Otras columnas
					else {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							// Abajo
							if (arrayInicial[i + 1][j] < arrayInicial[i][j])
								arr_resultado[i][j] = arrayInicial[i + 1][j];

					}
				}

			}
		}
		return arr_resultado;
	}

	// Elemento 3, Izquierda Arriba
	public int[][] dilatacionElem3(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arr_resultado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
				// Copiamos valores para los casos donde ninguna condicion se cumpla.
				arr_resultado[i][j] = arrayInicial[i][j];
				// Primera Fila
				if (i == 0) {
					// Primera Columna
					if (j == 0) {

					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];

					}
					// Otras columnas
					else {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];

					}

				}
				// Ultima fila
				else if (i == arrayInicial.length - 1) {
					// Primera Columna
					if (j == 0) {

						// Arriba
						if (arrayInicial[i - 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j];
					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {

						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
						// Arriba
						if (arrayInicial[i - 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j];
					}

					// Otras columnas
					else {
						// Arriba
						if (arrayInicial[i - 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j];

						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
					}

					// Las demas filas
				} else {
					// Primera Columna
					if (j == 0) {
						// Arriba
						if (arrayInicial[i - 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j];

					} // Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
						// Arriba
						if (arrayInicial[i - 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j];
					} // Otras columnas
					else {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
						// Arriba
						if (arrayInicial[i - 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j];
					}
				}

			}
		}
		return arr_resultado;
	}

	public int[][] erosionElem3(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arr_resultado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
				// Copiamos valores para los casos donde ninguna condicion se cumpla.
				arr_resultado[i][j] = arrayInicial[i][j];
				// Primera Fila
				if (i == 0) {
					// Primera Columna
					if (j == 0) {

					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];

					}
					// Otras columnas
					else {

						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];

					}

				}
				// Ultima fila
				else if (i == arrayInicial.length - 1) {
					// Primera Columna
					if (j == 0) {

						// Arriba
						if (arrayInicial[i - 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j];

					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {

						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
						// Arriba
						if (arrayInicial[i - 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j];
					}
					// Otras columnas
					else {

						// Arriba
						if (arrayInicial[i - 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j];

						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
					}

					// Las demas filas
				} else {
					// Primera Columna
					if (j == 0) {

						// Arriba
						if (arrayInicial[i - 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j];

					} // Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
						// Arriba
						if (arrayInicial[i - 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j];

					} // Otras columnas
					else {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
						// Arriba
						if (arrayInicial[i - 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j];

					}
				}

			}
		}
		return arr_resultado;
	}

	// Elemento 4,  Izquierda Derecha

	public int[][] dilatacionElem4(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arr_resultado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
				// Copiamos valores para los casos donde ninguna condicion se cumpla.
				arr_resultado[i][j] = arrayInicial[i][j];
				// Primera Fila
				if (i == 0) {
					// Primera Columna
					if (j == 0) {

						// Derecha
						if (arrayInicial[i][j + 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j + 1];

					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {

						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];

					}
					// Otras columnas
					else {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];

						// Derecha
						if (arrayInicial[i][j + 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j + 1];

					}

				}
				// Ultima fila
				else if (i == arrayInicial.length - 1) {

					// Primera Columna
					if (j == 0) {

						// Derecha
						if (arrayInicial[i][j + 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j + 1];
					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {

						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];

					}

					// Otras columnas
					else {

						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];

						// Derecha
						if (arrayInicial[i][j + 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j + 1];

					}

					// Las demas filas
				} else {
					// Primera Columna
					if (j == 0) {

						// Derecha
						if (arrayInicial[i][j + 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j + 1];

					} // Ultima Columna
					else if (j == arrayInicial[i].length - 1) {

						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];

					} // Otras columnas
					else {
						// Izquierda
						if (arrayInicial[i][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];

						// Derecha
						if (arrayInicial[i][j + 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j + 1];
					}
				}

			}
		}
		return arr_resultado;
	}
	public int[][] erosionElem4(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arr_resultado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
				// Copiamos valores para los casos donde ninguna condicion se cumpla.
				arr_resultado[i][j] = arrayInicial[i][j];

				// Primera Fila
				if (i == 0) {
					// Primera Columna
					if (j == 0) {
						// Derecha
						if (arrayInicial[i][j + 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j + 1];
					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];

					}
					// Otras columnas
					else {
						// Derecha
						if (arrayInicial[i][j + 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j + 1];
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];
					}

				}
				// Ultima fila
				else if (i == arrayInicial.length - 1) {
					// Primera Columna
					if (j == 0) {

						// Derecha
						if (arrayInicial[i][j + 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j + 1];

					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {

						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];

					}
					// Otras columnas
					else {

						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];

						// Derecha
						if (arrayInicial[i][j + 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j + 1];
					}

					// Las demas filas
				} else {
					// Primera Columna
					if (j == 0) {

						// Derecha
						if (arrayInicial[i][j + 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j + 1];

					} // Ultima Columna
					else if (j == arrayInicial[i].length - 1) {

						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];

					} // Otras columnas
					else {
						// Izquierda
						if (arrayInicial[i][j - 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j - 1];

						// Derecha
						if (arrayInicial[i][j + 1] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i][j + 1];

					}
				}

			}
		}
		return arr_resultado;
	}

	// Elemento 5, Abajo
	
	public int[][] dilatacionElem5(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arr_resultado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
				// Copiamos valores para los casos donde ninguna condicion se cumpla.
				arr_resultado[i][j] = arrayInicial[i][j];
				// Primera Fila
				if (i == 0) {
					// Primera Columna
					if (j == 0) {

						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];

					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {

						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];
					}
					// Otras columnas
					else {

						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];
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
							arr_resultado[i][j] = arrayInicial[i + 1][j];

					} // Ultima Columna
					else if (j == arrayInicial[i].length - 1) {

						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];
					} // Otras columnas
					else {

						// Abajo
						if (arrayInicial[i + 1][j] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];

					}
				}

			}
		}
		return arr_resultado;
	}

	public int[][] erosionElem5(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arr_resultado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
				// Copiamos valores para los casos donde ninguna condicion se cumpla.
				arr_resultado[i][j] = arrayInicial[i][j];
				// Primera Fila
				if (i == 0) {
					// Primera Columna
					if (j == 0) {

						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];

					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {

						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];
					}
					// Otras columnas
					else {

						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];
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
							arr_resultado[i][j] = arrayInicial[i + 1][j];

					} // Ultima Columna
					else if (j == arrayInicial[i].length - 1) {

						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];
					} // Otras columnas
					else {

						// Abajo
						if (arrayInicial[i + 1][j] < arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j];

					}
				}

			}
		}
		return arr_resultado;
	}
	
	// Elemento 6, Signo X
	public int[][] dilatacionElem6(int[][] arrayInicial) {
		// Creamos el array que guardara los resultados
		int[][] arr_resultado = new int[arrayInicial.length][arrayInicial[0].length];
		for (int i = 0; i < arrayInicial.length; i++) {
			for (int j = 0; j < arrayInicial[i].length; j++) {
				// Copiamos valores para los casos donde ninguna condicion se cumpla.
				arr_resultado[i][j] = arrayInicial[i][j];
				// Primera Fila
				if (i == 0) {
					// Primera Columna
					if (j == 0) {
						// Derecha y Abajo
						if (arrayInicial[i + 1][j + 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j + 1];


					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda y Abajo
						if (arrayInicial[i + 1][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j - 1];

					}
					// Otras columnas
					else {
						// Derecha y Abajo
						if (arrayInicial[i + 1][j + 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j + 1];
						// Izquierda y Abajo
						if (arrayInicial[i + 1][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j - 1];
						
					}
					

				}
				// Ultima fila
				else if (i == arrayInicial.length - 1) {
					// Primera Columna
					if (j == 0) {
						// Derecha y Arriba
						if (arrayInicial[i - 1][j + 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j + 1];


					}
					// Ultima Columna
					else if (j == arrayInicial[i].length - 1) {

						// Izquierda y Arriba
						if (arrayInicial[i - 1][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j - 1];
					
					}
					// Otras columnas
					else {
						// Derecha y Arriba
						if (arrayInicial[i - 1][j + 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j + 1];
						// Izquierda y Arriba
						if (arrayInicial[i - 1][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j - 1];
					}

					// Las demas filas
				} else {
					// Primera Columna
					if (j == 0) {
						// Derecha y Arriba
						if (arrayInicial[i - 1][j + 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j + 1];
						// Derecha y Abajo
						if (arrayInicial[i + 1][j + 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j + 1];

					} // Ultima Columna
					else if (j == arrayInicial[i].length - 1) {
						// Izquierda y Arriba
						if (arrayInicial[i - 1][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j - 1];
						// Izquierda y Abajo
						if (arrayInicial[i + 1][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j - 1];
						
					} // Otras columnas
					else {
						// Izquierda y Arriba
						if (arrayInicial[i - 1][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j - 1];
						// Izquierda y Abajo
						if (arrayInicial[i + 1][j - 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j - 1];
						// Derecha y Arriba
						if (arrayInicial[i - 1][j + 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i - 1][j + 1];
						// Derecha y Abajo
						if (arrayInicial[i + 1][j + 1] > arrayInicial[i][j])
							arr_resultado[i][j] = arrayInicial[i + 1][j + 1];
					}
				}

			}
		}
		return arr_resultado;
	}
	
	public int[][] erosionElem6(int[][] arrayInicial) {
			// Creamos el array que guardara los resultados
			int[][] arr_resultado = new int[arrayInicial.length][arrayInicial[0].length];
			for (int i = 0; i < arrayInicial.length; i++) {
				for (int j = 0; j < arrayInicial[i].length; j++) {
					// Copiamos valores para los casos donde ninguna condicion se cumpla.
					arr_resultado[i][j] = arrayInicial[i][j];
					// Primera Fila
					if (i == 0) {
						// Primera Columna
						if (j == 0) {
							// Derecha y Abajo
							if (arrayInicial[i + 1][j + 1] < arrayInicial[i][j])
								arr_resultado[i][j] = arrayInicial[i + 1][j + 1];


						}
						// Ultima Columna
						else if (j == arrayInicial[i].length - 1) {
							// Izquierda y Abajo
							if (arrayInicial[i + 1][j - 1] < arrayInicial[i][j])
								arr_resultado[i][j] = arrayInicial[i + 1][j - 1];

						}
						// Otras columnas
						else {
							// Derecha y Abajo
							if (arrayInicial[i + 1][j + 1] < arrayInicial[i][j])
								arr_resultado[i][j] = arrayInicial[i + 1][j + 1];
							// Izquierda y Abajo
							if (arrayInicial[i + 1][j - 1] < arrayInicial[i][j])
								arr_resultado[i][j] = arrayInicial[i + 1][j - 1];
							
						}
						

					}
					// Ultima fila
					else if (i == arrayInicial.length - 1) {
						// Primera Columna
						if (j == 0) {
							// Derecha y Arriba
							if (arrayInicial[i - 1][j + 1] < arrayInicial[i][j])
								arr_resultado[i][j] = arrayInicial[i - 1][j + 1];


						}
						// Ultima Columna
						else if (j == arrayInicial[i].length - 1) {

							// Izquierda y Arriba
							if (arrayInicial[i - 1][j - 1] < arrayInicial[i][j])
								arr_resultado[i][j] = arrayInicial[i - 1][j - 1];
						
						}
						// Otras columnas
						else {
							// Derecha y Arriba
							if (arrayInicial[i - 1][j + 1] < arrayInicial[i][j])
								arr_resultado[i][j] = arrayInicial[i - 1][j + 1];
							// Izquierda y Arriba
							if (arrayInicial[i - 1][j - 1] < arrayInicial[i][j])
								arr_resultado[i][j] = arrayInicial[i - 1][j - 1];
						}

						// Las demas filas
					} else {
						// Primera Columna
						if (j == 0) {
							// Derecha y Arriba
							if (arrayInicial[i - 1][j + 1] < arrayInicial[i][j])
								arr_resultado[i][j] = arrayInicial[i - 1][j + 1];
							// Derecha y Abajo
							if (arrayInicial[i + 1][j + 1] < arrayInicial[i][j])
								arr_resultado[i][j] = arrayInicial[i + 1][j + 1];

						} // Ultima Columna
						else if (j == arrayInicial[i].length - 1) {
							// Izquierda y Arriba
							if (arrayInicial[i - 1][j - 1] < arrayInicial[i][j])
								arr_resultado[i][j] = arrayInicial[i - 1][j - 1];
							// Izquierda y Abajo
							if (arrayInicial[i + 1][j - 1] < arrayInicial[i][j])
								arr_resultado[i][j] = arrayInicial[i + 1][j - 1];
							
						} // Otras columnas
						else {
							// Izquierda y Arriba
							if (arrayInicial[i - 1][j - 1] < arrayInicial[i][j])
								arr_resultado[i][j] = arrayInicial[i - 1][j - 1];
							// Izquierda y Abajo
							if (arrayInicial[i + 1][j - 1] < arrayInicial[i][j])
								arr_resultado[i][j] = arrayInicial[i + 1][j - 1];
							// Derecha y Arriba
							if (arrayInicial[i - 1][j + 1] < arrayInicial[i][j])
								arr_resultado[i][j] = arrayInicial[i - 1][j + 1];
							// Derecha y Abajo
							if (arrayInicial[i + 1][j + 1] < arrayInicial[i][j])
								arr_resultado[i][j] = arrayInicial[i + 1][j + 1];
						}
					}

				}
			}
			return arr_resultado;
		}

}
