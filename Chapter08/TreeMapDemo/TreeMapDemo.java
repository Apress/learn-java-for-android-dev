// TreeMapDemo.java

import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo
{
   public static void main(String[] args)
   {
      Map<String, Integer> msi = new TreeMap<String, Integer>();
      String[] fruits = {"apples", "pears", "grapes", "bananas", "kiwis"};
      int[] quantities = {10, 15, 8, 17, 30};
      for (int i = 0; i < fruits.length; i++)
         msi.put(fruits[i], quantities[i]);
      for (Map.Entry<String, Integer> entry: msi.entrySet())
         System.out.println(entry.getKey() + ": " + entry.getValue());
   }
}
