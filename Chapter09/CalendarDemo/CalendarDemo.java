// CalendarDemo.java

import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class CalendarDemo
{
   public static void main(String[] args)
   {
      if (args.length < 2)
      {
         System.err.println("usage: java CalendarDemo yyyy mm [f|F]");
         return;
      }
      try
      {
         int year = Integer.parseInt(args[0]);
         int month = Integer.parseInt(args[1]);
         Locale locale = Locale.US;
         if (args.length == 3 && args[2].equalsIgnoreCase("f"))
            locale = Locale.FRANCE;
         showPage(year, month, locale);
      }
      catch (NumberFormatException nfe)
      {
         System.err.print(nfe);
      }
   }
   static void showPage(int year, int month, Locale locale)
   {
      if (month < 1 || month > 12)
         throw new IllegalArgumentException("month [" + month + "] out of " +
                                            "range [1, 12]");
      Calendar cal = Calendar.getInstance(locale);
      cal.set(Calendar.YEAR, year);
      cal.set(Calendar.MONTH, --month);
      cal.set(Calendar.DAY_OF_MONTH, 1);
      displayMonthAndYear(cal, locale);
      displayWeekdayNames(cal, locale);
      int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
      int firstRowGap = cal.get(Calendar.DAY_OF_WEEK)-1; // 0 = Sunday
      for (int i = 0; i < firstRowGap; i++)
         System.out.print("   ");
      for (int i = 1; i <= daysInMonth; i++)
      {
         if (i < 10)
            System.out.print(' ');
         System.out.print(i);
         if ((firstRowGap+i)%7 == 0)
            System.out.println();
         else
            System.out.print(' ');
      }
      System.out.println();
   }
   static void displayMonthAndYear(Calendar cal, Locale locale)
   {
      System.out.println(cal.getDisplayName(Calendar.MONTH, Calendar.LONG,
                                            locale) + " " +
                                            cal.get(Calendar.YEAR));
   }
   static void displayWeekdayNames(Calendar cal, Locale locale)
   {
      Map<String, Integer> weekdayNamesMap;
      weekdayNamesMap = cal.getDisplayNames(Calendar.DAY_OF_WEEK,
                                            Calendar.SHORT, locale);
      String[] names = new String[weekdayNamesMap.size()];
      int[] indexes = new int[weekdayNamesMap.size()];
      Set<Map.Entry<String, Integer>> weekdayNamesEntries;
      weekdayNamesEntries = weekdayNamesMap.entrySet();
      Iterator<Map.Entry<String, Integer>> iter;
      iter = weekdayNamesEntries.iterator();
      while (iter.hasNext())
      {
         Map.Entry<String, Integer> entry = iter.next();
         names[entry.getValue()-1] = entry.getKey();
         indexes[entry.getValue()-1] = entry.getValue();
      }
      for (int i = 0; i < names.length; i++)
         for (int j = i; j < names.length; j++)
            if (indexes[j] == i+1)
            {
               System.out.print(names[j].substring(0, 2) + " ");
               continue;
            }
      System.out.println();
   }
}
