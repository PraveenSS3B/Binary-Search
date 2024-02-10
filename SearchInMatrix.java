package in.Searching;

public class SearchInMatrix {

	public static void main(String[] args) {
		int arr[][] = {{1}};
		
		System.out.println(searchMatrix(arr,1));

	}

	public static boolean findTarget(int[] arr, int target) {
		int low = 0, high = arr.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == target)
				return true;
			else if (arr[mid] > target) {
				high = mid - 1;
			}

			else {
				low = mid + 1;
			}
		}

		return false;
	}

	public static boolean searchMatrix(int[][] matrix, int target) {

		for (int i = 0; i < matrix.length; i++) {
			int n = matrix[i].length;
			if (matrix[i][n - 1] >= target) {
				return findTarget(matrix[i], target);
			}
		}

		return false;
	}
}
