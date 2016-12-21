package data_structures_and_algorithms.leetCode.easy;

import java.util.HashSet;
import java.util.Set;

public class ValidSodoku {

    public static boolean isValidSudoku(char[][] board) {
	for (int i = 0; i < 9; i++) {
	    if (!duplicates(board, i, i))
		return false;
	    if (i % 3 == 0 && !checkSquare(board, i))
		return false;

	}
	return true;
    }

    public static boolean duplicates(char[][] board, int row, int col) {
	Set<Character> set = new HashSet<Character>();
	for (int j = 0; j < board[row].length; j++) {
	    if (board[row][j] != '.') {
		if (set.contains(board[row][j]))
		    return false;
		else
		    set.add(board[row][j]);
	    }
	}
	set.clear();
	for (int i = 0; i < board.length; i++) {
	    if (board[i][col] != '.') {
		if (set.contains(board[i][col]))
		    return false;
		else
		    set.add(board[i][col]);
	    }
	}
	return true;
    }

    public static boolean checkSquare(char[][] board, int sq) {
	Set<Character> set = new HashSet<Character>();
	for (int j = 0; j < board[0].length; j++) {
	    if (j % 3 == 0)
		set.clear();
	    for (int i = sq; i <= sq + 2; i++) {
		if (board[i][j] != '.') {

		    if (set.contains(board[i][j]))
			return false;
		    else
			set.add(board[i][j]);
		}
	    }

	}
	return true;
    }

    public static void main(String[] args) {
	String[] board = { "....5..1.", ".4.3.....", ".....3..1", "8......2.",
		"..2.7....", ".15......", ".....2...", ".2.9.....", "..4......" };
	char[][] b = new char[9][9];
	int k = 0;
	for (String i : board) {
	    b[k++] = i.toCharArray();
	}
	System.out.println(isValidSudoku(b));
    }

}
