// Coins.java

public class Coins
{
   public static void main(String[] args)
   {
      if (args.length == 1)
      {
         int numPennies = Integer.parseInt(args[0]);
         System.out.println(numPennies + " pennies is equivalent to:");
         int numQuarters = Coin.QUARTER.toDenomination(numPennies);
         System.out.println(numQuarters + " " + Coin.QUARTER.toString() +
                            (numQuarters != 1 ? "s," : ","));
         numPennies -= numQuarters*Coin.QUARTER.denomValue();
         int numDimes = Coin.DIME.toDenomination(numPennies);
         System.out.println(numDimes + " " + Coin.DIME.toString() +
                            (numDimes != 1 ? "s, " : ","));
         numPennies -= numDimes*Coin.DIME.denomValue();
         int numNickels = Coin.NICKEL.toDenomination(numPennies);
         System.out.println(numNickels + " " + Coin.NICKEL.toString() +
                            (numNickels != 1 ? "s, " : ", and"));
         numPennies -= numNickels*Coin.NICKEL.denomValue();
         System.out.println(numPennies + " " + Coin.PENNY.toString() +
                            (numPennies != 1 ? "s" : ""));
      }
      System.out.println();
      System.out.println("Denomination values:");
      for (int i = 0; i < Coin.values().length; i++)
         System.out.println(Coin.values()[i].denomValue());
   }
}
