import java.util.* ;
import java.io.*; 

public class SqareRootUsingBS {

	public static int sqrtN(long N) {
		long low = 1, high = N;
		long ans = 0;

		while(low <= high)
		{
			long mid = low + (high - low) / 2;

			if(mid * mid > N)
			{
				high = mid - 1;
			}

			else if(mid * mid <= N)
			{
				low = mid + 1;
				ans = Math.max(ans, mid);
			}

		}

		return (int)ans;
	}
}
