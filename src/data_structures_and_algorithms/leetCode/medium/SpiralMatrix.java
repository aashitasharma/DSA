package data_structures_and_algorithms.leetCode.medium;

import java.util.*;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
	List<Integer> res = new ArrayList<Integer>();
	if (matrix.length == 0)
	    return res;
	int topRow = 0;
	int bottomRow = matrix.length - 1;
	int rightCol = matrix[0].length - 1;
	int leftCol = 0;

	while (topRow <= bottomRow && rightCol >= leftCol) {
	    for (int i = leftCol; i <= rightCol; i++)
		res.add(matrix[topRow][i]);
	    topRow++;
	    for (int i = topRow; i <= bottomRow; i++)
		res.add(matrix[i][rightCol]);
	    rightCol--;
	    for (int i = rightCol; i >= leftCol && topRow <= bottomRow; i--)
		res.add(matrix[bottomRow][i]);
	    bottomRow--;
	    for (int i = bottomRow; i >= topRow && leftCol <= rightCol; i--)
		res.add(matrix[i][leftCol]);
	    leftCol++;
	}
	return res;
    }

}
