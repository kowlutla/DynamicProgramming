/**
  Given two String s1 and s2 then find the length of longest common substring
  
  Input: 
  s1:javaaid
  s2:javaid
  
  Output: 4 (java)
 */
package longestCommonSubString;

import java.util.Scanner;

/**
 * @author apiiit-rkv
 *
 */
public class LongestCommonSubString {

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
		int count=0;
		System.out.println("Method 1: Using resursion: ");
		int longest_sub_string=getLongestCommonSubString(array1,array2,m,n,count);
		
		System.out.println("Longest Substring count: "+longest_sub_string);
		
		
		System.out.println("Top Down Method: ");
		int dp[][][]=new int[m+1][n+1][Math.max(m,n)+1];
		longest_sub_string=getLongestCommonSubString1(array1,array2,m,n,count,dp);
		System.out.println("Longest Substring count: "+longest_sub_string);
		
		
		System.out.println("Using Bottom Up Solution: ");
		longest_sub_string=getLongestCommonSubString2(array1,array2,m,n);
		System.out.println("Longest Substring count: "+longest_sub_string);
		sc.close();
		
		
		
		

	}

	
	//Bottom up approach
	//Time complexity: O(m*n)
	//Space complexity: O(m*n) 
	private static int getLongestCommonSubString2(char[] array1, char[] array2, int m, int n) {
		
		int cache[][]=new int[m+1][n+1];
		
		int result=0;
		for(int i=0;i<=m;i++)
		{
			for(int j=0;j<=n;j++)
			{
				if(i==0 || j==0)
				{
					cache[i][j]=0;
				}
				else if(array1[i-1]==array2[j-1])
				{
					cache[i][j]=cache[i-1][j-1]+1;
					result=Math.max(result, cache[i][j]);
				}
				else
				{
					cache[i][j]=0;
				}
			}
		}
		
		return result;
	}



	//Recursive solution
	//Time complexity: O(3^(m+n)) Space complexity: O(m+n)
	private static int getLongestCommonSubString(char[] array1, char[] array2, int m, int n, int count) {
		
		if(m<=0 || n<=0)
		{
			return count;
		}
		int count1=count;
		if(array1[m-1]==array2[n-1])
		{
			count1=getLongestCommonSubString(array1,array2,m-1,n-1,count+1);
		}
		
		int count2=getLongestCommonSubString(array1,array2,m-1,n,0);
		int count3=getLongestCommonSubString(array1,array2,m,n-1,0);
		
		return Math.max(count1, Math.max(count2, count3));
	}
	
	
	
	private static int getLongestCommonSubString1(char[]array1,char []array2,int m,int n,int count,int[][][]dp)
	{
		if(m<=0 || n<=0)
		{
			return count;
		}
		
		if(dp[m][n][count]!=0)
		{
			return dp[m][n][count];
		}
		
		int count1=count;
		if(array1[m-1]==array2[n-1]) {
			count1=getLongestCommonSubString1(array1,array2,m-1,n-1,count+1,dp);
		}
		int count2=getLongestCommonSubString1(array1,array2,m-1,n,0,dp);
		int count3=getLongestCommonSubString1(array1,array2,m,n-1,0,dp);
		
		return dp[m][n][count]=Math.max(count1, Math.max(count2, count3));
	}

}
