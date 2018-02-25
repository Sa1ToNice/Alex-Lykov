public class Primes {
	public static void main(String[] args) 
	{
	
		for (int i = 2; i<=100; i++)
		{
		if (isPrime(i))	
		 System.out.println("Simple number - "+i);
			   else 
		 System.out.println("Not simple number  - "+i);
		}
	}	


	public static boolean isPrime(int n)
		{
		for ( int i = 2; i<n ; i++)
			if (n%i==0)
			   return false;		
			
		return true;
		}

}