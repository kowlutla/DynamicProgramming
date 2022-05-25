package climbingStairs;

import java.util.Scanner;

public class MoreOnClimbingStairs {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no of stairs: ");
		int stairs = sc.nextInt();
		int no_of_ways = getNoOfWays(stairs);
		System.out.println(no_of_ways);
		sc.close();

	}

	private static int getNoOfWays(int n) {
		
		int cache[] = new int[n + 1];
		//base cases
		cache[0] = 1;
		cache[1] = 1;
		cache[2]=2;
		
		for (int i = 3; i <= n; i++) {
			cache[i] = cache[i - 1] + cache[i - 2]+cache[i-3];
		}
		return cache[n];
	}

}
