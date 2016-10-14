// Calc.java

public class Calc
{
   public static void main(String[] args)
   {
      if (args.length != 3)
      {
         System.err.println("usage: java Calc value1 op value2");
         System.err.println("op is one of +, -, *, or /");
         return;
      }
      try
      {
         double value1 = Double.parseDouble(args[0]);
         double value2 = Double.parseDouble(args[2]);
         if (args[1].equals("+"))
            System.out.println(value1+value2);
         else
         if (args[1].equals("-"))
            System.out.println(value1-value2);
         else
         if (args[1].equals("*"))
            System.out.println(value1*value2);
         else
         if (args[1].equals("/"))
            System.out.println(value1/value2);
         else
            System.err.println("invalid operator: " + args[1]);
      }
      catch (NumberFormatException nfe)
      {
         System.err.println("Bad number format: " + nfe.getMessage());
      }
   }
}
