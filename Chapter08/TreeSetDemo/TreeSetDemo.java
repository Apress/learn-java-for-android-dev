// TreeSetDemo.java

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo
{
   public static void main(String[] args)
   {
      Set<String> ss = new TreeSet<String>();
      String[] fruits = {"apples", "pears", "grapes", "bananas", "kiwis"};
      for (String fruit: fruits)
         ss.add(fruit);
      dump("ss:", ss);
   }
   static void dump(String title, Set<String> ss)
   {
      System.out.print(title + " ");
      for (String s: ss)
         System.out.print(s + " ");
      System.out.println();
   }
}
