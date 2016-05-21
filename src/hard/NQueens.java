package hard;

import java.util.*;

public class NQueens {

	static class Point {
		int row;
		int col;

		public Point(int r, int c) {
			row = r;
			col = c;
		}

		@Override
		public String toString() {
			return "(" + row + "," + col + ")";
		}
	}

	public static void main(String[] args) {
		List<List<String>> r = solveNQueens(5);
		System.out.println(r);
	}

	public static List<List<String>> solveNQueens(int n) {
		int[][] grid = new int[n][n];
		List<List<String>> res = new LinkedList<List<String>>();
		Set<List<String>> res2 = new HashSet<List<String>>();
		if (n > 1 && n < 4)
			return res;
		for (int i = 0; i < n; i++) {
			// System.out.println(prev_config);
			Stack<Point> q = new Stack<Point>();
			generate_grid(grid, n);
			nqueens(grid, q, i, 0);
			if (q.size() == n) {
				if (grid[q.firstElement().row][0] == 1)
					// System.out.println(i);
					res2.add(print_grid(grid));
			}
		}
		for(List<String> l:res2){
			res.add(l);
//			System.out.println(l);
		}
		return res;
	}

	public static void generate_grid(int[][] grid, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				grid[i][j] = 0;
		}
	}

	public static void nqueens(int[][] grid, Stack<Point> queens,
			int start_row, int c) {
		if (c >= grid[0].length) {
			return;
		}
		for (int r = start_row; r < grid.length; r++) {
			if (isSafe(queens, r, c)) {
				placeQueen(r, c, grid, queens);
				nqueens(grid, queens, 0, c + 1);
				if (queens.size() == grid.length) {
					return;
				}
			}
		}
		if (queens.size() > 0) {
			Point p = queens.pop();
			grid[p.row][p.col] = 0;
		}
	}

	public static void placeQueen(int r, int c, int[][] grid,
			Stack<Point> queens) {
		grid[r][c] = 1;
		queens.add(new Point(r, c));
	}

	public static boolean isSafe(Stack<Point> q, int row, int col) {
		for (Point i : q) {
			if (i.row == row || i.col == col
					|| Math.abs(i.col - col) == Math.abs(i.row - row)
					|| (row == i.row && col == i.col))
				return false;
		}
		return true;
	}

	public static List<String> print_grid(int[][] grid) {
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < grid.length; i++) {
			String s = "";
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					s += ".";
//					System.out.print(".");
				} else {
//					System.out.print("q");
					s += "Q";
				}
			}
//			System.out.println();
			res.add(s);
		}
		return res;
	}

}
