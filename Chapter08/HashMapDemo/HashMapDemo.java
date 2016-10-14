// HashMapDemo.java

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo
{
   public static void main(String[] args)
   {
      Map<String, Integer> argMap = new HashMap<String, Integer>();
      for (String arg: args)
      {
         Integer count = argMap.get(arg);
         argMap.put(arg, (count == null) ? 1 : count+1);
      }
      System.out.println(argMap);
      System.out.println("Number of distinct arguments = " + argMap.size());
   }
}
