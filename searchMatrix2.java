public boolean searchMatrix2(int[][] matrix, int target) {
  int rs = matrix.length;
  int cs = matrix[0].length;

  int row = 0, col = cs - 1;

  while (row < rs && col >= 0) {
    if (matrix[row][col] == target) return true;
    else if (matrix[row][col] > target) {
      col--;
    } else {
      row++;
    }
  }

  return false;
}
