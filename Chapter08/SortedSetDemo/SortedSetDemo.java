// SortedSetDemo.java

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo
{
   public static void main(String[] args)
   {
      SortedSet<String> sss = new TreeSet<String>();
      String[] fruitAndVeg =
      {
         "apple", "potato", "turnip", "banana", "corn", "carrot", "cherry",
         "pear", "mango", "strawberry", "cucumber", "grape", "banana",
         "kiwi", "radish", "blueberry", "tomato", "onion", "raspberry",
         "lemon", "pepper", "squash", "melon", "zucchini", "peach", "plum",
         "turnip", "onion", "nectarine"
      };
      System.out.println("Array size = " + fruitAndVeg.length);
      for (String fruitVeg: fruitAndVeg)
         sss.add(fruitVeg);
      dump("sss:", sss);
      System.out.println("Sorted set size = " + sss.size());
      System.out.println("First element = " + sss.first());
      System.out.println("Last element = " + sss.last());
      System.out.println("Comparator = " + sss.comparator());
      dump("hs:", sss.headSet("n"));
      dump("ts:", sss.tailSet("n"));
      System.out.println("Count of p-named fruits & vegetables = " +
                         sss.subSet("p", "q").size());
      System.out.println("Incorrect count of c-named fruits & vegetables = " +
                         sss.subSet("carrot", "cucumber").size());
      System.out.println("Correct count of c-named fruits & vegetables = " +
                         sss.subSet("carrot", "cucumber\0").size());
   }
   static void dump(String title, SortedSet<String> sss)
   {
      System.out.print(title + " ");
      for (String s: sss)
         System.out.print(s + " ");
      System.out.println();
   }
}
