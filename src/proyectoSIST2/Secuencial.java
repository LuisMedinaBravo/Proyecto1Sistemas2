
package proyectoSIST2;

public class Secuencial {

	// VariableCompartida general;

	int id;
	int[][] imagenPGM;
	int[][] imagenResultado;
	int[][] imagenResultado2;
	boolean fin = false;
	boolean fin2 = false;

	Secuencial(int id, int[][] matriz) {
		this.id = id;
		this.imagenPGM = matriz;

	}

	public int[][] getImagenResultado() {
		return imagenResultado;
	}

	public int[][] getImagenResultado2() {
		return imagenResultado2;
	}

	public void run() {

		// Matriz de imagen PGM

		if (this.id == 1) {

			int[][] arrayDilatado = dilatacionElem1(imagenPGM);
			this.imagenResultado = arrayDilatado;
			fin = true;
		} else if (this.id == 2) {

			int[][] arrayErosionado = erosionElem1(imagenPGM);
			this.imagenResultado2 = arrayErosionado;

			fin = true;
		}

	}

	// Elemento 1, Signo +
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
		this.imagenResultado = arr_resultado;
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
		this.imagenResultado2 = arr_resultado;
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
		this.imagenResultado = arr_resultado;
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
		this.imagenResultado2 = arr_resultado;
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
		this.imagenResultado = arr_resultado;
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
		this.imagenResultado2 = arr_resultado;
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
		this.imagenResultado = arr_resultado;
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
		this.imagenResultado2 = arr_resultado;
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
		this.imagenResultado = arr_resultado;
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
		this.imagenResultado2 = arr_resultado;
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
        this.imagenResultado=arr_resultado;
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
	        this.imagenResultado2=arr_resultado;
			return arr_resultado;
		}
	        

	// Llenando matriz de prueba
	// int[][] hola = new int[5][4];
	// for (int i = 0; i < hola.length; i++) {
	// for (int j = 0; j < hola[i].length; j++) {

	// hola[i][j] = j;

	// }
	// }

	// Matriz de prueba
	// int[][] arrayDilatado = dilatacionElem2(hola);
	// int[][]arrayErosionado = erosionElem3(hola);
	// Print Matriz normal
	// System.out.println("Matriz normal:"); imprimirMatriz(hola);
	// System.out.println("Matriz dilatada:");
	
	// Print Matriz Dilatada
	// imprimirMatriz(arrayDilatado);
	// System.out.println("Matriz erosionada:");
	// PrintMatriz Erosionada
	// imprimirMatriz(arrayErosionado);
	// Metodo para imprimir una matriz
	/*
	 * private void imprimirMatriz(int[][] matriz) { for (int i = 0; i <
	 * matriz.length; i++) { for (int j = 0; j < matriz[i].length; j++)
	 * System.out.print(matriz[i][j]); System.out.println(""); } }
	 */
}
