package sudoku;

public class Sudoku {
    private final int[][] board;
    public static final int EMPTY = 0; // Valor de celda vacía
    public static final int SIZE = 9;  // Tamaño del sudoku
	
    public Sudoku(int[][] board) {
        this.board = new int[SIZE][SIZE];
	for (int i = 0; i < SIZE; i++) {
            System.arraycopy(board[i], 0, this.board[i], 0, SIZE);
	}
    }
	
    // Comprueba si un número cumple todas las restricciones del sudoku
    private boolean checkConstraints(int row, int col, int number) {
	return !checkRowConstraint(row, number) 
                && !checkColumnConstraint(col, number) 
                && !checkBoxConstraint(row, col, number);
    }
    
    // Comprueba la restricción de fila de un número
    private boolean checkRowConstraint(int row, int number) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }
	
    // Comprueba la restricción de columna de un número
    private boolean checkColumnConstraint(int col, int number) {
	for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == number) {
		return true;
            }
        }	
	return false;
    }

    // Comprueba la restricción de grupo de un número
    private boolean checkBoxConstraint(int row, int col, int number) {
	int r = row - row % 3;
	int c = col - col % 3;
	for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
		if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Busca la solución del sudoku. No muestra nada por la salida estándar.
     * @return 
     *      Verdadero si el sudoku se pudo solucionar, falso si no.
     */
    public boolean solve() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                // Buscamos una celda vacía
                if (board[row][col] == EMPTY) {
                    // Vamos comprobando todos los números posibles
                    for (int number = 1; number <= SIZE; number++) {
                        if (checkConstraints(row, col, number)) {
                            // Se cumplen las restricciones, el número es válido
                            board[row][col] = number;
                            // Buscamos solución al resto de celdas vacías.
                            // Si fuera necesario, realizamos backtracking.
                            if (solve()) {
                                return true;
                            } else {
                                board[row][col] = EMPTY;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Busca la solución del sudoku. Muestra por la salida estándar el sudoku 
     * sin resolver y su solución, si la hay.
     * @param message
     *      Mensaje a mostrar antes de buscar la solución del sudoku.
     * @return 
     *      Verdadero si el sudoku se pudo solucionar, falso si no.
     */
    public boolean solve(String message) {
        display(message);
        if (solve()) {
            display("La solución es:");
            return true;
	} else {
            System.out.println("El sudoku no tiene solución.");
            return false;
        }
    }
	
    /**
     * Muestra por la salida estándar una representación del sudoku.
     */
    public void display() {
	for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
		System.out.print(" " + board[i][j]);
            }
		
            System.out.println();
	}
		
	System.out.println();
    }
    
    /**
     * Muestra por la salida estándar una representación del sudoku, mostrando
     * previamente un mensaje.
     * @param message 
     *      Mensaje a mostrar, en forma de String.
     */
    public void display(String message) {
        System.out.println(message);
        display();
    }
}