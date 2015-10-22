
//To check if a number is prime or not

public class PrimeCheck {
	public static void main(String[] args) {
		PrimeCheck pc = new PrimeCheck();
		int n = 25;
		int ans = pc.IsPrime(n);
		System.out.println(n + " " + ans);
	}
	
	int IsPrime(int number) {
		if (number == 1)
			return 0;
		
	    if (number <= 3 && number>1) 
	        return 1;            // as 2 and 3 are prime
	    
	    if (number%2==0 || number%3==0) 
	        return 0;     // check if number is divisible by 2 or 3
	    
        for (int i=5; i*i<=number; i+=6) {
            if (number % i == 0 || number%(i + 2) == 0) 
                return 0;
        }
        return 1; 
	}
}
