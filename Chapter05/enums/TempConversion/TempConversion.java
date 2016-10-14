// TempConversion.java

public enum TempConversion
{
   C2F("Celsius to Fahrenheit")
   {
      @Override
      public double convert(double value)
      {
         return value*9.0/5.0+32.0;
      }
   },
   F2C("Fahrenheit to Celsius")
   {
      @Override
      public double convert(double value)
      {
         return (value-32.0)*5.0/9.0;
      }
   };

   TempConversion(String desc)
   {
      this.desc = desc;
   }
   private String desc;
   @Override
   public String toString()
   {
      return desc;
   }
   public abstract double convert(double value);
   public static void main(String[] args)
   {
      System.out.println(C2F + " for 100.0 degrees = " +
                         C2F.convert(100.0));
      System.out.println(F2C + " for 98.6 degrees = " + 
                         F2C.convert(98.6));
   }
}
