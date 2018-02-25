public class Palindrome 
{

	public static void main(String[] args) 
		{
		for (int i = 0; i < args.length; i++) 
			{
			String s = args[i];
			if (isPalindrome(s))
				System.out.println(s+"    Palindrome");
			else
				System.out.println(s+"    Not Palindrome");
			} 
		}
	
	
	public static String reverseString(String s)
	{	String f="";
		
		for (int i = s.length()-1; i >=0 ; i--)
			f+=s.charAt(i);
		
		return f;
	}

    public static boolean isPalindrome(String s)
	{
		String f;
		f=reverseString(s);
		if(s.equals(f))
			return true;
		else
			return false;
		
	}
	
	
}