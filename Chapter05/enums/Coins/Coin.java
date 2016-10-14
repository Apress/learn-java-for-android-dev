// Coin.java

public enum Coin
{
   PENNY(1),
   NICKEL(5),
   DIME(10),
   QUARTER(25);

   private final int denomValue;
   Coin(int denomValue)
   {
      this.denomValue = denomValue;
   }
   public int denomValue()
   {
      return denomValue;
   }
   public int toDenomination(int numPennies)
   {
      return numPennies/denomValue;
   }
}
