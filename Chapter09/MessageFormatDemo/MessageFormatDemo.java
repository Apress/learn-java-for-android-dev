// MessageFormatDemo.java

import java.text.MessageFormat;

import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageFormatDemo
{
   public static void main(String[] args)
   {
      dumpMessages(Locale.US);
      System.out.println();
      dumpMessages(Locale.FRANCE);
   }
   static void dumpMessages(Locale locale)
   {
      ResourceBundle rb = ResourceBundle.getBundle("example", locale);
      MessageFormat mf = new MessageFormat(rb.getString("p1"), locale);
      Calendar cal = Calendar.getInstance(locale);
      cal.set(Calendar.YEAR, 2010);
      cal.set(Calendar.MONTH, Calendar.JUNE);
      cal.set(Calendar.DAY_OF_MONTH, 16);
      Object[] args = new Object[] { 10536, cal.getTime() };
      System.out.println(mf.format(args));
      mf.applyPattern(rb.getString("p2"));
      args = new Object[] { 25 };
      System.out.println(mf.format(args));
      mf.applyPattern(rb.getString("p3"));
      args = new Object[] { 10567.0 };
      System.out.println(mf.format(args));
   }
}
