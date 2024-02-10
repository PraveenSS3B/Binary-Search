package in.Searching;

public class SearchInMatrix {
  public boolean searchMatrix(int[][] matrix, int target) {

    // [1,3,5,7,10,11,16,20,23,30,34,60]

    int rs = matrix.length;
    int cs = matrix[0].length;
    int low = 0, high = rs * cs - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      int row = mid / cs;

      int col = mid % cs;

      if (matrix[row][col] == target) {
        return true;
      } else if (matrix[row][col] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return false;
  }
}
