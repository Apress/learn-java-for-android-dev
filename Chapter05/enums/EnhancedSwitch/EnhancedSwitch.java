// EnhancedSwitch.java

public class EnhancedSwitch
{
   private enum Coin { PENNY, NICKEL, DIME, QUARTER }
   public static void main(String[] args)
   {
      Coin coin = Coin.NICKEL;
      switch (coin)
      {
         case PENNY  : System.out.println("1 cent"); break;
         case NICKEL : System.out.println("5 cents"); break;
         case DIME   : System.out.println("10 cents"); break;
         case QUARTER: System.out.println("25 cents");
         default     : assert false;
      }
   }
}
