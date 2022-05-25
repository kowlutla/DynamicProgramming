/**
 * Problem Statement:
  ---------------------
  You are a professional robber planning to rob houses along the street.Each house has certain amount of money
  ,the only constraint stopping you from robbing each of them is that adjacent houses have security system
  connected and it is automatically contact the police if if two adjacent houses were broken into on the same 
  night.
  
   Given list of non-negative integers representing the amount of money of each house,determine the maximum 
   amount of money you can rob tonight without alerting police
   			
   								OR
   						
   	Given an array of positive integers ,find the maximum sum of subsequence with the constraint that 
   	No two numbers in the sequence should be adjacent in the array
   	
   								OR
   								
   	Find the maximum sum in array such that no two elements are adjacent
   
   Input: 2 7 9 3 1 {money of each houses}
   Output: 12 (2+9+1)
   
 */
package houseRobber;

import java.util.Scanner;

/**
 * @author kowlutla
 *
 */
public class HouseRobber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no of houses: ");
		int n = sc.nextInt();
		int houses[] = new int[n];
		System.out.println("Enter money of each house: ");
		for (int i = 0; i < n; i++) {
			houses[i] = sc.nextInt();
		}
		System.out.println("Method1: ");
		method1(houses);
		System.out.println("Method2: ");
		method2(houses);
		System.out.println("Method3: ");
		method3(houses);
		System.out.println("Method4: ");
		method4(houses);
		sc.close();

	}

	private static void method1(int[] houses) {

		System.out.println("Using recursion: ");
		long start = System.nanoTime();
		int max_amount = rob1(houses, 0);
		System.out.println("Maximum Money : " + max_amount);
		long end = System.nanoTime();
		System.out.println("Execution Time: " + (end - start));

	}

	// recursive solution
	// Time complexity: O(2^n)
	private static int rob1(int[] houses, int i) {

		if (i >= houses.length) {
			return 0;
		}

		int ith_house_selected = rob1(houses, i + 2) + houses[i];
		int ith_house_not_selscted = rob1(houses, i + 1);

		return Math.max(ith_house_selected, ith_house_not_selscted);
	}

	private static void method2(int[] houses) {

		System.out.println("\nUsing TopDown");
		long start = System.nanoTime();
		int max_amount = rob2(houses, 0);
		System.out.println("Maximum Money : " + max_amount);
		long end = System.nanoTime();
		System.out.println("Execution Time: " + (end - start));

	}
	
	
	//Top down approach
	//Time complexity:O(n) Space complexity: O(n)
	private static int rob2(int[] houses, int i) {
		
		int cache[]=new int[houses.length+1];
		if(i>=houses.length)
		{
			return 0;
		}
		
		if(cache[i]!=0)
		{
			return cache[i];
		}
		int ith_house_selected=rob2(houses,i+2)+houses[i];
		int iht_house_not_selected=rob2(houses,i+1);
		
		return cache[i]=Math.max(ith_house_selected, iht_house_not_selected);
	}
	

	private static void method3(int[] houses) {

		System.out.println("\nUsing Bottom up: ");
		long start = System.nanoTime();
		int max_amount = rob3(houses);
		System.out.println("Maximum Money : " + max_amount);
		long end = System.nanoTime();
		System.out.println("Execution Time: " + (end - start));

	}

	//Bottom up approach
	//Time complexity:O(n) Space complexity:O(n)
	private static int rob3(int[] houses) {
		
		int cache[]=new int[houses.length+1];
		
		cache[0]=houses[0];
		cache[1]=Math.max(houses[0], houses[1]);
		
		for(int i=2;i<houses.length;i++)
		{
			int ith_house_select=cache[i-2]+houses[i];
			int ith_house_not_select=cache[i-1];
			
			cache[i]=Math.max(ith_house_select, ith_house_not_select);
		}
		return cache[houses.length-1];
	}
	
	
	private static void method4(int[] houses) {

		System.out.println("\nEfficient solution: ");
		long start = System.nanoTime();
		int max_amount = rob4(houses);
		System.out.println("Maximum Money : " + max_amount);
		long end = System.nanoTime();
		System.out.println("Execution Time: " + (end - start));

	}

	
	//Time complexity: O(n) Space complexity: O(1)
	private static int rob4(int[] houses) {
		
		int pre2=houses[0];
		int pre1=Math.max(pre2, houses[1]);
		
		for(int i=2;i<houses.length;i++)
		{
			int temp=pre1;
			pre1=Math.max(pre1, pre2+houses[i]);
			pre2=temp;
		}
		return pre1;
		
		
	}
	
	

}
