// LinkedListDemo.java

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListDemo
{
   public static void main(String[] args)
   {
      List<String> ls = new LinkedList<String>();
      String[] weekDays = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      for (String weekDay: weekDays)
         ls.add(weekDay);
      dump("ls:", ls);
      ls.add(1, "Sunday");
      ls.add(3, "Monday");
      ls.add(5, "Tuesday");
      ls.add(7, "Wednesday");
      ls.add(9, "Thursday");
      ls.add(11, "Friday");
      ls.add(13, "Saturday");
      dump("ls:", ls);
      ListIterator<String> li = ls.listIterator(ls.size());
      while (li.hasPrevious())
         System.out.print(li.previous() + " ");
      System.out.println();
   }
   static void dump(String title, List<String> ls)
   {
      System.out.print(title + " ");
      for (String s: ls)
         System.out.print(s + " ");
      System.out.println();
   }
}
