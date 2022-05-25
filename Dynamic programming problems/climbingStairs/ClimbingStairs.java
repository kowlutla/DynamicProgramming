package climbingStairs;


/*A child is climbing up a staircase with n steps and can hop either 1step or 2steps
 * at a Time Implement a method to count how many possible ways the child can climb 
 * up the stairs
 * */


// **** Generalized solution********

/*A child is climbing up a staircase with 'N' STEPS and can hop at most 'M'STEPS
 * at a Time Implement a method to count how many possible ways the child can climb 
 * up the stairs
 *  suppose m=4
 *  T(n)=T(n-1)+T(n-2)+T(n-3)+T(n-4)
 *  Suppose m=5
 *  T(n)=T(n-1)+T(n-2)+T(n-3)+T(n-4)+T(n-5)
 *  
 *  at M
 *  
 *  T(n)=T(n-1)+T(n-2)+T(n-3)+T(n-4)..........+T(n-m);
 *  
 *  Time Complexity:
 *  Recursive Algorith:O(m^n)
 *  DP Solution: O(n)
 *  
 *  
 * */
import java.util.Scanner;

public class ClimbingStairs {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no of stairs: ");
		int stairs = sc.nextInt();
		int no_of_ways = getNoOfWays(stairs);
		System.out.println(no_of_ways + " Ways");
		no_of_ways = getNoOfWays1(stairs);
		System.out.println(no_of_ways + " Ways");
		no_of_ways = getNoOfWays2(stairs);
		System.out.println(no_of_ways + " Ways");
		no_of_ways = getNoOfWays3(stairs);
		System.out.println(no_of_ways + " Ways");

		sc.close();
	}

	// Normal recursion solution TIme Complexity-O(2^n) Space Complexity-O(1)
	private static int getNoOfWays(int n) {

		if (n < 0) {
			return 0;
		}
		else if (n == 0) {
			return 1;
		}
		return getNoOfWays(n - 1) + getNoOfWays(n - 2);
	}

	// Time Complexity-O(n) Space Complexity-O(n)
	// TOP DOWN APPROACH(MEMORIZATION)
	private static int getNoOfWays1(int n) {

		int cache[] = new int[n + 1];
		if (n < 0) {
			return 0;
		}
		else if (n == 0) {
			return 1;
		}
		if (cache[n] != 0) {
			return cache[n];
		}

		return cache[n] = getNoOfWays1(n - 1) + getNoOfWays1(n - 2);
	}

	// Time Complexity-O(n) Space Complexity-O(n)
	// Bottom-Up approach (Tabulation) Efficient
	private static int getNoOfWays3(int n) {
		int cache[] = new int[n + 1];

		cache[0] = 1;
		cache[1] = 1;
		for (int i = 2; i <= n; i++) {
			cache[i] = cache[i - 1] + cache[i - 2];
		}
		return cache[n];
	}

	//general solution MOST EFFICIENT
	//Time complexity-O(n) Space complexity-O(1)
	private static int getNoOfWays2(int n) {

		int first=1;int second=1,sum=0;
		for (int i = 2; i <= n; i++) {
			sum = first+second;
			first = second;
			second = sum;
		}
		return sum;
	}

}
