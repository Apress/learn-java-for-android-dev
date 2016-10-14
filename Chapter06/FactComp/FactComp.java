// FactComp.java

import java.math.BigInteger;

class FactComp
{
   public static void main(String[] args)
   {
      System.out.println(factorial(12));
      System.out.println();
      System.out.println(factorial(20L));
      System.out.println();
      System.out.println(factorial(170.0));
      System.out.println();
      System.out.println(factorial(new BigInteger("170")));
      System.out.println();
      System.out.println(factorial(25.0));
      System.out.println();
      System.out.println(factorial(new BigInteger("25")));
   }
   public static int factorial(int n)
   {
      if (n == 0)
         return 1;
      else
         return n*factorial(n-1);
   }
   public static long factorial(long n)
   {
      if (n == 0)
         return 1;
      else
         return n*factorial(n-1);
   }
   public static double factorial(double n)
   {
      if (n == 1.0)
         return 1.0;
      else
         return n*factorial(n-1);
   }
   public static BigInteger factorial(BigInteger n)
   {
      if (n.equals(BigInteger.ZERO))
         return BigInteger.ONE;
      else
         return n.multiply(factorial(n.subtract(BigInteger.ONE)));
   }
}
