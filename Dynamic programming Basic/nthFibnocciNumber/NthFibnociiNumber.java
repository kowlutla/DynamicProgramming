package nthFibnocciNumber;

import java.util.Scanner;

public class NthFibnociiNumber {

	//recursive method 
	//Time O(2^n)
	public static int fibM1(int n)
	{
		if(n<2)
		{
			return n;
		}
		return fibM1(n-1)+fibM1(n-2);
	}
	
	//top down approach
	//Time complexity-O(n)
	//Time Complexity-O(n)
	
	public static int fibM2(int n)
	{
		int cache[]=new int[n+1];
		if(n<2)
		{
			return n;
		}
		
		if(cache[n]!=0)
		{
			return cache[n];
		}
		
		return cache[n]=fibM2(n-1)+fibM2(n-2);
	}
	
	
	//Bottom up approach
	//Time complexity-O(n)
	//space complexity-O(n)
	
	public static int fibM3(int n)
	{
		int cache[]=new int[n+1];
		//base cases
	
		cache[0]=0;
		cache[1]=1;
		for(int i=2;i<=n;i++)
		{
			cache[i]=cache[i-1]+cache[i-2];
		}
		return cache[n];
	}
	
	
	//Most efficient solution
	//Time complexity-O(n)
	//Space complexity-O(1)
	
	public static int fibM4(int n)
	{
		int first=0,second=1,sum=0;
		if(n<2)
		{
			return n;
		}
		for(int i=2;i<=n;i++)
		{
			sum=first+second;
			first=second;
			second=sum;
		}
		return sum;
	}
	
	
	public static void Method1(int n)
	{
		long startTime=0,endTime=0,executionTime=0;
		startTime=System.nanoTime();
		System.out.println("Method 1 result: "+fibM1(n));
		endTime=System.nanoTime();
		executionTime=endTime-startTime;
		System.out.println("ExecutionTime for Method 1: "+executionTime);
	}
	
	
	public static void Method2(int n)
	{
		long startTime=0,endTime=0,executionTime=0;
		startTime=System.nanoTime();
		System.out.println("Method 2 result: "+fibM2(n));
		endTime=System.nanoTime();
		executionTime=endTime-startTime;
		System.out.println("ExecutionTime for Method 2: "+executionTime);
	}
	
	public static void Method3(int n)
	{
		long startTime=0,endTime=0,executionTime=0;
		startTime=System.nanoTime();
		System.out.println("Method 3 result: "+fibM3(n));
		endTime=System.nanoTime();
		executionTime=endTime-startTime;
		System.out.println("ExecutionTime for Method 3: "+executionTime);
	}
	
	public static void Method4(int n)
	{
		long startTime=0,endTime=0,executionTime=0;
		startTime=System.nanoTime();
		System.out.println("Method 4 result: "+fibM4(n));
		endTime=System.nanoTime();
		executionTime=endTime-startTime;
		System.out.println("ExecutionTime for Method 4: "+executionTime);
	}
	
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Nth number: ");
		int n=sc.nextInt();
		Method1(n);
		Method2(n);
		Method3(n);
		Method4(n);
		sc.close();

	}
	
	
	
	
	
	
	

}
