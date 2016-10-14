// GCD.java

public class GCD
{
   public static void main(String[] args)
   {
      System.out.println(gcd(18, 12));
   }
   public static int gcd(int a, int b)
   {
      // The greatest common divisor is the largest positive integer that
      // divides evenly into two positive integers a and b. For example,
      // GCD(12,18) is 6.
      
      if (b == 0) // Base problem
         return a;
      else
         return gcd(b, a%b);
   }
}