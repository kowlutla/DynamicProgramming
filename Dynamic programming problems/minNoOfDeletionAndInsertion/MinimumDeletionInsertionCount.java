package minNoOfDeletionAndInsertion;

import java.util.Scanner;

/**
 * @author kowlutla Given two strings S1 and S2 ,count the minimum no of
 *         deletion and insertion operations required to transform s1 into s2 by
 *         inserting and deleting the characters
 * 
 *         Input: S1:"Great" s2:"Create" Output: 1 deletion and 2 insertion
 *         Explanation: We need to delete {'g'} and insert {'c','e'} to
 *         transform s1 into s2
 *
 */
public class MinimumDeletionInsertionCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter String1: ");
		String s1 = sc.nextLine();
		System.out.print("Enter String2: ");
		String s2 = sc.nextLine();

		int array1[] = new int[255];
		int array2[] = new int[255];

		// count each character of string1 and store in array1
		for (int i = 0; i < s1.length(); i++) {
			array1[s1.charAt(i)]++;
		}

		// count each character of string2 and store in array2
		for (int i = 0; i < s2.length(); i++) {
			array2[s2.charAt(i)]++;
		}

		int no_of_operation[]=getNoOfDeletionsInsertions(array1,array2);
		
		int delete=no_of_operation[0];
		int insert=no_of_operation[1];
		System.out.println("No of Deletions: "+delete);
		System.out.println("No of Insertions: "+insert);
		
		sc.close();
	}

	private static int[] getNoOfDeletionsInsertions(int[] array1, int[] array2) {
		
		int delete=0;
		int insert=0;
		for(int i=0;i<array1.length;i++)
		{
			if(array1[i]>array2[i])
			{
				delete=delete+(array1[i]-array2[i]);
			}
			else
			{
				insert=insert+(array2[i]-array1[i]);
			}
		}
		return new int[] {delete,insert};
		
		
	}

}
