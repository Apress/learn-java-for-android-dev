// ArrayListDemo.java

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo
{
   public static void main(String[] args)
   {
      List<String> ls = new ArrayList<String>();
      String[] weekDays = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      for (String weekDay: weekDays)
         ls.add(weekDay);
      dump("ls:", ls);
      ls.set(ls.indexOf("Wed"), "Wednesday");
      dump("ls:", ls);
      ls.remove(ls.lastIndexOf("Fri"));
      dump("ls:", ls);
   }
   static void dump(String title, List<String> ls)
   {
      System.out.print(title + " ");
      for (String s: ls)
         System.out.print(s + " ");
      System.out.println();
   }
}
