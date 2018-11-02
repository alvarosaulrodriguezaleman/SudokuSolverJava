package main;

import sudoku.Sudoku;

public class Main {
    public static int[][] normalSudoku = {
		{9,0,5,1,0,0,0,0,5},
		{0,0,5,0,9,0,2,0,1},
		{8,0,0,0,4,0,0,0,0},
		{0,0,0,0,8,0,0,0,0},
		{0,0,0,7,0,0,0,0,0},
		{0,0,0,0,2,6,0,0,9},
		{2,0,0,3,0,0,0,0,6},
		{0,0,0,2,0,0,9,0,0},
		{0,0,1,9,0,4,5,7,0},
    };

    public static int[][] hardestBacktrackingSudoku = {
		{0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,3,0,8,5},
		{0,0,1,0,2,0,0,0,0},
		{0,0,0,5,0,7,0,0,0},
		{0,0,4,0,0,0,1,0,0},
		{0,9,0,0,0,0,0,0,0},
		{5,0,0,0,0,0,0,7,3},
		{0,0,2,0,1,0,0,0,0},
		{0,0,0,0,4,0,0,0,9},
    };
    
    public static void main(String[] args) {
	Sudoku sudoku = new Sudoku(normalSudoku);
	sudoku.solve("Primer sudoku a solucionar:");
		
        sudoku = new Sudoku(hardestBacktrackingSudoku);
        sudoku.solve("Segundo sudoku a solucionar");
    }
}
