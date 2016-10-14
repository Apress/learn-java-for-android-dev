// DateFormatDemo.java

import java.text.DateFormat;

import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateFormatDemo
{
   public static void main(String[] args)
   {
      Date d = new Date(0); // Unix epoch
      System.out.println(d);
      DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG,
                                                     DateFormat.LONG,
                                                     Locale.US);
      System.out.println("Default format: " + df.format(d));
      df.setTimeZone(TimeZone.getTimeZone("UTC"));
      System.out.println("Taking UTC into account: " + df.format(d));
   }
}
