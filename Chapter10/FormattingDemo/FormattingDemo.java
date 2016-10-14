// FormattingDemo.java

import java.util.Calendar;
import java.util.Locale;

public class FormattingDemo
{
   public static void main(String[] args)
   {
      String name = "John Doe";
      int age = 36;
      System.out.printf("Name = %s, age = %d%n", name, age);
      System.out.printf(Locale.FRANCE, "e = %10.4f%n", Math.E);
      System.out.printf("e = %10.4f%n", Math.E);
      Calendar cal = Calendar.getInstance();
      System.out.printf("Current time = %tR, ", cal).printf("%tT%n", cal);
      System.out.printf("Current date = %tD%n", cal);
   }
}
