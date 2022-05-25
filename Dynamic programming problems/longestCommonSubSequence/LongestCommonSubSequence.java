/**
 * 
 */
package longestCommonSubSequence;

import java.util.Scanner;

/**
 * @author apiiit-rkv
 *
 */
public class LongestCommonSubSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter string1: ");
		String s1=sc.nextLine();
		System.out.print("Enter string2: ");
		String s2=sc.nextLine();
		
		char array1[]=s1.toCharArray();
		char array2[]=s2.toCharArray();
		int m=array1.length;
		int n=array2.length;
		
		System.out.println("Method 1: Using resursion: ");
		int longest_sub_sequence=LCS1(array1,array2,m,n);
		System.out.print("Longest Subsequence: "+longest_sub_sequence);
		
		
		System.out.println("\nMethod 2: TopDown approch: ");
		int cache[][]=new int[m+1][n+1];
		longest_sub_sequence=LCS2(array1,array2,m,n,cache);
		System.out.print("Longest Subsequence: "+longest_sub_sequence);
		
		System.out.println("\nMethod 2: Bottom-Up approch: ");
		longest_sub_sequence=LCS3(s1,s2,m,n);
		System.out.print("Longest Subsequence: "+longest_sub_sequence);
		
		System.out.println("\nMethod 2: Bottom-Up approch With more efficient: ");
		longest_sub_sequence=LCS4(s1,s2,m,n);
		System.out.print("Longest Subsequence: "+longest_sub_sequence);
		
		
		
		
		sc.close();
	}

	//Method 1
	//Using Recursion
	//Time complexity: O(n^(m*n)) Space complexity: O(m*n)
	private static int LCS1(char[] array1, char[] array2, int m, int n) {
		
		if(n<=0 || m<=0)
		{
			return 0;
		}
		if(array1[m-1]==array2[n-1])
		{
			return 1+LCS1(array1,array2,m-1,n-1);
		}
		
		int count1=LCS1(array1,array2,m-1,n);
		int count2=LCS1(array1,array2,m,n-1);
		
		return Math.max(count1, count2);
		
	}
	
	
	
	//Method 2
	//TopDown approach (Memoization)
	private static int LCS2(char[] array1, char[] array2, int m, int n,int cache[][]) {
		
		if(n<=0 || m<=0)
		{
			return 0;
		}
		
		if(cache[m][n]!=0)
		{
			return cache[m][n];
		}
		if(array1[m-1]==array2[n-1])
		{
			return 1+LCS2(array1,array2,m-1,n-1,cache);
		}
		
		int count1=LCS2(array1,array2,m-1,n,cache);
		int count2=LCS2(array1,array2,m,n-1,cache);
		
		return cache[m][n]= Math.max(count1, count2);
		
	}
	
	
	//Method 3
	//Bottom up approach(Tabulation) Pure Dynamic Programming
	//Time complexity: O(m*n) Space complexity: O(m*n)
	private static int LCS3(String s1,String s2,int m,int n)
	{
		int cache[][]=new int[m+1][n+1];
		for(int i=0;i<=m;i++)
		{
			for(int j=0;j<=n;j++)
			{
				if(i==0 || j==0)
				{
					cache[i][j]=0;
				}
				else if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					cache[i][j]=cache[i-1][j-1]+1;
				}
				else 
				{
					cache[i][j]=Math.max(cache[i-1][j],cache[i][j-1]);
				}
			}
		}
		
		return cache[m][n];
		
		
	}
	
	
	
		//Method 4
		//Bottom up approach(Tabulation) Pure Dynamic Programming more efficient
		//Time complexity: O(m*n) Space complexity: O(n)
		private static int LCS4(String s1,String s2,int m,int n)
		{
			int cache[]=new int[n+1];
			for(int i=1;i<=m;i++)
			{
				int prev=0;
				for(int j=1;j<=n;j++)
				{
					int temp=cache[j];
					if(s1.charAt(i-1)==s2.charAt(j-1))
					{
						cache[j]=prev+1;
					}
					else
					{
						cache[j]=Math.max(cache[j], cache[j-1]);
					}
					prev=temp;
				}
			}
			
			return cache[n];
			
			
		}
	
	
	
	
	
	
	

}
