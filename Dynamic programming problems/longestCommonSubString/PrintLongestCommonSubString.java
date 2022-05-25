/**
 * Ex:
 * Input:
 * ---------
 * 		s1: Javaaid
 *		s2: Javaid
 *	
 *		Output:Java
 * 
 */
package longestCommonSubString;

import java.util.Scanner;

/**
 * @author apiiit-rkv
 *
 */
public class PrintLongestCommonSubString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter string1: ");
		String s1=sc.nextLine();
		System.out.print("Enter string2: ");
		String s2=sc.nextLine();
		System.out.println("String 1: "+s1);
		System.out.println("String 2: "+s2);
		
		String common_string=getLCS(s1,s2);
		System.out.println("Longest substring: "+common_string);
		sc.close();
		

	}

	private static String getLCS(String s1, String s2) {
		
		int m=s1.length();
		int n=s2.length();
		
		int cache[][]=new int[m+1][n+1];
		int length=0;
		int row=0,col=0;
		for(int i=0;i<=s1.length();i++)
		{
			for(int j=0;j<=s2.length();j++)
			{
				if(i==0 || j==0)
				{
					cache[i][j]=0;
				}
				else if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					cache[i][j]=cache[i-1][j-1]+1;
					if(length<cache[i][j])
					{
						length=cache[i][j];
						row=i;
						col=j;
					}
				}
				else
				{
					cache[i][j]=0;
				}
			}
		}
		
		String sub="";
		if(length==0)
		{
			sub="";
		}
		else 
		{
			while(cache[row][col]!=0)
			{
				sub=s1.charAt(row-1)+sub;
				length--;
				row--;
				col--;
			}
		}
		return sub;
	}

}
