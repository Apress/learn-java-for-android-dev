// MyLocale.java

import java.util.Locale;

public class MyLocale
{
   public static void main(String[] args)
   {
      System.out.println(Locale.getDefault());
      Locale.setDefault(Locale.CANADA);
      System.out.println(Locale.getDefault());
   }
}
